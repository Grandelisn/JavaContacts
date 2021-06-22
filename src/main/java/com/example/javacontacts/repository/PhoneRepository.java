package com.example.javacontacts.repository;

import com.example.javacontacts.models.Phone;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PhoneRepository extends CrudRepository<Phone, Long> {

    @Query("from Phone where type = 'home'")
    List<Phone> findCallList();
}
