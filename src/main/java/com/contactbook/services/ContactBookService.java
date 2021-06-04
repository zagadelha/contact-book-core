package com.contactbook.services;

import java.util.List;

import com.contactbook.entities.Contact;

/**
 * Simple CRUD operations for Contact entity
 */
public interface ContactBookService {

	List<Contact> list();

	Contact get(Long id);

	Contact save(Contact contact);

	void delete(Long id);

	void update(Contact contact);

	boolean emailExist(String email);

}
