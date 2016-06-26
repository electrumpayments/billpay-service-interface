---
title: Billpay Service Interface
type: index
---

[Electrum Payments](http://electrum.io) connects businesses together in order to easily and robustly transact with each other. This Billpay Service Interface documents the messaging interface used by Electrum to connect acquirers, processors, and issuers together for performing bill payments transactions.

Bill payments are enabled by issuing customers with an invoice containing a reference number that uniquely identifies the bill issuer and customer. The reference number also typically contains routing information to ensure transactions are sent to the correct processor, although other routing rules may also be used.

Customers then settle their accounts at a participating retailer, possibly in the process also first retrieving their outstanding balance. In addition, some issuers also support requesting a refund after a bill has been successfully settled.
