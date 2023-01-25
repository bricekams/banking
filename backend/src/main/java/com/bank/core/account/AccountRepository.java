package com.bank.core.account;
import com.bank.core.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account,Long>, JpaSpecificationExecutor<Account> {
    Account findByAccountNumber(Long accountNumber);

    List<Account> findByOwner(Customer owner);
}
