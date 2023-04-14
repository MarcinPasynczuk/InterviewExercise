package com.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Object findByEmailAddress(String emailAddress);
}
