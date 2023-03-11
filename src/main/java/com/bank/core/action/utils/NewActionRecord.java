package com.bank.core.action.utils;

import com.bank.core.account.Account;

public record NewActionRecord(
        Long eventfulAccount,
        String actionType,
        Float amount,
        String receiverName,
        String receiverReference,
        String purpose

) {
}
