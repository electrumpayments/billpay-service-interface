---
title: "Transaction Flows"
menu:
  main:
    weight: 30
---

This section depicts some transaction flows. It is not an exhaustive list of all conceivable flows, but does attempt to show the most interesting scenarios.

When developing a downstream integration into the Billpay service, Electrum hosts the *Billpay Service* and the flows should be viewed from the perspective of the *Downstream Entity*. When developing an upstream integration, Electrum in the *Downstream Entity* and the flows should be viewed from the perspective of the *Billpay Service*.

Interactions between the Billpay Service and the Upstream Entity is purely shown for completeness. The actual communication between the Billpay Service implementation and upstream entities is out of scope of this document and may very well differ from the indicative flows shown below. Interactions between the downstream entity and the Billpay service should, on the other hand, strictly be adhered to.


# Account Info

An account info request may be performed before a payment in order to first display the outstanding customer balance.

Account info requests are optional. The downstream entity is not required to send account info requests, or may choose to send account info requests only for certain bill issuers. Account info requests do not have financial impact and is not required to be followed with a payment. Likewise, Billpay Service implementations are not required to implement account info request, or may only support account info request for certain bill issuers or processors. It is, however, required that where account info requests are not supported, the Billpay Service returns a 501 (Not Implemented) HTTP status code when it receives such a request.

## Successful Account Info request

The sequence diagram below shows a successful [requestAccountInfo](/specification/operations/#requestaccountinfo) operation. The response payload contains information regarding the customer and account.

![A Successful Account Info Request](/images/sequence-account-info-success.png "A Successful Account Info Request")

## Account Info Not Supported

If account info requests are not supported by the Billpay Service, it shall return a 501 status code.

![Account Info not Supported](/images/sequence-account-info-not-supported.png "Account Info not Supported")


# Payments

Payments transactions always consist of a request leg, followed by a confirmation / cancellation / reversal leg to advice on the completion of the transaction. This kind of flow is commonly referred to as "dual messaging".

In order to maintain system consistency, it is important that all advice messages are queued in persistent storage and repeated until an acknowledgement of receipt is received from the Billpay Service implementation. This process is commonly referred to as store-and-forward.

## Declined Payment

In the below flow the payment request is permanently declined by the Billpay Service due to a format error in the request. A similar flow would result if an entity upstream of the Billpay Service permanently declines a payment, or if the payment could not be sent to the upstream entity due to it being offline.

Refer to the section on [failures](/protocol-basics/#failures) for a definitive explanation of failure conditions, but any response with an HTTP status code other than success (2xx), Internal Server Error (500), or Gateway Timeout (504) are considered "declines". Declined transactions are confirmed not to have been actioned and do not have to be completed with a confirmation, cancellation, or reversal.

![A Declined Payment](/images/sequence-declined-payment.png "A Declined Payment")

## Successful Payment

The below flow depicts the normal flow of a successfully confirmed bill payment.

![A Successful Payment](/images/sequence-successful-payment.png "A Successful Payment")

## Cancelled Payment

If a bill payment request is responded to successfully, but needs to be cancelled before being completed, it should be cancelled as depicted below.

An example of a cancellation scenario would be where the customer abandons the basket, or tender is unsuccessful.

Note that it is always possible to perform a cancellation as a reversal. It is, however, preferable to make use of a cancellation in all cases where the paymentId is known, since many provider and issuer systems perform better when looking up a transaction by paymentId rather than using the original message fields.

![A Cancelled Payment](/images/sequence-cancelled-payment.png "A Cancelled Payment")

## Reversed Payment

A payment request must be reversed if the response status code is Internal Server Error (500) or Gateway Timeout (504), or the request times out without receiving any response. In such cases, the paymentId is not known, and the transaction can thus not be cancelled. A reversal body merely contains the same message fields as the payment request, so Billpay Service implementations shall ensure that payments can be matched on only fields contained in the payment request - typically making use of the fields provided in the [MessageId](/specification/definitions/#messageid) object.

![A reversed Payment](/images/sequence-reversed-payment.png "A reversed Payment")


# Refunds

Some bill payments processors allow customers to request a refund of a successfully completed payment previously made for a certain time period after the original payment.

Billpay Service implementations are not required to support refunds, or may only support refunds for certain bill issuers or processors. It is, however, required that when refunds are not supported, the Billpay Service returns a 501 (Not Implemented) HTTP status code when it receives such a request.

Similar to payments, refunds follow a dual message flow requiring a request leg, followed by an advice leg.

A Reversal is matched to its corresponding payment by the issuerReference printed on the receipt at time of the payment.

## Declined Refund

The below refund is declined by the bill payments issuer due to the original not being located.

Refer to the section on [failures](/protocol-basics/#failures) for a definitive explanation of failure conditions, but any response with an HTTP status code other than success (2xx), Internal Server Error (500), or Gateway Timeout (504) are considered "declines". Declined transactions are confirmed not to have been actioned and should not be completed with a confirmation, cancellation, or reversal.

![A Declined Refund](/images/sequence-declined-refund.png "A Declined Refund")

## Successful Refund

A successfully completed refund transaction is depicted below.

![A Successful Refund](/images/sequence-successful-refund.png "A Successful Refund")

## Cancelled Refund

If a refund request is responded to successfully, but needs to be cancelled before being completed, it should be cancelled as depicted below.

An example of a cancellation scenario would be where the customer abandons the basket.

Note that it is always possible to perform a cancellation as a reversal. It is, however, preferable to make use of a cancellation in all cases where the refundId is known, since many provider and issuer systems perform better when looking up a transaction by refundId rather than using the original message fields.

![A Cancelled Refund](/images/sequence-cancelled-refund.png "A Cancelled Refund")

## Reversed Refund

A refund request must be reversed if the response status code is Internal Server Error (500) or Gateway Timeout (504), or the request times out without receiving any response. In such cases, the refundId is not known, and the transaction can thus not be cancelled. A reversal body merely contains the same message fields as the refund request, so Billpay Service implementations shall ensure that refunds can be matched on only fields contained in the payment request - typically making use of the fields provided in the [MessageId](/specification/definitions/#messageid) object.

![A Reversed Refund](/images/sequence-reversed-refund.png "A Reversed Refund")
