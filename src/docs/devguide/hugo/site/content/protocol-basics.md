---
title: "Protocol Basics"
menu:
  main:
    weight: 10
---

The Billpay Service Interface is an HTTP based protocol. A detailed description of the supported operations and definitions can be found in the [Specification](/specification/introduction) section.

## Security

All communication shall be secured by establishing an SSL encrypted transport. Basic HTTP authentication shall be used to authenticate clients with the service, and is required for all requests.


## Failures

The outcome of a request shall be determined by examining the HTTP status code of the response. It is important to understand the meaning of

### Status type

Three basic types of outcomes are possible for transactions, namely: _successful_, _unknown_, and _failed_. HTTP status codes are mapped to one of the possible outcomes as indicated below.

HTTP Status Codes         | Status type
--------------------------|---------------------------------------------------------------------------------------------
200, 201, 202             | successful
500, 504, timeout         | unknown
400, 501, 503, all others | failed

A timeout occurs when the client has not received a response to a request after the agreed upon interval. Unless otherwise agreed, this interval shall be 60 seconds. Any response received after the timeout should be logged but ignored.

### ErrorDetail

In addition to the HTTP status code, failure response bodies shall contain an [ErrorDetail](/specification/definitions/#errordetail) object if possible to describe the failure in more detail. It should be noted though, that clients should expect the possibility of an empty response body in some failure scenarios.


## Store-and-forward

To ensure that loss of transactional data is minimized, the Billpay Service Interface require clients to store advice messages in persistent storage and queued until a final status type is received. A final response is one of either the _successful_ or _failed_ status types. If the Billpay Service is not responding, or responding with an _unknown_ status code, advice messages shall be queued and the message at the head of queue repeated on an interval until a final status type is received. For high throughput systems it shall be acceptable to send several messages in parallel.

The above applies to the following operations:

* confirmPayment
* cancelPayment
* reversePayment
* confirmRefund
* cancelRefund
* reverseRefund