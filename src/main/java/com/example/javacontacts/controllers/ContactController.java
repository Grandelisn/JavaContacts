package com.example.javacontacts.controllers;

import com.example.javacontacts.dto.CallListDto;
import com.example.javacontacts.models.Contact;
import com.example.javacontacts.services.ContactService;
import org.h2.command.dml.Call;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping
public class ContactController {

    @Autowired
    ContactService contactService;

    @GetMapping(value = "/contacts", produces = {"application/json"})
    public ResponseEntity<?> listAllContacts(HttpServletRequest request) {
        List<Contact> contacts = contactService.findAll();
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    @GetMapping(value = "/contacts/{contactId}", produces = {"application/json"})
    public ResponseEntity<?> getContactById(HttpServletRequest request, @PathVariable Long contactId) {
        Contact contact = contactService.findContactById(contactId);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }
    @GetMapping(value = "/contacts/call-list", produces = {"application/json"})
    public ResponseEntity<?> getCallList(HttpServletRequest request) {
        List<CallListDto> contact = contactService.getCallList();
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }
    @PostMapping(value = "/contacts", consumes = "application/json")
    public ResponseEntity<?> addNewContact(@Valid @RequestBody Contact newContact) throws URISyntaxException {
        newContact.setContactId(0);
        newContact = contactService.save(newContact);
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newContactURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{contactId}")
                .buildAndExpand(newContact.getContactId())
                .toUri();
        responseHeaders.setLocation(newContactURI);
        return new ResponseEntity<>(newContact, responseHeaders, HttpStatus.CREATED);
    }

    @PutMapping(value = "/contacts/{contactId}", consumes = "application/json")
    public ResponseEntity<?> updateContact(@Valid @RequestBody Contact updateContact, @PathVariable long contactId) {
        updateContact.setContactId(contactId);
        contactService.save(updateContact);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/contacts/{contactId}")
    public ResponseEntity<?> deleteContactById(@PathVariable long contactId) {
        contactService.delete(contactId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
