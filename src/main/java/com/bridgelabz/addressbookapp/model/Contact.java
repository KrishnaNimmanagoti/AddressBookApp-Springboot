package com.bridgelabz.addressbookapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.bridgelabz.addressbookapp.dto.ContactDTO;

@Entity
public class Contact {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	private String firstName;
	private String lastName;
    
    public Contact(ContactDTO contact) {
        this.firstName = contact.getFirstName();
        this.lastName = contact.getLastName();
        this.address = contact.getAddress();
    }
    
    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	private String address;
    
	public Contact() {
    }

	@Override
	public String toString() {
		return "Contact [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ "]";
	}
	
	
 
}
