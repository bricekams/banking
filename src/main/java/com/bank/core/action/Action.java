package com.bank.core.action;
import com.bank.core.action.utils.ActionType;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;
import java.util.UUID;


@Entity(name = "action")
public class Action {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String actionId;
    private UUID eventfulAccount;
    private Float amount;
    @Enumerated(EnumType.STRING)
    private ActionType actionType;
    private String receiverName;
    private String receiverReference;
    private String purpose;

    public Action(String actionId, UUID eventfulAccount, ActionType actionType, Float amount, String receiverName, String receiverReference, String purpose) {
        this.actionId = actionId;
        this.eventfulAccount = eventfulAccount;
        this.actionType = actionType;
        this.purpose = purpose;
        this.amount = amount;
        this.receiverName = receiverName;
        this.receiverReference = receiverReference;
    }

    public Action() {
    }

    public String getActionId() {
        return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
    }

    public UUID getEventfulAccount() {
        return this.eventfulAccount;
    }

    public void setEventfulAccount(UUID eventfulAccount) {
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

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Action action = (Action) o;
        return actionId.equals(action.actionId) && eventfulAccount.equals(action.eventfulAccount) && amount.equals(action.amount) && actionType == action.actionType && receiverName.equals(action.receiverName) && receiverReference.equals(action.receiverReference) && purpose.equals(action.purpose);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actionId, eventfulAccount, amount, actionType, receiverName, receiverReference, purpose);
    }

    @Override
    public String toString() {
        return "Action{" +
                "actionId=" + actionId +
                ", eventfulAccount=" + eventfulAccount +
                ", amount=" + amount +
                ", actionType=" + actionType +
                ", receiverName='" + receiverName + '\'' +
                ", receiverReference='" + receiverReference + '\'' +
                ", purpose='" + purpose + '\'' +
                '}';
    }
}
