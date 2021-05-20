package com.bridgelabz.addressbookapp.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ContactDTO {

	@NotEmpty(message = "Please Enter First Name")
	@Size(min = 3, max = 50)
	private String fullName;

	@NotEmpty(message = "Please Enter Phone Number")
	@Pattern(regexp = "([0-9]{2}[ ]|0)?[6-9][0-9]{9}", message = "Please enter a valid phone")
	private String phone;

	@NotEmpty(message = "Please First Enter Name")
	@Email(message = "Please enter a valid Email")
	private String email;

	@NotEmpty(message = "Please Enter Address")
	private String address;
	
	@NotEmpty(message = "Please First Enter Name")
	@Size(min = 3, max = 50)
	private String city;
	
	@NotEmpty(message = "Please First Enter Name")
	@Size(min = 3, max = 50)
	private String state;
	
	@NotEmpty(message = "Please Enter Zip Code")
	@Pattern(regexp = "[0-9]{6}", message = "Please enter a vali Zip code")
	private String zip;
	


}
