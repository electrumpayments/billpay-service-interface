package io.electrum.billpay.api;

import io.electrum.billpay.model.RefundRequest;
import io.electrum.billpay.model.RefundReversal;
import io.electrum.vas.model.BasicAdvice;

import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import java.util.UUID;

public interface IRefundsResource {

   void confirmRefundImpl(
         UUID id,
         UUID refundId,
         BasicAdvice body,
         SecurityContext securityContext,
         AsyncResponse asyncResponse,
         HttpHeaders httpHeaders,
         UriInfo uriInfo);

   void createRefundImpl(
         UUID id,
         RefundRequest body,
         SecurityContext securityContext,
         AsyncResponse asyncResponse,
         HttpHeaders httpHeaders,
         UriInfo uriInfo);

   void reverseRefundImpl(
         UUID id,
         UUID refundId,
         RefundReversal body,
         SecurityContext securityContext,
         AsyncResponse asyncResponse,
         HttpHeaders httpHeaders,
         UriInfo uriInfo);
}
