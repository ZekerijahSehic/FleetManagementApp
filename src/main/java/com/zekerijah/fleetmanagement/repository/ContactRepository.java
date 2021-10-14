package com.zekerijah.fleetmanagement.repository;

import com.zekerijah.fleetmanagement.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
