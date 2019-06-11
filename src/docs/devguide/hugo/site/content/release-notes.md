This page describes changes to the Billpay Service Interface implemented across different releases of the interface.

## v4.7.5

Released TBC

- Added the following ErrorTypes: BELOW_MINIMUM_ALLOWED_AMOUNT and ABOVE_MAXIMUM_ALLOWED_AMOUNT

## v4.7.4

Released 02 May 2019

- Modified PAYMENT_NOT_ALLOWED_USING_SETTLEMENT_ENTITY to BLOCKED_USING_SETTLEMENT_ENTITY

## v4.7.3

Released 02 May 2019

- This version has been deprecated
- Added the following ErrorTypes: RECEIVER_BLACKLISTED, LUHN_CHECK_FAILED, and PAYMENT_NOT_ALLOWED_USING_SETTLEMENT_ENTITY

## v4.7.2

Released 13 February 2019

- Fix Lists in PaymentRequest and PaymentResponse to be initialised rather than be set to null. 

## v4.7.1 

Released 9 January 2019

- Fix Customer field setters and getters in PaymentRequest

## v4.7.0

Released 9 January 2019

- Added Tender and PaymentsMethods fields to PaymentRequest and PaymentResponse
- Added Customer fields to PaymentRequest 

## v4.6.0

Released 31 August 2018

- Update Service Interface Base version to v3.14.0
- Update to support Circle 2.0
- Make paths constants 
- Update Hugo build to use non-deprecated now function.  

## v4.5.0

Released 8 November 2017

- Update base service interface version to v3.4.0.
  - Added optional `barcode` field to `SlipLine` which represents a barcode on a till slip.

## v4.4.3

Released 9 October 2017

- Update Swagger Jersey 2 JAX-RS version to v1.5.16.
- Remove included SLF4J library.

## v4.4.2

Released 6 October 2017

- Defined due date format in responses as yyyy-MM-dd

## v4.4.1

Released 15 Aug 2017

- Align with base service interface (v3.3.0) to include missing validation annotations

## v4.4.0

Released 10 Aug 2017

- Additional annotations for cascading validation

## v4.3.1

Released 25 July 2017

- Fixed resource base path in Swagger.

## v4.3.0

Released 24 July 2017

- Added INVALID_MERCHANT ErrorType.

## v4.2.0

Released 05 January 2017

- Added the following RequestType enumerated values to ErrorDetail:
  - TRAFFIC_FINE_LOOKUP_REQUEST
  - POLICY_LOOKUP_REQUEST
  - POLICY_PAYMENT_REQUEST
- Note that the following ErrorDetail.RequestType enumerated values are deprecated and should not be used:
 - TRAFFIC_FINE_PAYMENT_REVERSAL (use PAYMENT_REVERSAL instead)
 - TRAFFIC_FINE_PAYMENT_CONFIRMATION (use PAYMENT_CONFIRMATION instead)

## v4.1.0

  Released 11 November 2016

  - Added support for Traffic Fine and Policy lookups and payments.
  - Account object in responses is now optional.
  - Removed issuerReference from BillSlipData (no net change - see base service interface changes below).
  - Added indicators for allowance of part- and over-payments of accounts etc.
  - Aligned Billpay Service Interface with base service interface (v3.2.0).
    - Added GIFT_CARD and LOYALTY tender types.
    - Relaxed restrictions on allowed characters in Originator.terminalId field.
    - Included issuerReference as part of basic SlipData and extended length to 40.
    - Added basketRef field to indicate related transactions.

## v4.0.0

  Released 27 October 2016

  - Aligned Billpay Service Interface with base service interface (v3.0.0).
    - Formatting included as part of SlipLine entries in BillSlipData field.
    - Defined BasicAdviceResponse returned when acknowledging an advice.
    - Added request IDs and request type to ErrorDetail responses.
    - Amounts are now encapsulated in an Amounts model.

## v3.0.3

Released 25 August 2016

- Aligned Billpay Service Interface with base service interface (v2.0.6).

## v3.0.2

Released 25 August 2016

- Aligned Billpay Service Interface with base service interface (v2.0.5).

## v3.0.1

Released 22 August 2016

- Aligned Billpay Service Interface with base service interface (v2.0.4).

## v3.0.0

Released 22 August 2016

- Aligned Billpay Service Interface with base service interface (v2.0.3).

## v2.0.5

Released 12 August 2016

- Removed clientRef field from PaymentRequests

## v2.0.4

Released 10 August 2016

- Added ID number and contact number to customer description.
- Further minor implementation detail changes.

## v2.0.3

Released 4 August 2016

- Further minor implementation detail changes.

## v2.0.2

Released 4 August 2016

- Minor implementation detail changes.

## v2.0.1

Released 19 July 2016

- Added Account and Customer to basic response to all requests.

## v2.0.0

Released 13 July 2016

- Aligned Billpay Service Interface with base service interface v1.0.0.

## v1.0.0

Released 30 June 2016

Initial release.
