package com.example.javacontacts.repository;

import com.example.javacontacts.models.Phone;
import org.springframework.data.repository.CrudRepository;

public interface PhoneRepository extends CrudRepository<Phone, Long> {
}
