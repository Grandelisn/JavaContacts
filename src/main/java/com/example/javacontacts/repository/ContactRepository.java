package com.example.javacontacts.repository;

import com.example.javacontacts.models.Contact;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
/**
 * Repository for all Contact Objects
 */
public interface ContactRepository extends CrudRepository<Contact, Long> {
    /**
     * Custom Query to grab all contacts that have home phone numbers
     * @return A list of contacts (List<>) that have home phone numbers
     */
    @Query("from Contact c inner join c.phone p where p.type = 'home'")
    List<Contact> findCallList();
}
