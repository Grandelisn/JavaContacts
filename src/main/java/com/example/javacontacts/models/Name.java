package com.example.javacontacts.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
/**
 * Model that defines a Name
 */
@Entity
@Table(name = "name")
@JsonIgnoreProperties("id")
public class Name extends Auditable {
    /**
     * Generates a unique id for each name
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    /**
     *The first, middle, and last names (String) for a contact
     */
    private String first;
    private String middle;
    private String last;
    /**
     * Basic constructor for persistence
     */
    public Name() {
    }
    /**
     * Basic constructor for persistence with parameters
     * Accepts all attributes of a name.
     */
    public Name(String first, String middle, String last) {
        this.first = first;
        this.middle = middle;
        this.last = last;
    }
    //Getters and Setters
    public long getNameId() {
        return id;
    }

    public void setNameId(long id) {
        this.id = id;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getMiddle() {
        return middle;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }
}
