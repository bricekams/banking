package com.bank.core.account;
import com.bank.core.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID>, JpaSpecificationExecutor<Account> {
    Account findByAccountNumber(UUID accountNumber);

    List<Account> findByOwner(Customer owner);
}
