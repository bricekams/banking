package com.bank.core.customer;

import jakarta.persistence.*;
import lombok.Builder;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;

import java.util.Objects;
@Builder
@Entity(name = "customers")
public class Customer {

    @Id
    private String customerId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    @Column(unique = true)
    private String nicId; // national identity card number
    private Boolean hasActiveAccount;
    private String pin;


    public Customer(String customerId, String firstName, String lastName, LocalDate birthDate,String nicId,Boolean hasActiveAccount) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.nicId = nicId;
        this.hasActiveAccount = hasActiveAccount;
    }

    public Customer() {
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }



    public String getNicId() {
        return nicId;
    }

    public void setNicId(String nicId) {
        this.nicId = nicId;
    }


    public Boolean getHasActiveAccount() {
        return hasActiveAccount;
    }

    public void setHasActiveAccount(Boolean hasActiveAccount) {
        this.hasActiveAccount = hasActiveAccount;
    }


    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerId.equals(customer.customerId) && firstName.equals(customer.firstName) && lastName.equals(customer.lastName) && birthDate.equals(customer.birthDate) && cityOfBirth.equals(customer.cityOfBirth) && nicId.equals(customer.nicId) && phoneNumber.equals(customer.phoneNumber) && email.equals(customer.email) && profilePicture.equals(customer.profilePicture) && hasActiveAccount.equals(customer.hasActiveAccount) && password.equals(customer.password) && pin.equals(customer.pin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, firstName, lastName, birthDate, nicId, hasActiveAccount, pin);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", nicId='" + nicId + '\'' +
                ", hasActiveAccount=" + hasActiveAccount +
                ", pin='" + pin + '\'' +
                '}';
    }
}

