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
import io.electrum.billpay.model.RefundRequest;
import io.electrum.billpay.model.RefundResponse;
import io.electrum.billpay.validation.ConsistentAdviceIds;
import io.electrum.billpay.validation.ConsistentTransactionId;
import io.electrum.vas.model.BasicAdvice;
import io.electrum.vas.model.BasicAdviceResponse;
import io.electrum.vas.model.BasicReversal;
import io.electrum.vas.validation.Uuid;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.ResponseHeader;

@Path(RefundsResource.PATH)
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
@Api(description = "the refunds API", authorizations = { @Authorization("httpBasic") })
public abstract class RefundsResource {

   protected abstract IRefundsResource getResourceImplementation();

   public static final String PATH = BillpayApi.API_BASE_PATH + "/refunds";

   public class ConfirmRefund {
      public static final String OPERATION = "confirmRefund";
      public static final int SUCCESS = 202;
      public static final String RELATIVE_PATH =
            "/{" + PathParameters.REFUND_ID + "}/confirmations/" + "{" + PathParameters.ADVICE_ID + "}";
      public static final String FULL_PATH = RefundsResource.PATH + RELATIVE_PATH;

      public class PathParameters {
         public static final String ADVICE_ID = "adviceId";
         public static final String REFUND_ID = "refundId";
      }
   }

   public class CreateRefund {
      public static final String OPERATION = "createRefund";
      public static final int SUCCESS = 201;
      public static final String RELATIVE_PATH = "/{" + PathParameters.REFUND_ID + "}";
      public static final String FULL_PATH = RefundsResource.PATH + RELATIVE_PATH;

      public class PathParameters {
         public static final String ADVICE_ID = "adviceId";
         public static final String REFUND_ID = "refundId";
      }
   }

   public class ReverseRefund {
      public static final String OPERATION = "reverseRefund";
      public static final int SUCCESS = 202;
      public static final String RELATIVE_PATH =
            "/{" + PathParameters.REFUND_ID + "}/reversals/" + "{" + PathParameters.ADVICE_ID + "}";
      public static final String FULL_PATH = RefundsResource.PATH + RELATIVE_PATH;

      public class PathParameters {
         public static final String ADVICE_ID = "adviceId";
         public static final String REFUND_ID = "refundId";
      }
   }

   @POST
   @Path(ConfirmRefund.RELATIVE_PATH)
   @ApiOperation(value = "Confirm an existing bill payment refund", nickname = ConfirmRefund.OPERATION, notes = "If a createRefund request previously succeeded with a 201 status it must be confirmed or reversed to complete the transaction. confirmRefund can only succeed if a refund was created but not reversed. confirmRefund must be repeated until a final HTTP status code is received (not 500 or 504). If a status code of either 500 or 504 is received, or no response is received, the request must be repeated. confirmRefund may be called repeatedly on the same refund resource without negative effect.")
   @ApiResponses(value = { @ApiResponse(code = 202, message = "Accepted", response = BasicAdviceResponse.class),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   @ConsistentAdviceIds
   public void confirmRefund(
         @ApiParam(value = "The randomly generated UUID of this request", required = true) @PathParam(ConfirmRefund.PathParameters.ADVICE_ID) @NotNull @Uuid String adviceId,
         @ApiParam(value = "The UUID generated for the corresponding createRefund request", required = true) @PathParam(ConfirmRefund.PathParameters.REFUND_ID) @NotNull @Uuid String refundId,
         @ApiParam(value = "A refund confirmation", required = true) @NotNull @Valid BasicAdvice body,
         @Context SecurityContext securityContext,
         @Suspended AsyncResponse asyncResponse,
         @Context Request request,
         @Context HttpServletRequest httpServletRequest,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo) {

      getResourceImplementation().confirmRefund(
            adviceId,
            refundId,
            body,
            securityContext,
            asyncResponse,
            request,
            httpServletRequest,
            httpHeaders,
            uriInfo);
   }

   @POST
   @Path(CreateRefund.RELATIVE_PATH)
   @ApiOperation(value = "Creates a refund of previously confirmed payment", nickname = CreateRefund.OPERATION, notes = "If a payment is completed and confirmed successfully, some services support that customers may request a refund for a particular payment for some time after the payment took place. Not all services support refunds. In the case where this function is not supported for the requested service, a 501 HTTP status code may be returned")
   @ApiResponses(value = {
         @ApiResponse(code = 201, message = "Created", response = RefundResponse.class, responseHeaders = {
               @ResponseHeader(name = "Location", description = "The location of the created refund resource", response = String.class) }),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 501, message = "Not implemented", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   @ConsistentTransactionId
   public void createRefund(
         @ApiParam(value = "The randomly generated UUID of this request", required = true) @PathParam(CreateRefund.PathParameters.REFUND_ID) @NotNull @Uuid String refundId,
         @ApiParam(value = "A refund request", required = true) @NotNull @Valid RefundRequest body,
         @Context SecurityContext securityContext,
         @Suspended AsyncResponse asyncResponse,
         @Context Request request,
         @Context HttpServletRequest httpServletRequest,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo) {

      getResourceImplementation().createRefund(
            refundId,
            body,
            securityContext,
            asyncResponse,
            request,
            httpServletRequest,
            httpHeaders,
            uriInfo);
   }

   @POST
   @Path(ReverseRefund.RELATIVE_PATH)
   @ApiOperation(value = "Reverse a refund request that failed or timed out", nickname = ReverseRefund.OPERATION, notes = "If a createRefund request fails with a 500 or 504 HTTP status code, or no response was received within the timeout period, it must be reversed to ensure the payment is not refelected on a customer's account. reverseRefund must be repeated until a final HTTP status code is received (not 500 or 504). reverseRefund may be called repeatedly on the same payment resource without negative effect.")
   @ApiResponses(value = { @ApiResponse(code = 202, message = "Accepted", response = BasicAdviceResponse.class),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   @ConsistentAdviceIds
   public void reverseRefund(
         @ApiParam(value = "The randomly generated UUID of this request", required = true) @PathParam(ReverseRefund.PathParameters.ADVICE_ID) @NotNull @Uuid String adviceId,
         @ApiParam(value = "The UUID generated for the corresponding createRefund request", required = true) @PathParam(ReverseRefund.PathParameters.REFUND_ID) @NotNull @Uuid String refundId,
         @ApiParam(value = "A refund reversal", required = true) @NotNull @Valid BasicReversal body,
         @Context SecurityContext securityContext,
         @Suspended AsyncResponse asyncResponse,
         @Context Request request,
         @Context HttpServletRequest httpServletRequest,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo) {

      getResourceImplementation().reverseRefund(
            adviceId,
            refundId,
            body,
            securityContext,
            asyncResponse,
            request,
            httpServletRequest,
            httpHeaders,
            uriInfo);
   }

   /**
    * Use <code>ConfirmRefund.OPERATION, CreateRefund.OPERATION, ReverseRefund.OPERATION </code> instead.
    */
   @Deprecated
   public class Operations {
      public static final String CREATE_REFUND = "createRefund";
      public static final String CONFIRM_REFUND = "confirmRefund";
      public static final String REVERSE_REFUND = "reverseRefund";
   }
}
