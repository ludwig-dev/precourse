const API = "http://localhost:8080/api/addresses";

function loadAddresses() {
    fetch(API)
        .then(res => res.json())
        .then(data => renderList(data));
}

function addAddress() {
    const body = {
        name: document.getElementById("name").value,
        street: document.getElementById("street").value,
        city: document.getElementById("city").value,
        zip: document.getElementById("zip").value
    };

    fetch(`${API}/create`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(body)
    })
        .then(() => {
            clearInputs();
            loadAddresses();
        });
}

function deleteAddress(id) {
    fetch(`${API}/${id}`, { method: "DELETE" })
        .then(() => loadAddresses());
}

function editAddress(id) {
    const name = prompt("New name:");
    const street = prompt("New street:");
    const city = prompt("New city:");
    const zip = prompt("New zip:");

    const body = { name, street, city, zip };

    fetch(`${API}/${id}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(body)
    })
        .then(() => loadAddresses());
}


function searchAddress() {
    const name = document.getElementById("searchName").value;
    const street = document.getElementById("searchStreet").value;

    let url = `${API}/search?`;
    if (name) url += `name=${encodeURIComponent(name)}&`;
    if (street) url += `street=${encodeURIComponent(street)}`;

    fetch(url)
        .then(res => res.json())
        .then(data => renderList(data));
}

function renderList(data) {
    const list = document.getElementById("addressList");
    list.innerHTML = "";
  
    data.forEach(addr => {
      const li = document.createElement("li");
      li.innerHTML = `
        <strong>${addr.name}</strong> — ${addr.street}, ${addr.city} (${addr.zip})
        <button onclick="deleteAddress('${addr.id}')">🗑️</button>
        <button onclick="editAddress('${addr.id}')">✏️</button>
      `;
      list.appendChild(li);
    });
  }
  

function clearInputs() {
    ["name", "street", "city", "zip"].forEach(id => document.getElementById(id).value = "");
}

loadAddresses();
