package com.example.javacontacts.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
/**
* Model that defines the address object
*/
@Entity
@Table(name = "address")
@JsonIgnoreProperties({"contact", "id"})
public class Address extends Auditable {

    /**
     * Generates a unique id for each Address
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "addressId")
    private Long id;
    /**
     * Creates a One To One relationship with one contact and an address
     */
    @OneToOne(mappedBy = "address")
    private Contact contact;
    /**
     *The street (String) for an address
     */
    private String street;
    /**
     *The city (String) for an address
     */
    private String city;
    /**
     *The state (String) for an address
     */
    private String state;
    /**
     *The zip code (String) for an address
     */
    private String zip;

    /**
     * Basic constructor for persistence
     */
    public Address() {
    }
    /**
     * Basic constructor for persistence with parameters
     * Accepts all attributes of an address and a contact it is associated with.
     */
    public Address(String street, String city, String state, String zip, Contact contact) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.contact = contact;
    }
    //Getters and Setters
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

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

}
