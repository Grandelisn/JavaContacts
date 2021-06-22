package com.example.javacontacts.repository;

import com.example.javacontacts.models.Name;
import org.springframework.data.repository.CrudRepository;
/**
 * Repository for all Name Objects
 */
public interface NameRepository extends CrudRepository<Name, Long> {
}
