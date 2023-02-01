package com.bank.core.customer;

import com.bank.core.account.AccountRepository;
import com.bank.core.action.ActionRepository;
import com.bank.core.customer.utils.NewCusomerRecord;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerRoute {

    private final CustomerRepository customerRepository;

    public CustomerRoute(CustomerRepository customerRepository
                         ) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<Customer> getAllCustomers(
            @RequestParam(required = false, value = "customerId") String customerId,
            @RequestParam(required = false, value = "firstName") String firstName,
            @RequestParam(required = false, value = "lastName") String lastName,
            @RequestParam(required = false, value = "birthDate") String birthDate,
            @RequestParam(required = false, value = "cityOfBirth") String cityOfBirth,
            @RequestParam(required = false, value = "nicId") String nicId,
            @RequestParam(required = false, value = "email") String email,
            @RequestParam(required = false, value = "phoneNumber") Integer phoneNumber,
            @RequestParam(required = false, value = "hasActiveAccount") Boolean hasActiveAccount
            , HttpServletRequest httpServletRequest
    ) {
        return new CustomerController(customerRepository).getAllCustomers(customerId,firstName, lastName, birthDate, nicId, hasActiveAccount, httpServletRequest);
    }

    @PostMapping
    public void registerCustomer(@RequestBody NewCusomerRecord newCusomerRecord) {
        new CustomerController(customerRepository).registerCustomer(newCusomerRecord);
    }

    @GetMapping("{customerId}")
    public Customer getCostumerByID(@PathVariable("customerId") String customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    @PutMapping("{customerId}")
    public void updateCustomerData(@PathVariable("customerId") String customerId, @RequestBody HashMap<String, Object> data) {
        new CustomerController(customerRepository).updateCustomerData(customerId, data);
    }
}
