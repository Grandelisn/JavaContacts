package com.example.javacontacts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;

@SpringBootApplication
public class JavaContactsApplication {

    public static void main(String[] args) {

        SpringApplication.run(JavaContactsApplication.class, args);
    }

}
