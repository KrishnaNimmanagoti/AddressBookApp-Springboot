package com.bridgelabz.addressbookapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.addressbookapp.dto.ContactDTO;
import com.bridgelabz.addressbookapp.model.Contact;
import com.bridgelabz.addressbookapp.repo.IAddressBookRepo;

@Service
public class AddressBookService implements IAddressBookService {

	@Autowired
	private IAddressBookRepo addressBookRepo;
	
	@Override
	public Contact addContact(ContactDTO contactDTO) {
		Contact contact = new Contact(contactDTO);
		return this.addressBookRepo.save(contact);
	}

	@Override
	public List<Contact> getContacts() {
		return addressBookRepo.findAll();
	}
	
	@Override
	public Contact updateContact(ContactDTO contactDTO, Integer id) {
		
		return addressBookRepo.findById(id)
		.map(contact -> {
			contact.setFirstName(contactDTO.getFirstName());
			contact.setLastName(contactDTO.getLastName());
			contact.setAddress(contactDTO.getAddress());
			return this.addressBookRepo.save(contact);
		})
		.orElseGet(() -> {
			return this.addContact(contactDTO);
		});
		
	}

	@Override
	public Optional<Contact> deleteContact(Integer id) {
		Optional<Contact> contact = addressBookRepo.findById(id);
		addressBookRepo.deleteById(id);
		return contact;
	}
	

}
