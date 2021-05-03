package com.bridgelabz.addressbookapp.service;

import java.util.List;
import java.util.Optional;

import com.bridgelabz.addressbookapp.dto.ContactDTO;
import com.bridgelabz.addressbookapp.model.Contact;

public interface IAddressBookService {

	Contact addContact(ContactDTO contactDTO);

	List<Contact> getContacts();

	Contact updateContact(ContactDTO contactDTO, Integer id);

	Optional<Contact> getContactById(Integer id);

	Optional<Contact> deleteContact(Integer personId);

}
