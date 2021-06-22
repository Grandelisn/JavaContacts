package com.example.javacontacts.repository;

import com.example.javacontacts.models.Contact;
import com.example.javacontacts.models.Phone;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
//@Query(value = "SELECT * FROM contact inner join phone WHERE phone.type = 'home'", nativeQuery = true)
public interface ContactRepository extends CrudRepository<Contact, Long> {
    @Query("from Contact c inner join c.phone p where p.type = 'home'")
    List<Contact> findCallList();
}
