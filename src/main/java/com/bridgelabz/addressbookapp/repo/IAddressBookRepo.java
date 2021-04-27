package com.bridgelabz.addressbookapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.addressbookapp.model.Contact;

@Repository
public interface IAddressBookRepo extends JpaRepository<Contact, Integer>{

}
