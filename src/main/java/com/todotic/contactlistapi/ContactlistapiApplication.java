package com.todotic.contactlistapi;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.todotic.contactlistapi.entity.Contact;

@SpringBootApplication
public class ContactlistapiApplication {

	public static void main(String[] args) { SpringApplication.run(ContactlistapiApplication.class, args);
	
		CommandLineRunner runner() {
			List<Contact> contacts = Arrays.asList(
				
				new Contact("Carlos", "carlos@gmail.com", LocalDateTime.now()),
				new Contact("Juan", "juan@gmail.com", LocalDateTime.now()),
				new Contact("Marcelo", "agachateYconocelo@gmail.com", LocalDateTime.now()),
				new Contact("Luis", "luis@gmail.com", LocalDateTime.now()),
				new Contact("Erich", "erich@gmail.com", LocalDateTime.now())
			);
		}
	
	}

}
