package com.example.javacontacts.services;

import com.example.javacontacts.dto.CallListDto;
import com.example.javacontacts.exceptions.ResourceNotFoundException;
import com.example.javacontacts.models.Contact;
import com.example.javacontacts.models.Phone;
import com.example.javacontacts.repository.ContactRepository;
import com.example.javacontacts.repository.PhoneRepository;
import org.aspectj.weaver.ast.Call;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

/**
 * Service that holds all logic for the /contacts endpoints
 */
@Transactional
@Service("contactService")
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactRepository contactRepo;

    /**
     * @see ContactService
     * @return List of Contacts
     */
    @Override
    public List<Contact> findAll() {
        List<Contact> list = new ArrayList<>();
        contactRepo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }
    /**
     * @see ContactService
     * @param id
     * @return A contact or an exception if the contact does not exist
     */
    @Override
    public Contact findContactById(long id) {
        return contactRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contact with id " + " Not Found!"));
    }
    /**
     * @see ContactService
     * @return A list of contacts and their phone numbers(List<>)
     */
    @Override
    public List<CallListDto> getCallList(){
        /**
         * This function grab a list of contacts from the database who have home phone numbers
         * In the interest of speedy delivery I loop through list assigning names to the DTO and type check each number
         * This is not efficient and with more robust database functionality in production these can be handled by SQL
         * queries
         */
        List<Contact> list = new ArrayList<>();
        List<CallListDto> callListDtos = new ArrayList<>();
        contactRepo.findCallList().iterator().forEachRemaining(list::add);
        Phone test = new Phone();
        test.setType("home");
        for (Contact c:
             list) {
            CallListDto callList = new CallListDto();
            callList.setName(c.getName());
            for (Phone p:
                 c.getPhone()) {
                if(p.getType().equals(test.getType())){
                    callList.setPhone(p);
                }
            }
            callListDtos.add(callList);
        }
        return callListDtos;
    }

    /**
     * @see ContactService
     * @param id The id of a contact
     */
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

    /**
     * @see ContactService
     * @param contact The contact object you want to save
     * @return A contact that was saved.
     */
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

    /**
     * @see ContactService
     * @param contact The contact object you want to update
     * @param id The id of the contact you are updating
     * @return The updated contact
     */
    @Transactional
    @Override
    public Contact update(Contact contact, long id) {
        //To remove the repetitive if statements an algorithm could be written to check each attribute for a change
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
        if (contact.getName() != null) {

            currentContact.setName(contact.getName());
        }

        if (contact.getAddress() != null) {

            currentContact.setAddress(contact.getAddress());
        }
        if (contact.getEmail() != null) {
            currentContact.setEmail(contact.getEmail());
        }
        return contactRepo.save(currentContact);
    }

    /**
     * @see ContactService
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void deleteAll() {
        contactRepo.deleteAll();
    }

}
