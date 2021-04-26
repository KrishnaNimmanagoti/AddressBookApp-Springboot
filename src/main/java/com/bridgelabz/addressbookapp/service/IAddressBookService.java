package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.ContactDTO;
import com.bridgelabz.addressbookapp.model.Contact;

public interface IAddressBookService {
	
	Contact addContact(ContactDTO contactDTO);
	
	Contact getContact();

}
