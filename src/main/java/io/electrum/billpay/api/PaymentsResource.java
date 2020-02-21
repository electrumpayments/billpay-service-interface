package io.electrum.billpay.api;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import io.electrum.billpay.model.ErrorDetail;
import io.electrum.billpay.model.PaymentRequest;
import io.electrum.billpay.model.PaymentResponse;
import io.electrum.billpay.model.PolicyPaymentRequest;
import io.electrum.billpay.model.PolicyPaymentResponse;
import io.electrum.billpay.model.TrafficFinePaymentRequest;
import io.electrum.billpay.model.TrafficFinePaymentResponse;
import io.electrum.billpay.validation.ConsistentAdviceIds;
import io.electrum.billpay.validation.ConsistentTransactionId;
import io.electrum.billpay.validation.Uuid;
import io.electrum.vas.model.BasicAdviceResponse;
import io.electrum.vas.model.BasicReversal;
import io.electrum.vas.model.TenderAdvice;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.ResponseHeader;

@Path(PaymentsResource.PATH)
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
@Api(description = "the payments API", authorizations = { @Authorization("httpBasic") })
public abstract class PaymentsResource {

   protected abstract IPaymentsResource getResourceImplementation();

   public static final String PATH = BillpayApi.API_BASE_PATH + "/payments";

   public class ConfirmPayment {
      public static final String OPERATION = "confirmPayment";
      public static final int SUCCESS = 202;
      public static final String RELATIVE_PATH =
            "/" + "{" + PathParameters.PAYMENT_ID + "}" + "/confirmations/" + "{" + PathParameters.ADVICE_ID + "}";
      public static final String FULL_PATH = PaymentsResource.PATH + RELATIVE_PATH;

      public class PathParameters {
         public static final String PAYMENT_ID = "paymentId";
         public static final String ADVICE_ID = "adviceId";
      }
   }

   public class CreateAccountPayment {
      public static final String OPERATION = "createAccountPayment";
      public static final int SUCCESS = 201;
      public static final String RELATIVE_PATH = "/" + "{" + PathParameters.PAYMENT_ID + "}";
      public static final String FULL_PATH = PaymentsResource.PATH + RELATIVE_PATH;

      public class PathParameters {
         public static final String PAYMENT_ID = "paymentId";
      }
   }

   public class CreateTrafficFinePayment {
      public static final String OPERATION = "createTrafficFinePayment";
      public static final int SUCCESS = 201;
      public static final String RELATIVE_PATH = "/traffic/" + "{" + PathParameters.PAYMENT_ID + "}";
      public static final String FULL_PATH = PaymentsResource.PATH + RELATIVE_PATH;

      public class PathParameters {
         public static final String PAYMENT_ID = "paymentId";
      }
   }

   public class CreatePolicyPayment {
      public static final String OPERATION = "createPolicyPayment";
      public static final int SUCCESS = 201;
      public static final String RELATIVE_PATH = "/policy/" + "{" + PathParameters.PAYMENT_ID + "}";
      public static final String FULL_PATH = PaymentsResource.PATH + RELATIVE_PATH;

      public class PathParameters {
         public static final String PAYMENT_ID = "paymentId";
      }
   }

   public class ReversePayment {
      public static final String OPERATION = "reversePayment";
      public static final int SUCCESS = 202;
      public static final String RELATIVE_PATH =
            "/{" + PathParameters.PAYMENT_ID + "}/reversals/" + "{" + PathParameters.ADVICE_ID + "}";
      public static final String FULL_PATH = PaymentsResource.PATH + RELATIVE_PATH;

      public class PathParameters {
         public static final String PAYMENT_ID = "paymentId";
         public static final String ADVICE_ID = "adviceId";
      }
   }

   @POST
   @Path(ConfirmPayment.RELATIVE_PATH)
   @ApiOperation(value = "Confirm an existing bill payment", nickname = ConfirmPayment.OPERATION, notes = "If a createPayment request previously succeeded with a 201 status it must be confirmed or cancelled to complete the transaction. confirmPayment can only succeed if a payment was created but not cancelled. confirmPayment must be repeated until a final HTTP status code is received (not 500 or 504). If a status code of either 500 or 504 is received, or no response is received, the request must be repeated. confirmPayment may be called repeatedly on the same payment resource without negative effect.")
   @ApiResponses(value = { @ApiResponse(code = 202, message = "Accepted", response = BasicAdviceResponse.class),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   @ConsistentAdviceIds
   public void confirmPayment(
         @ApiParam(value = "The randomly generated UUID of this request", required = true) @PathParam(ConfirmPayment.PathParameters.ADVICE_ID) @NotNull @Uuid String adviceId,
         @ApiParam(value = "The UUID generated for the original createPayment request", required = true) @PathParam(ConfirmPayment.PathParameters.PAYMENT_ID) @NotNull @Uuid String paymentId,
         @ApiParam(value = "A payment confirmation", required = true) @NotNull @Valid TenderAdvice body,
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
   @Path(CreateAccountPayment.RELATIVE_PATH)
   @ApiOperation(value = "Initiate a bill payment transaction", nickname = CreateAccountPayment.OPERATION, notes = "Requests that a payment be made towards a customer account")
   @ApiResponses(value = {
         @ApiResponse(code = 201, message = "Created", response = PaymentResponse.class, responseHeaders = {
               @ResponseHeader(name = "Location", description = "The location of the created payments resource", response = String.class) }),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   @ConsistentTransactionId
   public void createPayment(
         @ApiParam(value = "The randomly generated UUID of this request", required = true) @PathParam(CreateAccountPayment.PathParameters.PAYMENT_ID) @NotNull @Uuid String paymentId,
         @ApiParam(value = "A payment request", required = true) @NotNull @Valid PaymentRequest body,
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
   @Path(CreateTrafficFinePayment.RELATIVE_PATH)
   @ApiOperation(value = "Initiate a traffic fine payment transaction", nickname = CreateTrafficFinePayment.OPERATION, notes = "Requests that a payment be made towards a traffic fine.")
   @ApiResponses(value = {
         @ApiResponse(code = 201, message = "Created", response = TrafficFinePaymentResponse.class, responseHeaders = {
               @ResponseHeader(name = "Location", description = "The location of the created payments resource", response = String.class) }),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   @ConsistentTransactionId
   public void createPayment(
         @ApiParam(value = "The randomly generated UUID of this request", required = true) @PathParam(CreateTrafficFinePayment.PathParameters.PAYMENT_ID) @NotNull @Uuid String paymentId,
         @ApiParam(value = "A traffic fine payment request", required = true) @NotNull @Valid TrafficFinePaymentRequest body,
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
   @Path(CreatePolicyPayment.RELATIVE_PATH)
   @ApiOperation(value = "Initiate a policy payment transaction", nickname = CreatePolicyPayment.OPERATION, notes = "Requests that a payment be made towards a policy.")
   @ApiResponses(value = {
         @ApiResponse(code = 201, message = "Created", response = PolicyPaymentResponse.class, responseHeaders = {
               @ResponseHeader(name = "Location", description = "The location of the created payments resource", response = String.class) }),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   @ConsistentTransactionId
   public void createPayment(
         @ApiParam(value = "The randomly generated UUID of this request", required = true) @PathParam(CreatePolicyPayment.PathParameters.PAYMENT_ID) @NotNull @Uuid String paymentId,
         @ApiParam(value = "A policy payment request", required = true) @NotNull @Valid PolicyPaymentRequest body,
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
   @Path(ReversePayment.RELATIVE_PATH)
   @ApiOperation(value = "Reverse a payment request that failed or timed out", nickname = ReversePayment.OPERATION, notes = "If a createPayment request fails with a 500 or 504 HTTP status code, or no response was received within the timeout period, it must be reversed to ensure the payment is not reflected on a customer's account. reversePayment must be repeated until a final HTTP status code is received (not 500 or 504). reversePayment may be called repeatedly on the same payment resource without negative effect.")
   @ApiResponses(value = { @ApiResponse(code = 202, message = "Accepted", response = BasicAdviceResponse.class),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   @ConsistentAdviceIds
   public void reversePayment(
         @ApiParam(value = "The randomly generated UUID of this request", required = true) @PathParam(ReversePayment.PathParameters.ADVICE_ID) @NotNull @Uuid String adviceId,
         @ApiParam(value = "The UUID generated for the original createPayment request", required = true) @PathParam(ReversePayment.PathParameters.PAYMENT_ID) @NotNull @Uuid String paymentId,
         @ApiParam(value = "A payment reversal", required = true) @NotNull @Valid BasicReversal body,
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

   /**
    * Use <code>ConfirmPayment.OPERATION, CreateAccountPayment.OPERATION, CreateTrafficFinePayment.OPERATION, 
    * CreatePolicyPayment.OPERATION, ReversePayment.OPERATION </code> instead.
    */
   @Deprecated
   public class Operations {
      public static final String CREATE_POLICY_PAYMENT = "createPolicyPayment";
      public static final String CREATE_TRAFFICE_FINE_PAYMENT = "createTrafficFinePayment";
      public static final String CREATE_ACCOUNT_PAYMENT = "createAccountPayment";
      public static final String CONFIRM_PAYMENT = "confirmPayment";
      public static final String REVERSE_PAYMENT = "reversePayment";
   }
}
