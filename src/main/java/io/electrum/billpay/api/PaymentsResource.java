package io.electrum.billpay.api;

import io.electrum.billpay.model.PaymentRequest;
import io.electrum.billpay.model.PaymentResponse;
import io.electrum.billpay.model.PaymentReversal;
import io.electrum.vas.model.ErrorDetail;
import io.electrum.vas.model.TenderAdvice;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.ResponseHeader;

@Path("/payments/{paymentId}")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@Api(description = "the payments API", authorizations = { @Authorization("httpBasic") })
public abstract class PaymentsResource {

   protected abstract IPaymentsResource getResourceImplementation();

   @POST
   @Path("/confirmations/{adviceId}")
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(value = "Confirm an existing bill payment", notes = "If a createPayment request previously succeeded with a 201 status it must be confirmed or cancelled to complete the transaction. confirmPayment can only suceeed if a payment was created but not cancelled. confirmPayment must be repeated until a final HTTP status code is received (not 500 or 504). If a status code of either 500 or 504 is received, or no response is received, the request must be repeated. confirmPayment may be called repeatedly on the same payment resource without negative effect.")
   @ApiResponses(value = { @ApiResponse(code = 202, message = "Accepted"),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public void confirmPayment(
         @ApiParam(value = "The randomly generated UUID of this request", required = true) @PathParam("adviceId") UUID adviceId,
         @ApiParam(value = "The UUID generated for the original createPayment request", required = true) @PathParam("paymentId") UUID paymentId,
         @ApiParam(value = "A payment confirmation", required = true) TenderAdvice body,
         @Context SecurityContext securityContext,
         @Suspended AsyncResponse asyncResponse,
         @Context Request request,
         @Context HttpServletRequest httpServletRequest,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo) {

      getResourceImplementation().confirmPayment(
            adviceId,
            paymentId,
            body,
            securityContext,
            asyncResponse,
            request,
            httpServletRequest,
            httpHeaders,
            uriInfo);
   }

   @POST
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(value = "Initiate a bill payment transaction", notes = "Requests that a payment be made towards a customer account")
   @ApiResponses(value = {
         @ApiResponse(code = 201, message = "Created", response = PaymentResponse.class, responseHeaders = {
               @ResponseHeader(name = "Location", description = "The location of the created payments resource", response = String.class) }),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public void createPayment(
         @ApiParam(value = "The randomly generated UUID of this request", required = true) @PathParam("paymentId") UUID paymentId,
         @ApiParam(value = "A payment request", required = true) PaymentRequest body,
         @Context SecurityContext securityContext,
         @Suspended AsyncResponse asyncResponse,
         @Context Request request,
         @Context HttpServletRequest httpServletRequest,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo) {

      getResourceImplementation().createPayment(
            paymentId,
            body,
            securityContext,
            asyncResponse,
            request,
            httpServletRequest,
            httpHeaders,
            uriInfo);
   }

   @POST
   @Path("/reversals/{adviceId}")
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(value = "Reverse a payment request that failed or timed out", notes = "If a createPayment request fails with a 500 or 504 HTTP status code, or no response was received within the timeout period, it must be reversed to ensure the payment is not reflected on a customer's account. reversePayment must be repeated until a final HTTP status code is received (not 500 or 504). reversePayment may be called repeatedly on the same payment resource without negative effect.")
   @ApiResponses(value = { @ApiResponse(code = 202, message = "Accepted"),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public void reversePayment(
         @ApiParam(value = "The randomly generated UUID of this request", required = true) @PathParam("adviceId") UUID adviceId,
         @ApiParam(value = "The UUID generated for the original createPayment request", required = true) @PathParam("paymentId") UUID paymentId,
         @ApiParam(value = "A payment reversal", required = true) PaymentReversal body,
         @Context SecurityContext securityContext,
         @Suspended AsyncResponse asyncResponse,
         @Context Request request,
         @Context HttpServletRequest httpServletRequest,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo) {

      getResourceImplementation().reversePayment(
            adviceId,
            paymentId,
            body,
            securityContext,
            asyncResponse,
            request,
            httpServletRequest,
            httpHeaders,
            uriInfo);
   }
}
