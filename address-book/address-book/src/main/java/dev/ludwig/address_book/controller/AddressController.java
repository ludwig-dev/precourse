package dev.ludwig.address_book.controller;

import dev.ludwig.address_book.model.Address;
import dev.ludwig.address_book.model.MutableAddress;
import dev.ludwig.address_book.repository.AddressRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    private final AddressRepository repository;

    public AddressController(AddressRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Address> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Address getById(@PathVariable String id) {
        return repository.findById(id);
    }

    @PostMapping("/create")
    public Address create(@Valid @RequestBody MutableAddress data) {
        Address newAddress = new Address(
                UUID.randomUUID().toString(),
                data.getName(),
                data.getStreet(),
                data.getCity(),
                data.getZip()
        );
        return repository.create(newAddress);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable String id, @Valid @RequestBody MutableAddress data) {
        Address updated = new Address(
                id,
                data.getName(),
                data.getStreet(),
                data.getCity(),
                data.getZip()
        );
        repository.update(updated, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repository.delete(id);
    }

    @GetMapping("/search")
    public List<Address> search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String street
    ) {
        return repository.search(name, street);
    }

}
