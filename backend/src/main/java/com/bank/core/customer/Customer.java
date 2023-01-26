package com.bank.core.customer;

import jakarta.persistence.*;
import lombok.Builder;

import java.time.LocalDate;

import java.util.Objects;
@Builder
@Entity(name = "customers")
public class Customer {
    @Id
    @SequenceGenerator(
            name = "customer_id_sequence",
            sequenceName = "customer_id_sequence",
            allocationSize = 33
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_id_sequence"
    )
    private Long customerId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String cityOfBirth;
    @Column(unique = true)
    private String nicId; // national identity card number
    @Column(unique = true)
    private Long phoneNumber;
    @Column(unique = true)
    private String email;
    private String profilePicture;
    private Boolean hasActiveAccount;


    public Customer(Long customerId, String firstName, String lastName, LocalDate birthDate, String cityOfBirth, String nicId, Long phoneNumber, String email, String profilePicture, Boolean hasActiveAccount) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.cityOfBirth = cityOfBirth;
        this.nicId = nicId;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.profilePicture = profilePicture;
        this.hasActiveAccount = hasActiveAccount;
    }

    public Customer() {
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
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

    public String getCityOfBirth() {
        return cityOfBirth;
    }

    public void setCityOfBirth(String cityOfBirth) {
        this.cityOfBirth = cityOfBirth;
    }

    public String getNicId() {
        return nicId;
    }

    public void setNicId(String nicId) {
        this.nicId = nicId;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Boolean getHasActiveAccount() {
        return hasActiveAccount;
    }

    public void setHasActiveAccount(Boolean hasActiveAccount) {
        this.hasActiveAccount = hasActiveAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerId.equals(customer.customerId) && firstName.equals(customer.firstName) && lastName.equals(customer.lastName) && birthDate.equals(customer.birthDate) && cityOfBirth.equals(customer.cityOfBirth) && nicId.equals(customer.nicId) && phoneNumber.equals(customer.phoneNumber) && email.equals(customer.email) && profilePicture.equals(customer.profilePicture) && hasActiveAccount.equals(customer.hasActiveAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, firstName, lastName, birthDate, cityOfBirth, nicId, phoneNumber, email, profilePicture, hasActiveAccount);
    }
}

