//package com.example.javacontacts.repository;
//
//import com.example.javacontacts.dto.CallListDto;
//import com.example.javacontacts.models.Contact;
//import org.springframework.stereotype.Component;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;
//import java.util.List;
//
//@Component
//public class ContactRepositoryImpl implements ContactRepository{
//
//    @PersistenceContext
//    private EntityManager em;
//
//    @Override
//    public List<CallListDto> getCallList(){
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Contact> cq = cb.createQuery(Contact.class);
//        cq.from(Contact.class);
//
//    }
//}
