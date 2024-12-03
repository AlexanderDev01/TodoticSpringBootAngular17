/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.todotic.contactlistapi.service;

import com.todotic.contactlistapi.entity.Contact;
import com.todotic.contactlistapi.repository.ContactRepository;
import com.todotic.contactlistapi.dto.ContactDTO;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ContactService {
    
    private final ContactRepository contactRepository;
    
    public Iterable<Contact> findAll() {
        return contactRepository.findAll();
    }
    
    public Contact findById(Integer id) {
        return contactRepository.findById(id).orElse(null);
    }
    
    public Contact create(ContactDTO contactDTO) {      
        ModelMapper mapper = new ModelMapper();
        Contact contact = mapper.map(contactDTO, Contact.class);
        contact.setCreatedAt(LocalDateTime.now());
        return contactRepository.save(contact);
    }
    
    public Contact update(Integer id, ContactDTO contactDTO) {
        Contact contactFromDb = findById(id);
        
        ModelMapper mapper = new ModelMapper();
        mapper.map(contactDTO, contactFromDb);
        
        return contactRepository.save(contactFromDb);
    }
    
    public void delete(Integer id) {
        Contact contactFromDb = findById(id);
        contactRepository.delete(contactFromDb);
    }
    
}
