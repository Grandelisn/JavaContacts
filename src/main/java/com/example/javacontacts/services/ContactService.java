package com.example.javacontacts.services;

import com.example.javacontacts.models.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> findAll();

    Contact findContactById(long id);

    List<Contact> getCallList();

    void delete(long id);

    Contact save(Contact contact);

    Contact update(Contact contact, long id);

    void deleteAll();
}
