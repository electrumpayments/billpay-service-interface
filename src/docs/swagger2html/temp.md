The Capitec Card Payments Application Program Interface (API) provides an interface into Capitec's card acquiring and issuing banking infrastructure. The API is intended for use by internal systems and external third party systems, and is not suitable as an end-user facing interface.

This API specification is written for software developers to integrate a payments system into Capitec systems.


## Protocol

The Capitec Card Payments API is a RESTful web service and makes use of standard HTTP features where possible. It should be possible to access the API with a variety of HTTP clients.


## Security

Security is provided by an API gateway appliance which is out of scope of this document.


## Terminology

Term              | Description
:----------------:| ----------------------------------------------------------------------------------------
Always            | This field _must_ or _will_ always be supplied
Cond req          | This field _must_ or _will_ be supplied conditionally based on the request type or other data, as specified
Optional          | This field _may_ be supplied. If not supplied the field will be empty
Default           | This field _may_ be supplied. If not supplied its default value will be assumed


## Data formats

Indicator | Description
:--------:| ------------------------------------------------------------------------------------------------------------
3         | fixed length of 3 characters
..10      | maximum length of 10 characters
a         | alphabet characters: A-Z and a-z
b         | binary data represented as a hexadecimal string: 0-9 and A-F
an        | alpha numeric characters: A-Z, a-z, and 0-9
anp       | alpha numeric characters including space: A-Z, a-z, 0-9, u0020
ans       | alpha numeric characters including special characters: A-Z, a-z, 0-9, u0020-u007E
iso       | formatted according to the indicated ISO specification
n         | numeric characters 0-9
yymm      | year, followed by month

## Status and response codes

Response outcomes fall in 5 main categories, namely: success, temporary failure, unknown state, and permanent failure. Permanent failure simply means that if the _exact_ same request is received again, it will fail again. Sometimes a permanent failure may in fact be a fixable error from the client's perspective, for example an authentication failure. This is still considered a permanent failure for the purpose of this specification. These four categories are mapped to HTTP status codes as below.

HTTP Status Codes        | Status type
------------------------ |----------------------------------------------------------------------------------------------
200, 201                 | success
503                      | transaction is confirmed in a failed state due to temporary upstream connectivity problems - client may try again without issuing a reversal
500, 504                 | transaction is in an unknown state after failing unexpectedly or timing out upstream - client must issue a reversal for this transaction and may then try again
400, all others          | permanent failure - it is not required to issue a reversal, and a resending the transaction again will likely result in the same failure

Under each HTTP status code, the below detailed outcome.responseCode values are possible. All effort is made to return a well formed response object as the HTTP response entity, however there are scenarios where this is not possible, thus it is paramount that any error logic after receiving a response is driven by the HTTP status code firstly and the outcome object secondly.

### HTTP Status Code 201 - Created

Response Codes | Description
-------------- | -------------------------------------------------------------------------------------------------------
00, 000        | Approved
08, 001        | Honour With ID
10, 002        | Approved Partial
11, 003        | Approved VIP

### HTTP Status Code 400 - Bad request

Response Codes | Description
-------------- | -------------------------------------------------------------------------------------------------------
01, 107        | Refer To Card Issuer
02, 108        | Refer To Card Issuer Special
03, 109        | Invalid Merchant
04, 200        | Do Not Honour Pick Up
05, 100        | Do Not Honour
06, 913        | Duplicate Transmission
07, 207        | Special Conditions Pick Up
09, 923        | Request In Progress
12, 902        | Invalid Transaction
13, 110        | Invalid Amount
14, 111        | Invalid Card Number
15, 908        | Routing Error
16, 004        | Approved Update Track 3
17, 100        | Do Not Honour
18, 100        | Do Not Honour
19, 903        | Re-enter Transaction
20, 100        | Do Not Honour
21, 921        | Security Error No Action
23, 113        | Unacceptable Fee
24, 301        | File Action Not Supported
25, 302        | File Record Not Found
26, 308        | File Duplicate Record Rejected
27, 304        | File Field Edit Error
28, 305        | File Locked Out
29, 306        | File Action Not Successful
30, 904        | Format Error
31, 905        | Acquirer Not Supported
32, 100        | Do Not Honour
33, 201        | Expired Card Pick Up
34, 202        | Suspected Fraud Pick Up
35, 203        | Contact Acquirer Pick Up
36, 204        | Restricted Card Pick Up
37, 205        | Call Acquirer Security Pick Up
38, 206        | PIN Tries Exceeded Pick Up
39, 114        | No Account Of Requested Type
40, 115        | Function Not Supported
41, 208        | Lost Card Pick Up
42, 114        | No Account Of Requested Type
43, 209        | Stolen Card Pick Up
44, 114        | No Account Of Requested Type
45–50, 100     | Do Not Honour
51, 116        | Not Sufficient Funds
52, 114        | No Account Of Requested Type
53, 114        | No Account Of Requested Type
54, 101        | Expired Card
55, 117        | Incorrect PIN
56, 118        | No Card Record
57, 119        | Tran Not Permitted Cardholder
58, 120        | Tran Not Permitted Terminal
59, 102        | Suspected Fraud
60, 103        | Contact Acquirer
61, 121        | Exceeds Withdrawal Amount Limit
62, 104        | Restricted Card
63, 122        | Security Violation
64, 110        | Invalid Amount
65, 123        | Exceeds Withdrawal Frequency Limit
66, 105        | Call Acquirer Security
67, 200        | Do Not Honour Pick Up
68, 911        | Card Issuer Timed Out
69–74, 100     | Do Not Honour
75, 106        | PIN Tries Exceeded
76, 100        | Do Not Honour
77-78, 103     | Contact Acquirer
79–89, 100     | Do Not Honour
90, 906        | Cutover In Progress
92, 908        | Routing Error
93, 124        | Violation Of Law
94, 913        | Duplicate Transmission
95, 915        | Cutover Or Checkpoint Error
97, 100        | Do Not Honour
98, 121        | Exceeds Withdrawal Amount Limit

#### HTTP Status Code 500 - Internal Server Error

An unexpected internal exception ocurred

#### HTTP Status Code 503 - Service Unavailable

Response Codes | Description
-------------- | -------------------------------------------------------------------------------------------------------
22, 96, 909    | System Malfunction
91, 907        | Issuer Or Switch Inoperative

### HTTP Status Code 504 - Gateway Timeout

Timeout - no response received from upstream entity


## Supported EMV data elements

The following EMV TLV elements are currently supported by the emvData fields that may be present in Card and CardAuth objects.

EMV Tag    | Tag Name
---------- | -----------------------------------------------------------------------------------------------------------
9F02       | Amount Authorized
9F03       | Amount Other
4F         | Application Identifier
82         | Application Interchange Profile
9F36       | Application Transaction Counter
9F07       | Application Usage Control
8A         | Authorization Response Code
DF00       | Card Authentication Reliability Indicator
DF01       | Card Authentication Results Code
DF02       | Chip Condition Code
9F26       | Cryptogram
9F27       | Cryptogram Information Data
8E         | Cvm List
9F34       | Cvm Results
9F1E       | Interface Device Serial Number
9F0D       | Issuer Action Code Default
9F0E       | Issuer Action Code Denial
9F0F       | Issuer Action Code Online
9F10       | Issuer Application Data
DF09       | Issuer Script Results
9F09       | Terminal Application Version Number
9F33       | Terminal Capabilities
9F1A       | Terminal Country Code
9F35       | Terminal Type
95         | Terminal Verification Result
9F53       | Transaction Category Code
5F2A       | Transaction Currency Code
9A         | Transaction Date
9F41       | Transaction Sequence Counter
9C         | Transaction Type
9F37       | Unpredictable Number
CB         | Upper Cumulative Offline Transaction Amount1
9F6E       | Form Factor Indicator
9F7C       | Customer Exclusive Data
91         | Issuer Authentication Data
71         | Issuer Script Template1
72         | Issuer Script Template2
