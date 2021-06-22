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

@Transactional
@Service("contactService")
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactRepository contactRepo;

    @Autowired
    PhoneRepository phoneRepo;

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
    public List<CallListDto> getCallList(){
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
                System.out.println("Type: " + p.getType() + "#" + p.getNumber());
                if(p.getType().equals(test.getType())){
                    System.out.println("Type: " + p.getType() + "#" + p.getNumber());
                    callList.setPhone(p);
                }
            }
            callListDtos.add(callList);
        }
//        List<CallListDto> callListDtos = new ArrayList<>();
//        for (Contact c:
//             list) {
//            CallListDto cList = new CallListDto();
//            cList.setName(c.getName());
//            for (Phone p:
//                 c.getPhone()) {
//
//                if(p.getType() == "home"){
//                    cList.setPhone(p);
//                }
//            }
//
//        }
        return callListDtos;
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
