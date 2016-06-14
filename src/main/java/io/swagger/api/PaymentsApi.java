package io.swagger.api;

import io.swagger.annotations.ApiParam;
import io.swagger.api.factories.PaymentsApiServiceFactory;
import io.swagger.model.Cancellation;
import io.swagger.model.PaymentConfirmation;
import io.swagger.model.PaymentRequest;
import io.swagger.model.PaymentResponse;
import io.swagger.model.RefundConfirmation;
import io.swagger.model.RefundRequest;
import io.swagger.model.RefundResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/payments")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(description = "the payments API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-06-13T18:34:39.493Z")
public class PaymentsApi {
   private final PaymentsApiService delegate = PaymentsApiServiceFactory.getPaymentsApi();

   @POST
   @Path("/{paymentId}/cancellations")
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @io.swagger.annotations.ApiOperation(value = "Cancel an existing bill payment", notes = "If a createPayment request previously succeeded with a 201 status it must be confirmed or cancelled to complete the transaction. cancelPayment can only suceeed if a payment was created but not confirmed. cancelPayment must be repeated until a final HTTP status code is received (not 500 or 504). If a status code of either 500 or 504 is received, or no response is received, the request must be repeated. cancelPayment may be called repeatedly on the same payment resource without negative effect.", response = void.class, tags = {})
   @io.swagger.annotations.ApiResponses(value = {
         @io.swagger.annotations.ApiResponse(code = 202, message = "Accepted", response = void.class),
         @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request", response = void.class),
         @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error - MUST REPEAT", response = void.class),
         @io.swagger.annotations.ApiResponse(code = 503, message = "Service Unavailable", response = void.class),
         @io.swagger.annotations.ApiResponse(code = 504, message = "Gateway Timeout - MUST REPEAT", response = void.class),
         @io.swagger.annotations.ApiResponse(code = 200, message = "Failure", response = void.class) })
   public Response cancelPayment(
         @ApiParam(value = "The id returned in the corresponding createPayment response", required = true) @PathParam("paymentId") String paymentId,
         @ApiParam(value = "A cancellation", required = true) Cancellation body,
         @Context SecurityContext securityContext) throws NotFoundException {
      return delegate.cancelPayment(paymentId, body, securityContext);
   }

   @POST
   @Path("/refunds/{refundId}/cancellations")
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @io.swagger.annotations.ApiOperation(value = "Cancel an existing bill payment refund", notes = "If a createRefund request previously succeeded with a 201 status it must be confirmed or cancelled to complete the transaction. cancelRefund can only suceeed if a refund was created but not confirmed. cancelRefund must be repeated until a final HTTP status code is received (not 500 or 504). If a status code of either 500 or 504 is received, or no response is received, the request must be repeated. cancelRefund may be called repeatedly on the same payment resource without negative effect.", response = void.class, tags = {})
   @io.swagger.annotations.ApiResponses(value = {
         @io.swagger.annotations.ApiResponse(code = 202, message = "Accepted", response = void.class),
         @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request", response = void.class),
         @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error - MUST REPEAT", response = void.class),
         @io.swagger.annotations.ApiResponse(code = 503, message = "Service Unavailable", response = void.class),
         @io.swagger.annotations.ApiResponse(code = 504, message = "Gateway Timeout - MUST REPEAT", response = void.class),
         @io.swagger.annotations.ApiResponse(code = 200, message = "Failure", response = void.class) })
   public Response cancelRefund(
         @ApiParam(value = "The id returned in the corresponding createRefund response", required = true) @PathParam("refundId") String refundId,
         @ApiParam(value = "A cancellation", required = true) Cancellation body,
         @Context SecurityContext securityContext) throws NotFoundException {
      return delegate.cancelRefund(refundId, body, securityContext);
   }

   @POST
   @Path("/{paymentId}/confirmations")
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @io.swagger.annotations.ApiOperation(value = "Confirm an existing bill payment", notes = "If a createPayment request previously succeeded with a 201 status it must be confirmed or cancelled to complete the transaction. confirmPayment can only suceeed if a payment was created but not cancelled. confirmPayment must be repeated until a final HTTP status code is received (not 500 or 504). If a status code of either 500 or 504 is received, or no response is received, the request must be repeated. confirmPayment may be called repeatedly on the same payment resource without negative effect.", response = void.class, tags = {})
   @io.swagger.annotations.ApiResponses(value = {
         @io.swagger.annotations.ApiResponse(code = 202, message = "Accepted", response = void.class),
         @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request", response = void.class),
         @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error - MUST REPEAT", response = void.class),
         @io.swagger.annotations.ApiResponse(code = 503, message = "Service Unavailable", response = void.class),
         @io.swagger.annotations.ApiResponse(code = 504, message = "Gateway Timeout - MUST REPEAT", response = void.class),
         @io.swagger.annotations.ApiResponse(code = 200, message = "Failure", response = void.class) })
   public Response confirmPayment(
         @ApiParam(value = "The id returned in the corresponding createPayment response", required = true) @PathParam("paymentId") String paymentId,
         @ApiParam(value = "A payment confirmation", required = true) PaymentConfirmation body,
         @Context SecurityContext securityContext) throws NotFoundException {
      return delegate.confirmPayment(paymentId, body, securityContext);
   }

   @POST
   @Path("/refunds/{refundId}/confirmations")
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @io.swagger.annotations.ApiOperation(value = "Confirm an existing bill payment refund", notes = "If a createRefund request previously succeeded with a 201 status it must be confirmed or cancelled to complete the transaction. confirmRefund can only suceeed if a refund was created but not cancelled. confirmRefund must be repeated until a final HTTP status code is received (not 500 or 504). If a status code of either 500 or 504 is received, or no response is received, the request must be repeated. confirmRefund may be called repeatedly on the same refund resource without negative effect.", response = void.class, tags = {})
   @io.swagger.annotations.ApiResponses(value = {
         @io.swagger.annotations.ApiResponse(code = 202, message = "Accepted", response = void.class),
         @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request", response = void.class),
         @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error - MUST REPEAT", response = void.class),
         @io.swagger.annotations.ApiResponse(code = 503, message = "Service Unavailable", response = void.class),
         @io.swagger.annotations.ApiResponse(code = 504, message = "Gateway Timeout - MUST REPEAT", response = void.class),
         @io.swagger.annotations.ApiResponse(code = 200, message = "Failure", response = void.class) })
   public Response confirmRefund(
         @ApiParam(value = "The id returned in the corresponding createRefund response", required = true) @PathParam("refundId") String refundId,
         @ApiParam(value = "A refund confirmation", required = true) RefundConfirmation body,
         @Context SecurityContext securityContext) throws NotFoundException {
      return delegate.confirmRefund(refundId, body, securityContext);
   }

   @POST
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @io.swagger.annotations.ApiOperation(value = "Initiate a bill payment transaction", notes = "Request that a payment be made towards a customer account", response = PaymentResponse.class, tags = {})
   @io.swagger.annotations.ApiResponses(value = {
         @io.swagger.annotations.ApiResponse(code = 201, message = "Created", response = PaymentResponse.class),
         @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request", response = PaymentResponse.class),
         @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error - MUST REVERSE", response = PaymentResponse.class),
         @io.swagger.annotations.ApiResponse(code = 503, message = "Service Unavailable", response = PaymentResponse.class),
         @io.swagger.annotations.ApiResponse(code = 504, message = "Gateway Timeout - MUST REVERSE", response = PaymentResponse.class),
         @io.swagger.annotations.ApiResponse(code = 200, message = "Failure", response = PaymentResponse.class) })
   public Response createPayment(
         @ApiParam(value = "A payment request", required = true) PaymentRequest body,
         @Context SecurityContext securityContext) throws NotFoundException {
      return delegate.createPayment(body, securityContext);
   }

   @POST
   @Path("/refunds")
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @io.swagger.annotations.ApiOperation(value = "Creates a refund of previously confirmed payment", notes = "If a payment is completed and confirmed successfully, some services support that customers may request a refund for a particular payment for some time after the payment took place. Not all services support refunds. In the case where this function is not supported for the requested service, a 501 HTTP status code may be returned", response = RefundResponse.class, tags = {})
   @io.swagger.annotations.ApiResponses(value = {
         @io.swagger.annotations.ApiResponse(code = 201, message = "Created", response = RefundResponse.class),
         @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request", response = RefundResponse.class),
         @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error - MUST REVERSE", response = RefundResponse.class),
         @io.swagger.annotations.ApiResponse(code = 501, message = "Not implemented - in the case where the service does not support refunds", response = RefundResponse.class),
         @io.swagger.annotations.ApiResponse(code = 503, message = "Service Unavailable", response = RefundResponse.class),
         @io.swagger.annotations.ApiResponse(code = 504, message = "Gateway Timeout - MUST REVERSE", response = RefundResponse.class),
         @io.swagger.annotations.ApiResponse(code = 200, message = "Failure", response = RefundResponse.class) })
   public Response createRefund(
         @ApiParam(value = "A refund request", required = true) RefundRequest body,
         @Context SecurityContext securityContext) throws NotFoundException {
      return delegate.createRefund(body, securityContext);
   }

   @POST
   @Path("/reversals")
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @io.swagger.annotations.ApiOperation(value = "Reverse a payment request that failed or timed out", notes = "If a createPayment request fails with a 500 or 504 HTTP status code, or no response was received within the timeout period, it must be reversed to ensure the payment is not refelected on a customer's account. reversePayment must be repeated until a final HTTP status code is received (not 500 or 504). reversePayment may be called repeatedly on the same payment resource without negative effect.", response = void.class, tags = {})
   @io.swagger.annotations.ApiResponses(value = {
         @io.swagger.annotations.ApiResponse(code = 202, message = "Accepted", response = void.class),
         @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request", response = void.class),
         @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error - MUST REVERSE", response = void.class),
         @io.swagger.annotations.ApiResponse(code = 503, message = "Service Unavailable", response = void.class),
         @io.swagger.annotations.ApiResponse(code = 504, message = "Gateway Timeout - MUST REVERSE", response = void.class),
         @io.swagger.annotations.ApiResponse(code = 200, message = "Failure", response = void.class) })
   public Response reversePayment(
         @ApiParam(value = "The PaymentRequest originally sent in the createPayment request", required = true) PaymentRequest body,
         @Context SecurityContext securityContext) throws NotFoundException {
      return delegate.reversePayment(body, securityContext);
   }

   @POST
   @Path("/refunds/reversals")
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @io.swagger.annotations.ApiOperation(value = "Reverse a refund request that failed or timed out", notes = "If a createRefund request fails with a 500 or 504 HTTP status code, or no response was received within the timeout period, it must be reversed to ensure the payment is not refelected on a customer's account. reverseRefund must be repeated until a final HTTP status code is received (not 500 or 504). reverseRefund may be called repeatedly on the same payment resource without negative effect.", response = void.class, tags = {})
   @io.swagger.annotations.ApiResponses(value = {
         @io.swagger.annotations.ApiResponse(code = 202, message = "Accepted", response = void.class),
         @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request", response = void.class),
         @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error - MUST REVERSE", response = void.class),
         @io.swagger.annotations.ApiResponse(code = 503, message = "Service Unavailable", response = void.class),
         @io.swagger.annotations.ApiResponse(code = 504, message = "Gateway Timeout - MUST REVERSE", response = void.class),
         @io.swagger.annotations.ApiResponse(code = 200, message = "Failure", response = void.class) })
   public Response reverseRefund(
         @ApiParam(value = "The RefundRequest originally sent in the createRefund request", required = true) RefundRequest body,
         @Context SecurityContext securityContext) throws NotFoundException {
      return delegate.reverseRefund(body, securityContext);
   }
}
