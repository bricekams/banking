package com.bank.core.action.utils;

import com.bank.core.account.Account;

import java.util.UUID;

public record NewActionRecord(
        UUID eventfulAccount,
        String actionType,
        Float amount,
        String receiverName,
        UUID receiverReference,
        String purpose

) {
}
