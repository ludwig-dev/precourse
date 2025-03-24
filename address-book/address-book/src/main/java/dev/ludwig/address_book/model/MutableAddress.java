package dev.ludwig.address_book.model;

import jakarta.validation.constraints.NotBlank;

public class MutableAddress {
    @NotBlank
    private String name;

    @NotBlank
    private String street;

    private String city;
    private String zip;

    public MutableAddress() {}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getZip() { return zip; }
    public void setZip(String zip) { this.zip = zip; }
}
