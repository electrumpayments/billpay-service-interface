package io.electrum.billpay.api;

import io.electrum.billpay.model.Cancellation;
import io.electrum.billpay.model.PaymentConfirmation;
import io.electrum.billpay.model.PaymentRequest;
import io.electrum.billpay.model.RefundConfirmation;
import io.electrum.billpay.model.RefundRequest;

import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

public interface IPaymentsResource {

   void cancelPayment(
         String paymentId,
         Cancellation body,
         SecurityContext securityContext,
         AsyncResponse asyncResponse,
         HttpHeaders httpHeaders,
         UriInfo uriInfo);

   void cancelRefund(
         String refundId,
         Cancellation body,
         SecurityContext securityContext,
         AsyncResponse asyncResponse,
         HttpHeaders httpHeaders,
         UriInfo uriInfo);

   void confirmPayment(
         String paymentId,
         PaymentConfirmation body,
         SecurityContext securityContext,
         AsyncResponse asyncResponse,
         HttpHeaders httpHeaders,
         UriInfo uriInfo);

   void confirmRefund(
         String refundId,
         RefundConfirmation body,
         SecurityContext securityContext,
         AsyncResponse asyncResponse,
         HttpHeaders httpHeaders,
         UriInfo uriInfo);

   void createPayment(
         PaymentRequest body,
         SecurityContext securityContext,
         AsyncResponse asyncResponse,
         HttpHeaders httpHeaders,
         UriInfo uriInfo);

   void createRefund(
         RefundRequest body,
         SecurityContext securityContext,
         AsyncResponse asyncResponse,
         HttpHeaders httpHeaders,
         UriInfo uriInfo);

   void reversePayment(
         PaymentRequest body,
         SecurityContext securityContext,
         AsyncResponse asyncResponse,
         HttpHeaders httpHeaders,
         UriInfo uriInfo);

   void reverseRefund(
         RefundRequest body,
         SecurityContext securityContext,
         AsyncResponse asyncResponse,
         HttpHeaders httpHeaders,
         UriInfo uriInfo);
}
