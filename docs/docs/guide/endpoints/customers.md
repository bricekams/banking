# Customers <Badge type="info" text="v1/customers" />

This endpoint is the one to use when it comes to customers data.

## Endpoints

### <span style="color:green">POST</span> `v1/customers` Register a customer

::: details Body request format
```json
{
  "customerId": "7946b255-54aa-48a1-b174-05082201f3bd",
  "firstName": "John",
  "lastName": "Doe",
  "birthDate": "1972-10-08",
  "cityOfBirth": "Johannesburg",
  "nicId": "12345DK", # nationcal card ID
  "phoneNumber": 696693256, # without country code
  "email": "johndoe@gmail.com",
  "profilePicture": "https://aFakeLinkToAnImg.com",
  "password": "dbfsdyuifgudfhgidfghdfi",
  "pin": "invdfoisnhfuihfisdhfsdui"
}
```
:::

### <span style="color:blue">GET</span> `v1/customers` fetch all customers

::: details Request parameters
```yaml
firstName: Fetch where customer's first name equal to ?
lastName: Fetch where customer's last name equal to ?
birthDate: Fetch where customer's birth date equal to ?
cityOfBirth: Fetch where customer's city of birth equal to ?
nicId: Fetch where customer's national id card number equal to ?
phoneNumber: Fetch where customer's phone number equal to ?
email: Fetch where customer's email equal to ?
hasActiveAccount: Fetch all customers with active account
```
:::

::: details Example response
```json
[
  {
        "customerId": "587da58a-acc8-4fdb-9629-27d7e6bdc18b",
        "firstName": "John",
        "lastName": "Doe",
        "birthDate": "1972-10-08",
        "cityOfBirth": "Nairobi",
        "nicId": "13123DS",
        "phoneNumber": 658545207,
        "email": "johndoe@gmail.com",
        "profilePicture": null,
        "hasActiveAccount": false,
        "password": "sdhfuisdhgfidhgiu",
        "pin": "nsdjkfuieygh"
    },
    {
        "customerId": "7946b255-54aa-48a1-b174-05082201f3bd",
        "firstName": "Maria",
        "lastName": "Doe",
        "birthDate": "1972-10-08",
        "cityOfBirth": "Nairobi",
        "nicId": "13123SS",
        "phoneNumber": 658456999,
        "email": "mariadoe@gmail.com",
        "profilePicture": null,
        "hasActiveAccount": false,
        "password": "sdhfuisdhgfidhgiu",
        "pin": "nsdjkfuieygh"
    }
]
```
:::

### <span style="color:orange">PUT</span> `v1/customers/{customerId}` Update customer information

::: details Request body example
```json
{
  "email": "new_email@domain.com",
  "phoneNumber": 655663322
}
```
Only the customer email and phone number will be updated
:::

### <span style="color:blue">GET</span> `v1/customers/{customerId}` Get customer by his id

:::details Example response
```json
{
  "customerId": "7946b255-54aa-48a1-b174-05082201f3bd",
  "firstName": "Maria",
  "lastName": "Doe",
  "birthDate": "1972-10-08",
  "cityOfBirth": "Nairobi",
  "nicId": "13123SS",
  "phoneNumber": 658456999,
  "email": "mariadoe@gmail.com",
  "profilePicture": null,
  "hasActiveAccount": false,
  "password": "sdhfuisdhgfidhgiu",
  "pin": "nsdjkfuieygh"
}
```
:::