package com.example.javacontacts.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Model that defines a Phone
 */
@Entity
@Table(name = "phone")
@JsonIgnoreProperties({"contact", "id"})
public class Phone extends Auditable {
    /**
     * Generates a unique id for each phone
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "phoneId")
    private Long id;
    /**
     *  Creates a Many To one relationship with one contact able to have multiple phone numbers
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contactId")
    private Contact contact;
    /**
     *The type (String) for a contact
     */
    @Column(name = "type")
    private String type;
    /**
     *The phone number (String) for a contact
     */
    private String number;
    /**
     * Basic constructor for persistence
     */
    public Phone() {
    }
    /**
     * Basic constructor for persistence with parameters
     * Accepts all attributes of a phone.
     */
    public Phone(String number, String type) {
        this.number = number;
        this.type = type;
    }
    //Getters and Setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

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

}
