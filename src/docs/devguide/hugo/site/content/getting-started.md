---
title: "Getting Started"
menu:
  main:
    weight: 0
---

The Billpay Service Interface is an apache licensed RESTful HTTP based messaging protocol, intended to enable interoperability between bill payment service providers and retailers/retail banks.

Using the Billpay Service Interface enables retailers/retail banks to access an established and growing group of bill payments service providers who support the interface. At the same time, the Billpay Service Interface is made available to allow bill payment service providers a quick, well defined route towards integrating into retailers/retail banks.

When starting out a development project using this interface, it is thus important to view this documentation either from the perspective of an transaction acquirer developing a client application into the Electrum Billpay Service, or of a bill payments provider or issuer developing a server application with the view of accepting bill payments from an Electrum acquirer.


## Supported languages

### Java

The Electrum implementation of the Billpay Service is written in Java. It is highly recommended that if you are planning a Java implementation of the Billpay service you include the [Billpay Service Interface](https://github.com/electrumpayments/billpay-service-interface) maven dependency in your project to save you from having to re-implementing the interface. You can find instructions in the project [readme](https://github.com/electrumpayments/billpay-service-interface).

### Other languages

The Billpay Service Interface is described as a [swagger (OpenApi) document](/specification/swagger). It is highly recommended that widely available swagger tooling is used to generate a project in your preferred language as a starting point to a new integration project.


## Testing

**TODO:** A test pack will be available soon for testing new server integrations.
