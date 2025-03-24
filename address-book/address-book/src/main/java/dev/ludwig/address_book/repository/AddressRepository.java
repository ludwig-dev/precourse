package dev.ludwig.address_book.repository;

import dev.ludwig.address_book.exception.AddressNotFoundException;
import dev.ludwig.address_book.model.Address;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class AddressRepository {

    private final List<Address> addresses = new ArrayList<>();

    public AddressRepository() {
        addresses.add(new Address(
                UUID.randomUUID().toString(),
                "John Doe",
                "Main Street 1",
                "Stockholm",
                "11122"
        ));
    }

    public List<Address> findAll() {
        return addresses;
    }

    public Address findById(String id) {
        return addresses.stream()
                .filter(address -> address.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new AddressNotFoundException(id));
    }

    public Address create(Address address) {
        addresses.add(address);
        return address;
    }

    public void update(Address updated, String id) {
        Address existing = findById(id);
        int index = addresses.indexOf(existing);
        addresses.set(index, updated);
    }

    public void delete(String id) {
        addresses.removeIf(address -> address.id().equals(id));
    }

    public List<Address> search(String name, String street) {
        return addresses.stream()
                .filter(address ->
                        (name == null || address.name().toLowerCase().contains(name.toLowerCase())) &&
                                (street == null || address.street().toLowerCase().contains(street.toLowerCase()))
                )
                .toList();
    }

}
