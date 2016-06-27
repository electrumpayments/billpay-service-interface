---
title: "Advanced Topics"
menu:
  main:
    weight: 20
---

## Payment and refund id construction

Billpay Service implementations are free to construct payment and refund ids as it sees fit. A database identifier or generated UUID will do, although care should be taken that it is possible to match reversals to their original requests.


## Transaction matching

### LinkData

Service implementations can link completions and cancellations to their original by supplying any data in the linkData field of payments and refunds responses. This field can be of any type useful to the service implementation, and shall be returned unaltered as received in completions and cancellations.

### Matching reversals

Reversals do not contain linkData. As such, reversals must be matched to their original by using only data contained in these messages (the two message contains the same exact data). The [MessageId](/specification/definitions/#messageid) object contains enough data to uniquely identify transactions and can be used for this purpose.

### Matching refunds

Refund requests typically also have to be matched to their corresponding payment by service implementations in order to enrich some fields before sending, since the refund request is built from the data printed on the payment receipt. If refunds are supported, care should thus be taken to ensure matching can take place on the issuerReference field printed on payment receipts.
