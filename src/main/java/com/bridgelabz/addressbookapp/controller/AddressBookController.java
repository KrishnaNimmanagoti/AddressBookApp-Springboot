package com.bridgelabz.addressbookapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.addressbookapp.dto.ContactDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.model.Contact;
import com.bridgelabz.addressbookapp.service.IAddressBookService;


@RestController
public class AddressBookController {
	
	@Autowired
	private IAddressBookService addressBookService;
	
	@PostMapping("/addressbook")
	public ResponseEntity<ResponseDTO> addContact(@RequestBody ContactDTO contactDTO) {
		Contact contact = addressBookService.addContact(contactDTO);
		return new ResponseEntity<ResponseDTO>(
                new ResponseDTO(contact, "AddressBook created successfully"),
                HttpStatus.CREATED);
	}
	
	@GetMapping("/addressbook")
	public ResponseEntity<ResponseDTO> getContacts() {
		List<Contact> contact = addressBookService.getContacts();
		if (contact != null)
			return new ResponseEntity<ResponseDTO>(new ResponseDTO(contact, "AddressBook Fetched successfully"),HttpStatus.CREATED);
		else
			return new ResponseEntity<ResponseDTO>(new ResponseDTO(contact, "AddressBook is Empty"),HttpStatus.CREATED);
	}
	
	@PutMapping("/addressbook/{id}")
	 public ResponseEntity<ResponseDTO> updateContact( @PathVariable Integer id ,@RequestBody ContactDTO contactDTO) {
		Contact contact = addressBookService.updateContact(contactDTO, id);
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(contact, "Contact Updated successfully"),HttpStatus.CREATED);  
	  }
	
	 @DeleteMapping("/addressbook/{id}")
	 public ResponseEntity<ResponseDTO> deleteContact(@PathVariable Integer id) {
		 Optional<Contact> contact = addressBookService.deleteContact(id);
		 return new ResponseEntity<ResponseDTO>(new ResponseDTO(contact, "Contact Deleted successfully"),HttpStatus.CREATED);
	  }

}
