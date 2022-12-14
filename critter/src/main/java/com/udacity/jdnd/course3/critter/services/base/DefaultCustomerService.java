package com.udacity.jdnd.course3.critter.services.base;

import com.udacity.jdnd.course3.critter.entities.Customer;

import java.util.List;

public interface DefaultCustomerService {
    List<Customer> getAllCustomers();
    Customer getCustomerByPetId(long petId);
    Customer saveCustomer(Customer customer, List<Long> petIds);
}