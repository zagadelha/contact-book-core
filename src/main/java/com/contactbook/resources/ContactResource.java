package com.contactbook.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.contactbook.entities.Contact;
import com.contactbook.services.ContactBookService;

@RestController
@RequestMapping(value = "/contact-book")
public class ContactResource {

	@Autowired
	private ContactBookService service;

	@GetMapping(value = "/list")
	public ResponseEntity<List<Contact>> list() {
		List<Contact> list = service.list();
		return ResponseEntity.ok(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Contact> findById(@PathVariable Long id) {
		Contact contact = service.get(id);
		return ResponseEntity.ok(contact);
	}

	@GetMapping(value = { "/remove/{id}" })
	public ResponseEntity<String> removeById(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.ok("Contato removido com sucesso!");
	}

	@PostMapping(value = "/add")
	public ResponseEntity<String> add(@RequestParam String name, @RequestParam String email,
			@RequestParam String telefone) {

		boolean exists = service.emailExist(email);

		if (exists) {
			return ResponseEntity.ok("Email já cadastrado!");
		} else {
			Contact contact = new Contact(name, email, telefone);
			service.save(contact);
			return ResponseEntity.ok("Contato cadastrado com sucesso!");
		}
	}

	@PostMapping(value = "/edit")
	public ResponseEntity<String> add(@RequestParam Long id, @RequestParam String name, @RequestParam String email,
			@RequestParam String telefone) {

		Contact contact = new Contact(id, name, email, telefone);
		service.update(contact);
		return ResponseEntity.ok("Contato atualizado com sucesso!");
	}

}
