package com.bank.core.branch;

import com.bank.core.account.Account;
import com.bank.core.account.AccountRepository;
import com.bank.core.action.Action;
import com.bank.core.action.ActionRepository;
import com.bank.core.branch.utils.NewBranchRecord;
import com.bank.core.customer.CustomerRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/v1/branches")
public class BranchRoute {
    private final BranchRepository branchRepository;
    private final AccountRepository accountRepository;
    private final ActionRepository actionRepository;
    private final CustomerRepository customerRepository;

    public BranchRoute(BranchRepository branchRepository, AccountRepository accountRepository, ActionRepository actionRepository, CustomerRepository customerRepository) {
        this.branchRepository = branchRepository;
        this.accountRepository = accountRepository;
        this.actionRepository = actionRepository;
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<Branch> getBranches(
            @RequestParam(required = false, name = "town") String town,
            @RequestParam(required = false, name = "numberOfAccountMoreThan") Long numberOfAccountMoreThan,
            @RequestParam(required = false, name = "numberOfAccountLessThan") Long numberOfAccountLessThan,
            HttpServletRequest httpServletRequest
    ) {
        return new BranchController(branchRepository).getBranches(town,numberOfAccountMoreThan,numberOfAccountLessThan,httpServletRequest);
    }

    @PostMapping
    public void createBranch(@RequestBody NewBranchRecord newBranchRecord) {
        new BranchController(branchRepository).createBranch(newBranchRecord);
    }

    @GetMapping("/{branchId}")
    public Branch getBranchById(@PathVariable("branchId") Long branchId) {
        return branchRepository.findById(branchId).orElse(null);
    }

    @GetMapping("/{branchId}/accounts")
    public List<Account> getAccountsInBranch(@PathVariable("branchId") Long branchId) {
        return accountRepository.findByCreationBranch(branchRepository.findById(branchId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Branch does not exist")));
    }

    @GetMapping("/{branchId}/accounts/{accountNumber}")
    public Account getAccountInBranchByNumber(@PathVariable("accountNumber") Long accountNumber) {
        return accountRepository.findById(accountNumber).orElse(null);
    }

    @GetMapping("/{branchId}/accounts/{accountNumber}/action")
    public List<Action> getActionsOfAccountInBranch(@PathVariable("accountNumber") Long accountNumber) {
        return actionRepository.findByEventfulAccount(accountRepository.findById(accountNumber).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Account does not exist")));
    }

    @GetMapping("/{branchId}/accounts/{accountId}/action/{actionId}")
    public Action getActionByIdOfAccountInBranch(@PathVariable("actionId") Long actionId) {
        return actionRepository.findById(actionId).orElse(null);
    }
}
