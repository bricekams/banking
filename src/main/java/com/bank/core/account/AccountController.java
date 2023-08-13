package com.bank.core.account;


import com.bank.core.Helpers;
import com.bank.core.account.utils.NewAccountRecord;
import com.bank.core.customer.Customer;
import com.bank.core.customer.CustomerRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;

import org.springframework.web.server.ResponseStatusException;

import java.time.OffsetDateTime;
import java.util.*;

import static com.bank.core.account.AccountSpecification.*;

public class AccountController {
    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;

    public AccountController(CustomerRepository customerRepository, AccountRepository accountRepository) {
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
    }

    public List<Account> getAccounts(
            Integer creationYear,
            Integer creationMonth,
            Integer creationDay,
            String creationDate,
            String before,
            String after,
            String ownerId,
            HttpServletRequest httpServletRequest) {
        if (httpServletRequest.getParameterMap().values().toArray().length < 1) {
            //no params
            return accountRepository.findAll();
        }
        Customer owner = ownerId == null? null : customerRepository.findById(ownerId).orElseThrow(()-> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "customer does not exist");
        });
        Specification<Account> specification = Specification
                .where(creationYear == null ? null : creationYearEqual(creationYear))
                .and(creationMonth == null ? null : creationMonthEqual(creationMonth))
                .and(creationDay == null ? null : creationDayEqual(creationDay))
                .and(creationDate == null ? null : creationDateEqual(creationDate))
                .and(before == null ? null : creationDateBefore(before))
                .and(after == null ? null : creationDateAfter(after))
                .and(ownerId == null ? null : accountOwnerId(owner));

        return accountRepository.findAll(specification);
    }

    public void createAccount(NewAccountRecord newAccountRecord) {
        Account account = new Account();
        customerRepository.findById(newAccountRecord.ownerId()).ifPresentOrElse(owner -> {
            account.setOwner(owner);
            account.setAccountName(newAccountRecord.accountName());
            account.setAccountNumber(UUID.randomUUID()); //todo: you'll definitely have to work on this
            account.setCreatedOn(OffsetDateTime.now());
            account.setBalance(0F);
            this.accountRepository.save(account);
        }, () -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Owner does not exist");
        });
    }

    public void updateAccount(Long accountNumber, HashMap<String, Object> data) {
        Optional<Account> customer = accountRepository.findById(accountNumber);
        customer.ifPresentOrElse(e -> {
            for (Map.Entry<String, Object> entry : data.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (key.equals("accountName")) {
                    e.setAccountName((String) value);
                } else {
                    System.out.println("put request bad format");
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unrecognized field");
                }
            }
            accountRepository.save(e);
        }, () -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account does not exist");
        });
    }
}
