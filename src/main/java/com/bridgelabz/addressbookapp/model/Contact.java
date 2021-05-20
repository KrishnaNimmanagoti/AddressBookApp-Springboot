package com.bridgelabz.addressbookapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.bridgelabz.addressbookapp.dto.ContactDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String fullName;
	private String phone;
	private String email;
	private String address;
	private String city;
	private String state;
	private String zip;

	public Contact(ContactDTO contactDTO) {
		this.fullName = contactDTO.getFullName();
		this.phone = contactDTO.getPhone();
		this.email = contactDTO.getEmail();
		this.address = contactDTO.getAddress();
		this.city = contactDTO.getCity();
		this.state = contactDTO.getState();
		this.zip = contactDTO.getZip();
	}
}
