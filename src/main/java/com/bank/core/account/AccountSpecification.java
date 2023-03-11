package com.bank.core.account;

import com.bank.core.action.Action;
import com.bank.core.customer.Customer;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Subquery;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;
import java.time.*;
import java.time.format.DateTimeFormatter;


public class AccountSpecification {

    public static Specification<Account> accountOwnerId(Customer value) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("owner"), value));
    }

    public static Specification<Account> creationDateEqual(String value) {
        return ((root, query, criteriaBuilder) -> {
            LocalDate localDate;
            try {
                localDate = LocalDate.parse(value, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            } catch (DateTimeException e) {
                throw new ResponseStatusException(HttpStatusCode.valueOf(400), "Bad date format");
            }
            return criteriaBuilder.equal(root.<OffsetDateTime>get("createdOn").as(LocalDate.class), localDate);
        });
    }

    public static Specification<Account> creationDateBefore(String value) {
        LocalDate localDate;
        try {
            localDate = LocalDate.parse(value, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (DateTimeException e) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), "Bad date format");
        }
        return ((root, query, criteriaBuilder) -> criteriaBuilder.lessThan(root.<OffsetDateTime>get("createdOn").as(LocalDate.class), localDate));
    }

    public static Specification<Account> creationDateAfter(String value) {
        LocalDate localDate;
        try {
            localDate = LocalDate.parse(value, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (DateTimeException e) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), "Bad date format");
        }
        return ((root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.<OffsetDateTime>get("createdOn").as(LocalDate.class), localDate));
    }

    public static Specification<Account> creationYearEqual(Integer value) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.<OffsetDateTime>get("createdOn"), value));
    }

//    public static Specification<Account> numberOfActionsMoreThan(Long value) {
//        return ((root, query, criteriaBuilder) -> {
//            Join<Action, Account> actionAccountJoin = root.join("actionsList", JoinType.LEFT);
//            query.having(criteriaBuilder.lessThan(criteriaBuilder.count(actionAccountJoin), value));
//            query.groupBy(root);
//            return criteriaBuilder.and();
//        });
//    }
//
//    public static Specification<Account> numberOfActionsLessThan(Long value) {
//        return ((root, query, criteriaBuilder) -> {
//            Subquery<Long> subquery = query.subquery(Long.class);
//            Root<Action> accountRoot = subquery.from(Action.class);
//            subquery.select(accountRoot.get("eventfulAccount").get("accountNumber"));
//            subquery.groupBy(accountRoot.get("eventfulAccount"));
//            subquery.having(criteriaBuilder.greaterThan(criteriaBuilder.count(accountRoot), value));
//            return criteriaBuilder.in(root.get("accountNumber")).value(subquery);
//        });
//    }

    //todo: to implements
    public static Specification<Account> creationMonthEqual(Integer value) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("creationMonth"), value));
    }

    public static Specification<Account> creationDayEqual(Integer value) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("creationDay"), value));
    }
}
