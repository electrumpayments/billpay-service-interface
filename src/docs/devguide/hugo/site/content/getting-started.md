---
title: "Getting Started"
menu:
  main:
    weight: 0
---

The Billpay Service Interface is a RESTful HTTP based messaging protocol, used to connect retailers to bill payments processors, as well as to connect bill payments processors to Electrum.

Via the Billpay Service interface, Electrum enables acquiring institutions like retailers and banks to access an established and growing network of bill payments issuers and providers. At the same time, the Billpay Service Interface is made available to allow bill payments providers a quick route towards integrating into the Electrum network and access to participating acquirers. When starting out a development project using this interface, it is thus important to view this documentation either from the perspective of an acquirer developing a client application into the Electrum Billpay Service, or of a bill payments provider developing a server application with the view of accepting bill payments from Electrum.


## Supported languages

### Java

The Electrum implementation of the Billpay Service is written in Java. It is highly recommended that if you are planning a Java implementation of the Billpay service you include the [Billpay Service Interface](https://github.com/electrumpayments/billpay-service-interface) dependency in your project to save you from having to re-implementing the interface. You can find instructions in the project [readme](https://github.com/electrumpayments/billpay-service-interface).

### Other languages

The Billpay Service Interface is described as a [swagger (OpenApi) document](/specification/swagger). It is highly recommended that widely available swagger tooling is used to generate a project in your preferred language as a starting point to a new integration project.


## Testing

**TODO:** A test pack will be available soon for testing new server integrations.
