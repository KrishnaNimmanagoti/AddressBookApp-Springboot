package com.bridgelabz.addressbookapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.addressbookapp.dto.ContactDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.model.Contact;


@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
	
	Contact contact;
	
	@PostMapping
	public ResponseEntity<ResponseDTO> addContact(@RequestBody ContactDTO contactDTO) {
		contact = new Contact(contactDTO);
		return new ResponseEntity<ResponseDTO>(
                new ResponseDTO(contact, "AddressBook created successfully"),
                HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<ResponseDTO> getContact() {
		if (contact != null)
			return new ResponseEntity<ResponseDTO>(new ResponseDTO(contact, "AddressBook Fetched successfully"),HttpStatus.CREATED);
		else
			return new ResponseEntity<ResponseDTO>(new ResponseDTO(contact, "AddressBook is Empty"),HttpStatus.CREATED);
	}

}
