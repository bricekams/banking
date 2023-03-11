package com.bank.core.action;

import com.bank.core.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ActionRepository extends JpaRepository<Action,Long>, JpaSpecificationExecutor<Action> {
    List<Action> findByEventfulAccount(Account account);
}
