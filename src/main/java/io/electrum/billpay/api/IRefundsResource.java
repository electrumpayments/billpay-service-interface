package io.electrum.billpay.api;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import io.electrum.billpay.model.RefundRequest;
import io.electrum.vas.model.BasicAdvice;
import io.electrum.vas.model.BasicReversal;

public interface IRefundsResource {

   public void confirmRefund(
         UUID id,
         UUID refundId,
         BasicAdvice body,
         SecurityContext securityContext,
         AsyncResponse asyncResponse,
         Request request,
         HttpServletRequest httpServletRequest,
         HttpHeaders httpHeaders,
         UriInfo uriInfo);

   public void createRefund(
         UUID id,
         RefundRequest body,
         SecurityContext securityContext,
         AsyncResponse asyncResponse,
         Request request,
         HttpServletRequest httpServletRequest,
         HttpHeaders httpHeaders,
         UriInfo uriInfo);

   public void reverseRefund(
         UUID id,
         UUID refundId,
         BasicReversal body,
         SecurityContext securityContext,
         AsyncResponse asyncResponse,
         Request request,
         HttpServletRequest httpServletRequest,
         HttpHeaders httpHeaders,
         UriInfo uriInfo);
}
