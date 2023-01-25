package com.bank.core.customer.utils;

public record NewCusomerRecord(
        Long customerId,
        String firstName,
        String lastName,
        String birthDate,
        String cityOfBirth,
        String nicId, // national identity card number
        Long phoneNumber,
        String email
) {
}
