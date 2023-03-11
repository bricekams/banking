# Accounts <Badge type="info" text="v1/accounts" />

This endpoint is the one to use when it comes to accounts data.

## Endpoints

### <span style="color:green">POST</span> `v1/accounts` Create account

::: details Body request format
```json
{
  "ownerId": "587da58a-acc8-4fdb-9629-27d7e6bdc18b",
  "accountName": "Loans"
}
```
:::

### <span style="color:blue">GET</span> `v1/accounts` fetch all accounts

::: details Request parameters
```yaml
creationDate: Fetch where account's creation date equal to ?
creationYear: Fetch where account's creation year equal to ?
creationMonth: Fetch where account's creation month equal to ? # int
creationDay: Fetch where account's creation day equal to ? # int
createdBefore: Fetch where account's creation date before ? # 2020-12-23 
createdAfter: Fetch where account's creation date after ?
ownerId: Fetch where account's owner id equal to ? 
```
:::

::: details Example response
```json
[
  {
    "accountNumber": 339404478,
    "accountName": "Business",
    "owner": {
      "customerId": "7946b255-54aa-48a1-b174-05082201f3bd",
      "firstName": "Maria",
      "lastName": "Doe",
      "birthDate": "1972-10-08",
      "cityOfBirth": "Nairobi",
      "nicId": "13123SS",
      "phoneNumber": 658456999,
      "email": "mariadoe@gmail.com",
      "profilePicture": null,
      "hasActiveAccount": false
    },
    "createdOn": "2023-01-28T23:54:02.110923Z",
    "balance": 0.0
  },
  {
    "accountNumber": 3820452009,
    "accountName": "Business",
    "owner": {
      "customerId": "7946b255-54aa-48a1-b174-05082201f3bd",
      "firstName": "Maria",
      "lastName": "Doe",
      "birthDate": "1972-10-08",
      "cityOfBirth": "Nairobi",
      "nicId": "13123SS",
      "phoneNumber": 658456999,
      "email": "mariadoe@gmail.com",
      "profilePicture": null,
      "hasActiveAccount": false
    },
    "createdOn": "2023-01-28T23:54:03.304063Z",
    "balance": 0.0
  }
]
```
:::

### <span style="color:orange">PUT</span> `v1/accounts/{accountNumber}` Update account name

::: details Request body example
```json
{
  "accountName": "new_account_name"
}
```
:::

### <span style="color:blue">GET</span> `v1/accounts/{accountNumber}` Get account by account number

:::details Example response
```json
{
  "accountNumber": 3820452009,
  "accountName": "Business",
  "owner": {
    "customerId": "7946b255-54aa-48a1-b174-05082201f3bd",
    "firstName": "Maria",
    "lastName": "Doe",
    "birthDate": "1972-10-08",
    "cityOfBirth": "Nairobi",
    "nicId": "13123SS",
    "phoneNumber": 658456999,
    "email": "mariadoe@gmail.com",
    "profilePicture": null,
    "hasActiveAccount": false
  },
  "createdOn": "2023-01-28T23:54:03.304063Z",
  "balance": 5000.0
}
```
:::