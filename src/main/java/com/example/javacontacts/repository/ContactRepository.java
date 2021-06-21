package com.example.javacontacts.repository;

import com.example.javacontacts.models.Contact;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContactRepository extends CrudRepository<Contact, Long> {

    @Query(value = "SELECT * FROM Contact c LEFT OUTER JOIN Phone p on p.type = home", nativeQuery = true)
    List<Contact> getCallList();
}
