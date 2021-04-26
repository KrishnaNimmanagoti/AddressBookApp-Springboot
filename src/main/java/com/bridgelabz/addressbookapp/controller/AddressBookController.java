package com.bridgelabz.addressbookapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.bridgelabz.addressbookapp.service.IAddressBookService;


@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
	
	@Autowired
	private IAddressBookService addressBookService;
	
	@PostMapping
	public ResponseEntity<ResponseDTO> addContact(@RequestBody ContactDTO contactDTO) {
		Contact contact = addressBookService.addContact(contactDTO);
		return new ResponseEntity<ResponseDTO>(
                new ResponseDTO(contact, "AddressBook created successfully"),
                HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<ResponseDTO> getContact() {
		Contact contact = addressBookService.getContact();
		if (contact != null)
			return new ResponseEntity<ResponseDTO>(new ResponseDTO(contact, "AddressBook Fetched successfully"),HttpStatus.CREATED);
		else
			return new ResponseEntity<ResponseDTO>(new ResponseDTO(contact, "AddressBook is Empty"),HttpStatus.CREATED);
	}

}
