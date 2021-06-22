package com.example.javacontacts.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;
/**
 * Model that defines a Contact
 */
@Entity
@Table(name = "contact")
public class Contact extends Auditable {

    /**
     * Generates a unique id for each Contact
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnoreProperties("contactId")
    private long contactId;
    /**
     *  Creates a One To One relationship with one contact able to have one address
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "addressId")
    private Address address;
    /**
     *  Creates a One To One relationship with one contact able to have one name
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "name_id", referencedColumnName = "id")
    @JsonIgnoreProperties("nameId")
    private Name name;
    /**
     *  Creates a One To Many relationship with one contact able to have multiple phone numbers
     */
    @OneToMany(cascade = CascadeType.ALL)
    @Column(name = "phone")
    private List<Phone> phone;
    /**
     * Each contact has one associated email
     * Each email is validated for structure and to see if a contact was already created with this email
     * While not required for this exercise, it allows for a level of authentication for User systems where
     * you do not want duplicates
     */
    @Column(nullable = false, unique = true)
    @Email
    private String email;
    /**
     * Basic constructor for persistence
     */
    public Contact() {
    }
    /**
     * Basic constructor for persistence with parameters
     * Accepts all attributes of an contact.
     */
    public Contact(Name name, Address address, List<Phone> phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
    //Getters and Setters
    public long getContactId() {
        return contactId;
    }

    public void setContactId(long contactId) {
        this.contactId = contactId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public List<Phone> getPhone() {
        return phone;
    }

    public void setPhone(List<Phone> phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
