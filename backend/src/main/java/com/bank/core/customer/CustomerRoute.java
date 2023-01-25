package com.bank.core.customer;

import com.bank.core.account.Account;
import com.bank.core.account.AccountController;
import com.bank.core.account.AccountRepository;
import com.bank.core.action.Action;
import com.bank.core.action.ActionRepository;
import com.bank.core.action.utils.NewActionRecord;
import com.bank.core.customer.utils.NewCusomerRecord;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerRoute {

    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;
    private final ActionRepository actionRepository;



    public CustomerRoute(CustomerRepository customerRepository,
                         AccountRepository accountRepository,
                         ActionRepository actionRepository
                         ) {
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
        this.actionRepository = actionRepository;
    }

    @GetMapping
    public List<Customer> getAllCustomers(
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
        return new CustomerController(customerRepository).getAllCustomers(firstName, lastName, birthDate, cityOfBirth, nicId, email, phoneNumber, hasActiveAccount, httpServletRequest);
    }

    @PostMapping
    public void registerCustomer(@RequestBody NewCusomerRecord newCusomerRecord) {
        new CustomerController(customerRepository).registerCustomer(newCusomerRecord);
    }

    @GetMapping("{customerId}")
    public Customer getCostumerByID(@PathVariable("customerId") Long customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    @PutMapping("{customerId}")
    public void updateCustomerData(@PathVariable("customerId") Long customerId, @RequestBody HashMap<String, Object> data) {
        new CustomerController(customerRepository).updateCustomerData(customerId, data);
    }

    @GetMapping("{customerId}/accounts")
    public List<Account> getCustomerAccounts(@PathVariable("customerId") Long customerId){
        return accountRepository.findByOwner(customerRepository.findById(customerId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Owner does not exist in database")));
    }

    @GetMapping("{customerId}/accounts/{accountNumber}")
    public Account getCustomerAccountByAccountNumber(@PathVariable("accountNumber") Long accountNumber){
        return accountRepository.findById(accountNumber).orElse(null);
    }

    @GetMapping("{customerId}/accounts/{accountNumber}/actions")
    public List<Action> getCustomerAccountActions(@PathVariable("accountNumber") Long accountNumber){
        return actionRepository.findByEventfulAccount(accountRepository.findById(accountNumber).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Account does not exist")));
    }

    @GetMapping("{customerId}/accounts/{accountNumber}/actions/{actionId}")
    public Action getCustomerAccountActionByActionId(@PathVariable("actionId") Long actionId){
        return actionRepository.findById(actionId).orElse(null);
    }
}
