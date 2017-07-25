This page describes changes to the Billpay Service Interface implemented across different releases of the interface.

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
