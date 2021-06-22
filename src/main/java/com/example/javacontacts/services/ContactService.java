package com.example.javacontacts.services;

import com.example.javacontacts.dto.CallListDto;
import com.example.javacontacts.models.Contact;

import java.util.List;

/**
 * This class defines all of the actions for the /contacts endpoint
 */
public interface ContactService {
    /**
     * This class returns all contacts
     * @return A list of contacts(List<>)
     */
    List<Contact> findAll();
    /**
     * This class returns a specific contact
     * @param id The id of a contact
     * @return A specific contact(Contact)
     */
    Contact findContactById(long id);
    /**
     * This class returns all contacts who have home phone numbers
     * @return A list of contacts and their phone numbers(List<>)
     */
    List<CallListDto> getCallList();
    /**
     * This class deletes a contact
     * @param id The id of a contact
     */
    void delete(long id);
    /**
     * This class deletes a contact
     * @param contact The contact object you want to save
     * @return A copy of the contact object you saved.
     */
    Contact save(Contact contact);
    /**
     * This class updates a contact
     * @param contact The contact object you want to update
     * @param id The id of the contact you are updating
     * @return A copy of the contact object you saved.
     */
    Contact update(Contact contact, long id);
    /**
     * This class deletes all contacts
     * Useful when testing
     */
    void deleteAll();
}
