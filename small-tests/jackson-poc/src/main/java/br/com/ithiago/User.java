package br.com.ithiago;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class User {

    private String name;

    @JsonUnwrapped
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
