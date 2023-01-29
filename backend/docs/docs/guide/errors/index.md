---
next: Clients
---

# Errors

When using this API, you can face some issues and this section cover how are they described

## Response object 
```json
{
"timestamp": "2023-01-29T00:18:33.339+00:00",
"status": 404,
"error": "Not Found",
"path": "/api/v1/tickets"
}
```

## HTTP status code summary
::: info Codes

- **200 - OK** The request was executed successfully.
- **400 - Bad Request** The request was unacceptable, often due to a missing or misconfigured parameter.
- **404 - Not Found** The resource whose identifier was given was not found.
- **409 - Conflict** The resource already exist in the database
- **500 - Server Error** Something went wrong on our side.

:::
