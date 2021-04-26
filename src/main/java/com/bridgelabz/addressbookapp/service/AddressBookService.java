package com.bridgelabz.addressbookapp.service;

import org.springframework.stereotype.Service;

import com.bridgelabz.addressbookapp.dto.ContactDTO;
import com.bridgelabz.addressbookapp.model.Contact;

@Service
public class AddressBookService implements IAddressBookService {

	Contact contact;
	
	@Override
	public Contact addContact(ContactDTO contactDTO) {
		
		contact = new Contact(contactDTO);
		return contact;
	}

	@Override
	public Contact getContact() {
		return contact;
	}
	
	

}
