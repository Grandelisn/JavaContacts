package com.example.javacontacts.repository;

import com.example.javacontacts.models.Phone;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
/**
 * Repository for all Phone Objects
 */
public interface PhoneRepository extends CrudRepository<Phone, Long> {
}
