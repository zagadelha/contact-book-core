package com.contactbook.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONTACT")
public class Contact implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = false, nullable = false)
	private String name;

	@Column(unique = true, nullable = false)
	private String email;

	@Column(unique = false, nullable = false)
	private String telephone;

	public Contact() {
	}

	public Contact(String name, String email, String telephone) {
		this.name = name;
		this.email = email;
		this.telephone = telephone;
	}

	public Contact(Long id, String name, String email, String telephone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.telephone = telephone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "Name: " + getName() + "| Email: " + getEmail() + " | Telefone: " + getTelephone();
	}

}
