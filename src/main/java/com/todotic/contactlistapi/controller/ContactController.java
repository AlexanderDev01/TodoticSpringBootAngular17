package com.todotic.contactlistapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todotic.contactlistapi.entity.Contact;
import com.todotic.contactlistapi.service.ContactService;
import com.todotic.contactlistapi.dto.ContactDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@CrossOrigin
@AllArgsConstructor
@RequestMapping("/api/contacts")
@RestController
public class ContactController {
    
    private final ContactService contactService;

    @GetMapping
    public Iterable<Contact> list() {
        return contactService.findAll();
    }
    
    @GetMapping("{id}")
    public Contact get(@PathVariable Integer id) {
        return contactService.findById(id);
    }
    
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Contact create(@RequestBody ContactDTO contactDTO) {
        return contactService.create(contactDTO);
    }
    
    @PutMapping("{id}")
    public Contact update(@PathVariable Integer id, 
                          @RequestBody ContactDTO contactDTO) {
        return contactService.update(id, contactDTO);
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        contactService.delete(id);
    }
}
