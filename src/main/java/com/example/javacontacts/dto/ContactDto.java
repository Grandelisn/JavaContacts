package com.example.javacontacts.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactDto {

    private long id;
    private NameDto name;
    private Set<AddressDto> addresses;
    private Set<PhoneDto> phone;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public NameDto getName() {
        return name;
    }

    public void setName(NameDto name) {
        this.name = name;
    }

    public Set<AddressDto> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<AddressDto> addresses) {
        this.addresses = addresses;
    }

    public Set<PhoneDto> getPhone() {
        return phone;
    }

    public void setPhone(Set<PhoneDto> phone) {
        this.phone = phone;
    }
}
