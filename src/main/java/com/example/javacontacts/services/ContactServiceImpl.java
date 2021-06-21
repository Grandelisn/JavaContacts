package com.example.javacontacts.services;

import com.example.javacontacts.exceptions.ResourceNotFoundException;
import com.example.javacontacts.models.Contact;
import com.example.javacontacts.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service("contactService")
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactRepository contactRepo;

    @Override
    public List<Contact> findAll() {
        List<Contact> list = new ArrayList<>();
        contactRepo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Contact findContactById(long id) {
        return contactRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contact with id " + " Not Found!"));
    }

    @Override
    public List<Contact> getCallList(){
        return contactRepo.getCallList();
    }
    @Transactional
    @Override
    public void delete(long id) {
        if (contactRepo.findById(id)
                .isPresent()) {
            contactRepo.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Contact with id " + id + " Not Found!");
        }
    }

    @Transactional
    @Override
    public Contact save(Contact contact) {


        Contact newContact = new Contact();
        newContact.setContactId(contact.getContactId());
        newContact.setName(contact.getName());
        newContact.setAddress(contact.getAddress());
        newContact.setPhone(contact.getPhone());
        newContact.setEmail(contact.getEmail());
        return contactRepo.save(newContact);
    }

    @Transactional
    @Override
    public Contact update(Contact contact, long id) {

        Contact currentContact = findContactById(id);

        if (contact.getName() != null) {

            currentContact.setName(contact.getName());
        }

        if (contact.getAddress() != null) {

            currentContact.setAddress(contact.getAddress());
        }
        if (contact.getPhone() != null) {
            currentContact.setPhone(contact.getPhone());
        }

        return contactRepo.save(currentContact);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void deleteAll() {
        contactRepo.deleteAll();
    }

}
