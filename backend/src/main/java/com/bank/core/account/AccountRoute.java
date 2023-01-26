package com.bank.core.account;

import com.bank.core.account.utils.NewAccountRecord;
import com.bank.core.action.Action;
import com.bank.core.action.ActionRepository;
import com.bank.core.customer.CustomerRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;

//todo: implement methods AccountRoute
@RestController
@RequestMapping("api/v1/accounts")
public class AccountRoute {

    private final ActionRepository actionRepository;
    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;


    public AccountRoute(ActionRepository actionRepository, AccountRepository accountRepository, CustomerRepository customerRepository) {
        this.actionRepository = actionRepository;
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<Account> getAccounts(
            @RequestParam(required = false, value = "creationYear") Integer creationYear,
            @RequestParam(required = false, value = "creationMonth") Integer creationMonth,
            @RequestParam(required = false, value = "creationDay") Integer creationDay,
            @RequestParam(required = false, value = "creationDate") String creationDate,
            @RequestParam(required = false, value = "createdBefore") String createdBefore,
            @RequestParam(required = false, value = "createdAfter") String createdAfter,
            @RequestParam(required = false, value = "ownerId") String ownerId,
            HttpServletRequest httpServletRequest
    ) {
        return new AccountController(customerRepository,accountRepository).getAccounts(creationYear,creationMonth,creationDay,creationDate,createdBefore,createdAfter,ownerId,httpServletRequest);
    }

    @PostMapping
    public void createAccount(@RequestBody NewAccountRecord newAccountRecord) {
        new AccountController(customerRepository,accountRepository).createAccount(newAccountRecord);
    }

    @GetMapping("/{accountNumber}")
    public Account getAccountByAccountNumber(@PathVariable("accountNumber") Long accountNumber) {
        return accountRepository.findById(accountNumber).orElse(null);
    }

    @PutMapping("/{accountNumber}")
    public void updateAccount(@PathVariable("accountNumber") Long accountNumber, HashMap<String, Object> data){
        new AccountController(customerRepository,accountRepository).updateAccount(accountNumber,data);
    }
    @GetMapping("/{accountNumber}/actions")
    public List<Action> getAccountActions(@PathVariable("accountNumber") Long accountNumber) {
        return actionRepository.findByEventfulAccount(accountRepository.findById(accountNumber).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Account does not exist")));
    }

    @GetMapping("/{accountNumber}/action/{actionId}")
    public Action getActionInAccountById(@PathVariable("actionId") Long actionId) {
        return actionRepository.findById(actionId).orElse(null);
    }

}
