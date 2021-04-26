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
    private String address;
    
	public Contact() {
    }

    public Contact(ContactDTO contact) {
        this.firstName = contact.getFirstName();
        this.lastName = contact.getLastName();
        this.address = contact.getAddress();
    }
    
    public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}


    @Override
	public String toString() {
		return "Contact [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ "]";
	}
    
}
