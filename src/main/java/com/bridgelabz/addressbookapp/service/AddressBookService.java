package com.bridgelabz.addressbookapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.addressbookapp.dto.ContactDTO;
import com.bridgelabz.addressbookapp.model.Contact;
import com.bridgelabz.addressbookapp.repo.IAddressBookRepo;

/**
 * connection with server
 * 
 * @author Krishna
 *
 */
@Service
public class AddressBookService implements IAddressBookService {

	@Autowired
	private IAddressBookRepo addressBookRepo;

	/**
	 * method add new Contact
	 * 
	 * @param contact
	 * @return Contact
	 */
	@Override
	public Contact addContact(ContactDTO contactDTO) {
		Contact contact = new Contact(contactDTO);
		return this.addressBookRepo.save(contact);
	}

	/**
	 * method to get list of Contacts
	 * 
	 * @return list of Contacts
	 */
	@Override
	public List<Contact> getContacts() {
		return addressBookRepo.findAll();
	}

	/**
	 * method to get Contact by id
	 * 
	 * @param personId
	 * @return Contact Data
	 */
	@Override
	public Optional<Contact> getContactById(Integer personId) {
		return addressBookRepo.findById(personId);
	}

	/**
	 * method to update a contact by id
	 * 
	 * @param personId
	 * @param Contact
	 * @return Contact details
	 */
	@Override
	public Contact updateContact(ContactDTO contactDTO, Integer personId) {

		return addressBookRepo.findById(personId).map(contact -> {
			contact.setFullName(contactDTO.getFullName());
			contact.setPhone(contactDTO.getPhone());
			contact.setEmail(contactDTO.getEmail());
			contact.setAddress(contactDTO.getAddress());
			contact.setCity(contactDTO.getCity());
			contact.setState(contactDTO.getState());
			contact.setZip(contactDTO.getZip());
			return this.addressBookRepo.save(contact);
		}).orElseGet(() -> {
			return this.addContact(contactDTO);
		});

	}

	/**
	 * method to delete a contact by id
	 * 
	 * @param personId
	 * @param deleted  contact data
	 */
	@Override
	public Optional<Contact> deleteContact(Integer personId) {
		Optional<Contact> contact = addressBookRepo.findById(personId);
		addressBookRepo.deleteById(personId);
		return contact;
	}
}
