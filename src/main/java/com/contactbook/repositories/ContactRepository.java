package com.contactbook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.contactbook.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

	@Query("SELECT c FROM Contact c where c.email = :email")
	Contact findEmail(@Param("email") String email);

}
