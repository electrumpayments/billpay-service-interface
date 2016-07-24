---
title: Billpay Service Interface
type: index
---

[Electrum Payments](http://electrum.io) connects businesses together to transact with each other easily and robustly. This Billpay Service Interface documents the messaging interface used by Electrum to connect acquirers, processors, and issuers together for performing bill payment transactions.

Bill payments are enabled by issuing customers with an invoice containing a reference number that uniquely identifies the bill issuer and customer. The reference number also typically contains routing information to ensure transactions are sent to the correct processor, although other routing rules may also be used.

Customers then settle their accounts at a participating retailer, which might also first retrieve their outstanding balance. In addition, some processors and issuers also support requesting a refund after a bill has been successfully settled.
