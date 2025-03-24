package dev.ludwig.address_book.model;

public record Address(
        String id,
        String name,
        String street,
        String city,
        String zip
) {}
