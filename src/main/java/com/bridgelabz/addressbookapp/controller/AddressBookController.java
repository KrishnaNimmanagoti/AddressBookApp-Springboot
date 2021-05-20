package com.bridgelabz.addressbookapp.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.addressbookapp.dto.ContactDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.model.Contact;
import com.bridgelabz.addressbookapp.service.IAddressBookService;

/**
 * connection with server
 * 
 * @author Krishna
 *
 */
@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

	@Autowired
	private IAddressBookService addressBookService;

	/**
	 * method add new Contact
	 * 
	 * @param Contact
	 * @return Contact details
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping
	public ResponseEntity<ResponseDTO> addContact(@Valid @RequestBody ContactDTO contactDTO) {
		Contact contact = addressBookService.addContact(contactDTO);
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(contact, "AddressBook created successfully"),
				HttpStatus.CREATED);
	}

	/**
	 * method to get list of Contacts
	 * 
	 * @return list of Contacts
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping
	public ResponseEntity<ResponseDTO> getContacts() {
		List<Contact> contact = addressBookService.getContacts();
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(contact, "AddressBook Fetched successfully"),
				HttpStatus.CREATED);
	}

	/**
	 * method to find person by id
	 * 
	 * @param personId
	 * @return Contact details
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{id}")
	public ResponseEntity<ResponseDTO> getContactById(@PathVariable("id") int personId) {
		Optional<Contact> contact = addressBookService.getContactById(personId);
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(contact, "AddressBook Fetched successfully"),
				HttpStatus.CREATED);
	}

	/**
	 * method to update a Contact
	 * 
	 * @param personId
	 * @param Contact
	 * @return COntact details
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/{id}")
	public ResponseEntity<ResponseDTO> updateContact(@PathVariable("id") Integer personId,
			@Valid @RequestBody ContactDTO contactDTO) {
		Contact contact = addressBookService.updateContact(contactDTO, personId);
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(contact, "Contact Updated successfully"),
				HttpStatus.CREATED);
	}

	/**
	 * method to delete a Contact from DB
	 * 
	 * @param personId
	 * @return Contact details
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseDTO> deleteContact(@PathVariable("id") int personId) {
		Optional<Contact> contact = addressBookService.deleteContact(personId);
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(contact, "Contact Deleted successfully"),
				HttpStatus.CREATED);
	}
}
