package com.bank.core.action;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.bank.core.account.Account;
import com.bank.core.action.utils.ActionType;
import jakarta.persistence.*;

import java.util.Objects;


@Entity(name = "action")
public class Action {
    @Id
    @SequenceGenerator(
            name = "action_id_sequence",
            sequenceName = "action_id_sequence",
            allocationSize = 33
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "action_id_sequence"
    )
    private Long actionId;
    private Long eventfulAccount;
    private Float amount;
    @Enumerated(EnumType.STRING)
    private ActionType actionType;
    private String receiverName;
    private String receiverReference;

    public Action(Long actionId, Long eventfulAccount, ActionType actionType, Float amoun, String receiverName, String receiverReference) {
        this.actionId = actionId;
        this.eventfulAccount = eventfulAccount;
        this.actionType = actionType;
        this.amount = amount;
        this.receiverName = receiverName;
        this.receiverReference = receiverReference;
    }

    public Action() {
    }

    public Long getActionId() {
        return actionId;
    }

    public void setActionId(Long actionId) {
        this.actionId = actionId;
    }

    public Long getEventfulAccount() {
        return this.eventfulAccount;
    }

    public void setEventfulAccount(Long eventfulAccount) {
        this.eventfulAccount = eventfulAccount;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverReference() {
        return receiverReference;
    }

    public void setReceiverReference(String receiverReference) {
        this.receiverReference = receiverReference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Action action = (Action) o;
        return actionId.equals(action.actionId) && eventfulAccount.equals(action.eventfulAccount) && amount.equals(action.amount) && actionType == action.actionType && receiverName.equals(action.receiverName) && receiverReference.equals(action.receiverReference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actionId, eventfulAccount, amount, actionType, receiverName, receiverReference);
    }
}
