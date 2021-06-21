package com.example.javacontacts.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "address")
@JsonIgnoreProperties({"contact", "id"})
public class Address extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "addressId")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "contact_id")
    private Contact contact;


    private String street;

    private String city;
    private String state;
    private String zip;

    public Address() {
    }

    public Address(String street, String city, String state, String zipCode, Contact contact) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zipCode;
        this.contact = contact;
    }
    // region Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zip;
    }

    public void setZipCode(String zip) {
        this.zip = zip;
    }

}
