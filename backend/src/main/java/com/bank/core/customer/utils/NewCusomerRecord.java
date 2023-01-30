package com.bank.core.customer.utils;

public record NewCusomerRecord(
        String firstName,
        String lastName,
        String birthDate,
        String cityOfBirth,
        String nicId, // national identity card number
        Long phoneNumber,
        String email,
        String profilePicture,
        String password,
        String pin
) {
}
