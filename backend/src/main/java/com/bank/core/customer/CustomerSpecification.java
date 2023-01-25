package com.bank.core.customer;

import org.springframework.data.jpa.domain.Specification;

import java.text.MessageFormat;

public class CustomerSpecification {
    public static Specification<Customer> firstNameContains(String value) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("firstName"), value));
    }

    public static Specification<Customer> lastNameContains(String value) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("lastName"), value));
    }

    public static Specification<Customer> birthDateContains(String value) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("birthDate"), value));
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
