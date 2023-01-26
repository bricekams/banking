package com.bank.core.customer;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

import java.text.MessageFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CustomerSpecification {
    public static Specification<Customer> firstNameContains(String value) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("firstName"), value));
    }

    public static Specification<Customer> lastNameContains(String value) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("lastName"), value));
    }

    public static Specification<Customer> birthDateContains(String value) {
        LocalDate localDate;
        try {
            localDate = LocalDate.parse(value, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (DateTimeException e) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), "Bad date format");
        }
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("birthDate"), localDate));
    }

    public static Specification<Customer> cityOfBirthContains(String value) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("cityOfBirth"), value));
    }

    public static Specification<Customer> nicIdContains(String value) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("nicId"), value));
    }

    public static Specification<Customer> emailContains(String value) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("email"), value));
    }

    public static Specification<Customer> phoneNumberContains(Integer value) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("phoneNumber"), value));
    }

    public static Specification<Customer> hasActiveAccountContains(Boolean value) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("hasActiveAccount"), value));
    }

    private static String contains(String expression) {
        return MessageFormat.format("%{0}%", expression);
    }
}
