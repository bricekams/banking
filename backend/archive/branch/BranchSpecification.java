package com.bank.core.branch;

import com.bank.core.account.Account;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

public class BranchSpecification {
    public static Specification<Branch> townEqual(String value) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("town"), value));
    }
    public static Specification<Branch> numberOfAccountsLessThan(Long length) {
        return ((root, query, criteriaBuilder) -> {
            Join<Account, Branch> accountBranchJoin = root.join("branchAccountsList", JoinType.LEFT);
            query.having(criteriaBuilder.lessThan(criteriaBuilder.count(accountBranchJoin), length));
            query.groupBy(root);
            return criteriaBuilder.and();
        });
    }
    public static Specification<Branch> numberOfAccountGreaterThan(Long length) {
        return ((root, query, criteriaBuilder) -> {
            Subquery<Long> subquery = query.subquery(Long.class);
            Root<Account> accountRoot = subquery.from(Account.class);
            subquery.select(accountRoot.get("creationBranch").get("branchId"));
            subquery.groupBy(accountRoot.get("creationBranch"));
            subquery.having(criteriaBuilder.greaterThan(criteriaBuilder.count(accountRoot), length));
            return criteriaBuilder.in(root.get("branchId")).value(subquery);
        });
    }
}
