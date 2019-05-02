# Billpay Service Interface  [![CircleCI](https://circleci.com/gh/electrumpayments/billpay-service-interface/tree/master.svg?style=shield)](https://circleci.com/gh/electrumpayments/billpay-service-interface/tree/master)

The Billpay Service Interface documents the messaging interface used by Electrum to connect acquirers, processors, and issuers together for performing bill payments transactions.

You can find documentation for this project [here](https://electrumpayments.github.io/billpay-service-interface-docs/).

## Java projects

To include the service interface into your maven project, include the below dependencies.

```xml
<dependency>
    <groupId>io.electrum</groupId>
    <artifactId>billpay-service-interface</artifactId>
    <version>4.7.4</version>
</dependency>
<dependency>
    <groupId>io.electrum</groupId>
    <artifactId>service-interface-base</artifactId>
    <version>3.20.0</version>
</dependency>
```

Alternatively, you can download the jar from [Bintray](https://bintray.com/electrumpayments/java-open-source/billpay-service-interface).

## Other languages

The interface is also available as a swagger (OpenApi) definition, which can be used to generate starter projects in many languages. See more info [here](https://electrumpayments.github.io/billpay-service-interface-docs/specification/swagger).
