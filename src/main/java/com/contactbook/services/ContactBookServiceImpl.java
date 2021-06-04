package com.contactbook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contactbook.entities.Contact;
import com.contactbook.repositories.ContactRepository;

@Service(value = "contactBookService")
public class ContactBookServiceImpl implements ContactBookService {

	@Autowired
	private ContactRepository repo;

	@Override
	public List<Contact> list() {
		List<Contact> list = repo.findAll();
		return list;
	}

	@Override
	public Contact get(Long id) {
		Contact contact = repo.findById(id).get();
		return contact;
	}

	@Override
	public Contact save(Contact contact) {
		return repo.save(contact);
	}

	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}

	@Override
	public void update(Contact contact) {
		repo.save(contact);
	}

	@Override
	public boolean emailExist(String email) {

		Contact c = repo.findEmail(email);

		if (c != null) {
			return true;
		} else {
			return false;
		}
	}

}
