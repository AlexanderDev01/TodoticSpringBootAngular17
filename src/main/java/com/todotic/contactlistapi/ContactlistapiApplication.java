package com.todotic.contactlistapi;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.todotic.contactlistapi.entity.Contact;
import com.todotic.contactlistapi.repository.ContactRepository;

@SpringBootApplication
public class ContactlistapiApplication {

    public static void main(String[] args) { SpringApplication.run(ContactlistapiApplication.class, args); }
        
        @Bean
        CommandLineRunner runner(ContactRepository contactRepository){
            return args -> {
                List<Contact> contacts = Arrays.asList(
                    new Contact("Carlos", "carlos@gmail.com", LocalDateTime.now()),
                    new Contact("Juan", "juan@gmail.com", LocalDateTime.now()),
                    new Contact("Marcelo", "marcelo@gmail.com", LocalDateTime.now()),
                    new Contact("Luis", "luis@gmail.com", LocalDateTime.now()),
                    new Contact("Erich", "Erich@gmail.com", LocalDateTime.now())
                );
                contactRepository.saveAll(contacts);
            };    
        }
    }
