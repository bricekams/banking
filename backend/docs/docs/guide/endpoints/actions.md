# Actions <Badge type="info" text="v1/actions" />

This endpoint is the one to use when it comes to actions data.

## Endpoints

### <span style="color:green">POST</span> `v1/actions` Create action

::: details Body request format
```json
{
  "eventfulAccount": 852450879, # account number
  "actionType": "transfer", # DEPOSIT | TRANSFER | WITHDRAW
  "amount": 7500,
  "receiverName": "Larry Page",
  "receiverReference": 3820452009, # account number
  "purpose": "Furniture"
}
```

**Note**: The receiver name, reference and the purpose can be omitted if the action type is 
deposit<br/>
The action type is non-case-sensitive.<br/>
:::

### <span style="color:blue">GET</span> `v1/actions` fetch all actions

::: details Request parameters
```yaml
eventfulAccount: Fetch where eventful account is ?
amount: Fetch where amount equal to ?
amountGreaterThan: Fetch where amount less than ?
amountLessThan: Fetch where amount greater than ?
actionType: Fetch where action type is ? # DEPOSIT | TRANSFER | WITHDRAW
```
:::

::: details Example response
```json
[
  {
    "actionId": "09452cf6-357e-43c4-bf7f-3ccee4e0f283",
    "eventfulAccount": 339404478,
    "amount": 12000.0,
    "actionType": "DEPOSIT",
    "receiverName": "Maria Doe",
    "receiverReference": "339404478",
    "purpose": null
  },
  {
    "actionId": "e6d8ba4c-b3a2-4ef0-ac10-236cf8419167",
    "eventfulAccount": 339404478,
    "amount": 5000.0,
    "actionType": "TRANSFER",
    "receiverName": "Maria Doe",
    "receiverReference": "3820452009",
    "purpose": "loans"
  }
]
```
:::

### <span style="color:blue">GET</span> `v1/actions/{actionsId}` Get action by action id

:::details Example response
```json
{
  "actionId": "e6d8ba4c-b3a2-4ef0-ac10-236cf8419167",
  "eventfulAccount": 339404478,
  "amount": 5000.0,
  "actionType": "TRANSFER",
  "receiverName": "Maria Doe",
  "receiverReference": "3820452009",
  "purpose": "loans"
}
```
:::