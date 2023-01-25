package com.bank.core.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long>, JpaSpecificationExecutor<Customer> {
    List<Customer> findByEmail(String email);
    List<Customer> findByNicId(String nic_id);
    List<Customer> findByPhoneNumber(Long phoneNumber);

}
