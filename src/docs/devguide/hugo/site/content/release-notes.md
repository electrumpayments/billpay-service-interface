This page describes changes to the Billpay Service Interface implemented across different releases of the interface.

## v4.9.0

Released TBA 2020

- Added Javax Validation Annotations to resources
    - `@ConsistentTransactionId` is an annotation for methods which validates that the first parameter (which must be a `String`) corresponds to the `id` field of the second parameter (which must extend `Transaction`).
    - `@ConsistentAdviceIds` is an annotation for methods which validates that the first parameter (which must be a `String`) and the second parameter (which must be a `String`)  correspond to the `id` and `requestId` fields of the third parameter (which must extend `BasicAdvice`)

## v4.8.1

Released 11 March 2020

- Further updated implementation of `Amounts` with `BillpayAmounts` in v4.8.0 to be compatible with previous Java implementations.
- Fixed swagger generation to correctly include `BillpayAmounts` `amounts` field for the following models:
  - `PaymentRequest`
  - `PolicyPaymentRequest`
  - `TrafficFinePaymentRequest`

## v4.8.0

### Deprecated (Use v4.8.1 instead)

- This version resulted in the following issues, which have been fixed in version 4.8.1:
    - a breaking change to the API where the `amounts` field was dropped from the following models:
        - `PaymentRequest`
        - `PolicyPaymentRequest`
        - `TrafficFinePaymentRequest`
    - a breaking change of the Java implementation for the `getAmounts` method in the following models:
        - `BillpayResponse` (extended by `PaymentResponse`, `PolicyPaymentResponse` and `TrafficFinePaymentResponse`)
        - `PaymentRequest`
        - `PolicyPaymentRequest`
        - `TrafficFinePaymentRequest`

Released 6 March 2020

- Replaced `Amounts` in the following models with `BillpayAmounts` in order to facilitate maximum and minimum payment amounts:
  - `BillpayResponse` (extended by `PaymentResponse`, `PolicyPaymentResponse` and `TrafficFinePaymentResponse`)
  - `PaymentRequest`
  - `PolicyPaymentRequest`
  - `TrafficFinePaymentRequest`
- Bumped dependency on Base API from v3.14.0 to v3.23.0. This includes the following updates:
  - Added utility methods to JsonUtil class to assist in reading the contents of a file as a string and deserialising JSON objects from files.
  - Added new field `region` to `BankAccount` model for scenarios where the `routingCode` is not sufficient to uniquely identify a bank account.
  - Added new field `emailAddress` to `Customer` model.
  - Added new `Account.AccountType` value `CASH_PICKUP` for cash pickup scenarios.
  - Changed masking of `CardPayment.pan` field to partial masking instead of full masking.
  - Added new models:
      - `Pin` a base PIN model
          - `PinClear` for PINs in the clear
          - `PinEncrypted` for encrypted PIN blocks with the PIN block format, accountNumber and the key index
  - `Pin` was added to `CardPayment`, taking precedence over the existing `encyptedPin` field
  - Added new models:
    - `ExchangeRate` to describe the exchange rate between two currencies.
    - `Account` to describe more varied accounts in a consistent manner. This has the following sub-types defined:
      - `BankAccount`
      - `IbanAccount`
      - `IfsAccount`
      - `SwiftAccount`
      - `MobileWalletAccount`
  - The limitations on the `id` field of the `Institution` model have been removed to make the field suitable for a wider range of applications. The values in this field need no longer be defined by Electrum and similar values as recognised at third parties may now be carried in this field. However, care should be taken during implementation to ensure that different parties agree on the values which will be present in these fields.
  - Added explicit fields for STAN and RRN values to `BasicAdvice` and `Transaction` models.
  - Added a `serialise(Object)` method to the `io.electrum.vas.JsonUtil` class. This assists in obtaining consistently serialised String representations of Objects.
  - Made the `msisdn` field of the `Customer` object an optional field.
  - Added a `CardPayment` payment method.
- The version of Jetty included in the Java implementation was bumped to version 9.3.24.v20180605 to address various security vulnerabilities.

## v4.7.5

Released 11 June 2019

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
