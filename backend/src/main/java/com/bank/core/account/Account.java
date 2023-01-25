package com.bank.core.account;
import com.bank.core.customer.Customer;
import jakarta.persistence.*;


import java.time.OffsetDateTime;
import java.util.Objects;

@Entity(name = "accounts")
public class Account {
    @Id
    private Long accountNumber;
    private String accountName;
    @ManyToOne
    @JoinColumn(name = "ownerId", referencedColumnName = "customerId", nullable = false)
    private Customer owner;
    private OffsetDateTime createdOn;
    private Float balance;

    public Account() {
    }

    public Account(Long number, Customer owner, OffsetDateTime createdOn, Float balance, String accountName) {
        this.accountNumber = number;
        this.accountName = accountName;
        this.owner = owner;
        this.createdOn = createdOn;
        this.balance = balance;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public OffsetDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(OffsetDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountNumber.equals(account.accountNumber) && accountName.equals(account.accountName) && owner.equals(account.owner) && createdOn.equals(account.createdOn) && balance.equals(account.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, accountName, owner, createdOn, balance);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", accountName='" + accountName + '\'' +
                ", owner=" + owner +
                ", createdOn=" + createdOn +
                ", balance=" + balance +
                '}';
    }
}
