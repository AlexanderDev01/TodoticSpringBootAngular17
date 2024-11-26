package com.todotic.contactlistapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todotic.contactlistapi.entity.Contact;
import com.todotic.contactlistapi.repository.ContactRepository;
import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RequestMapping("/api/contacts")
@RestController
public class ContactController {
    @Autowired
    private ContactRepository contactRepository;

    @GetMapping
    public Iterable<Contact> list() {
        return contactRepository.findAll();
    }
    
    @GetMapping("{id}")
    public Contact get(@PathVariable Integer id) {
        return contactRepository.findById(id).orElse(null);
    }
    
    @PostMapping
    public Contact create(@RequestBody Contact contact) {
        contact.setCreatedAt(LocalDateTime.now());
        return contactRepository.save(contact);
    }
}
