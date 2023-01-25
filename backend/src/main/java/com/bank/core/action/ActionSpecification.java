package com.bank.core.action;

import com.bank.core.action.utils.ActionType;
import org.springframework.data.jpa.domain.Specification;

public class ActionSpecification {

    public static Specification<Action> eventfulAccountEqual(String accountNumber){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("eventfulAccount"), accountNumber));
    }

    public static Specification<Action> amountEqual(Float amount){
        return (((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("amount"),amount)));
    }

    public static Specification<Action> amountGreaterThan(Float amount){
        return (((root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("amount"),amount)));
    }

    public static Specification<Action> amountLessThan(Float amount){
        return (((root, query, criteriaBuilder) -> criteriaBuilder.lessThan(root.get("amount"),amount)));
    }

    //todo: tests absolutely
    public static Specification<Action> actionTypeIs(ActionType actionType){
        return (((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("actionType"),actionType)));
    }
}
