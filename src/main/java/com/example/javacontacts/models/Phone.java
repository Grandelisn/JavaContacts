package com.example.javacontacts.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;


@Entity
@Table(name = "phone")
@JsonIgnoreProperties({"contact", "id"})
public class Phone extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "phoneId")
    private Long id;

    @ManyToOne
    private Contact contact;

    @Column(name = "type")
    private String type;
    private String number;

    public Phone() {
    }

    public Phone(String number, String type) {
        this.number = number;
        this.type = type;
    }

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
