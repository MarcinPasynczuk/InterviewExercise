package com.challenge.service;

import org.springframework.stereotype.Service;

import com.challenge.model.Customer;
import com.challenge.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    
    public boolean emailExists(String emailAddress) {
        return customerRepository.findByEmailAddress(emailAddress) != null;
    }
}
