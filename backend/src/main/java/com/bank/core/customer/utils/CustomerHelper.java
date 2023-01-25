package com.bank.core.customer.utils;

import com.bank.core.customer.Customer;
import com.bank.core.customer.CustomerRepository;

public class CustomerHelper {
    private final CustomerRepository customerRepository;

    public CustomerHelper(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public boolean customerExist(Customer customer){
        if(customerRepository.findByEmail(customer.getEmail()) != null){
            return true;
        }
        if(customerRepository.findByNicId(customer.getNicId()) != null){
            return true;
        }
        return customerRepository.findByPhoneNumber(customer.getPhoneNumber()) != null;
    }
}
