package com.example.javacontacts.repository;

import com.example.javacontacts.models.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
