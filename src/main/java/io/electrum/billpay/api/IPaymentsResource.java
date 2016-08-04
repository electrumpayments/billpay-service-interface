package io.electrum.billpay.api;

import io.electrum.billpay.model.PaymentRequest;
import io.electrum.billpay.model.PaymentReversal;
import io.electrum.vas.model.TenderAdvice;

import java.util.UUID;

import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

public interface IPaymentsResource {

   void confirmPaymentImpl(
         UUID id,
         UUID paymentId,
         TenderAdvice body,
         SecurityContext securityContext,
         AsyncResponse asyncResponse,
         HttpHeaders httpHeaders,
         UriInfo uriInfo);

   void createPaymentImpl(
         UUID id,
         PaymentRequest body,
         SecurityContext securityContext,
         AsyncResponse asyncResponse,
         HttpHeaders httpHeaders,
         UriInfo uriInfo);

   void reversePaymentImpl(
         UUID id,
         UUID paymentId,
         PaymentReversal body,
         SecurityContext securityContext,
         AsyncResponse asyncResponse,
         HttpHeaders httpHeaders,
         UriInfo uriInfo);
}
