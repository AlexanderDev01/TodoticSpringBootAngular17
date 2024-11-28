package com.todotic.contactlistapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todotic.contactlistapi.entity.Contact;
import com.todotic.contactlistapi.repository.ContactRepository;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;



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
    
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Contact create(@RequestBody Contact contact) {
        contact.setCreatedAt(LocalDateTime.now());
        return contactRepository.save(contact);
    }
    
    @PutMapping("{id}")
    public Contact update(@PathVariable Integer id, 
                          @RequestBody Contact form) {
        Contact contactFromDb = contactRepository
                                .findById(id)
                                .orElse(null);
        
        contactFromDb.setName(form.getName());
        contactFromDb.setEmail(form.getEmail());
        
        return contactRepository.save(contactFromDb);
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        Contact contactFromDb = contactRepository
                                .findById(id)
                                .orElse(null);
        contactRepository.delete(contactFromDb);
    }
}
