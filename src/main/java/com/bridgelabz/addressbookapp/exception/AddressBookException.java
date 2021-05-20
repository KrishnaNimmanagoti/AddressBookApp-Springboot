package com.bridgelabz.addressbookapp.exception;

public class AddressBookException extends RuntimeException {

	public final exceptionType type;

	public AddressBookException(exceptionType type, String message) {
		super(message);
		this.type = type;
	}

	public enum exceptionType {
		CONTACT_NOT_FOUND,
	};

}
