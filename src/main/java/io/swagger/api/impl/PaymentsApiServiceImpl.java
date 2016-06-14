package io.swagger.api.impl;

import io.swagger.api.ApiResponseMessage;
import io.swagger.api.NotFoundException;
import io.swagger.api.PaymentsApiService;
import io.swagger.model.Cancellation;
import io.swagger.model.PaymentConfirmation;
import io.swagger.model.PaymentRequest;
import io.swagger.model.RefundConfirmation;
import io.swagger.model.RefundRequest;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-06-13T18:34:39.493Z")
public class PaymentsApiServiceImpl extends PaymentsApiService {
   @Override
   public Response cancelPayment(String paymentId, Cancellation body, SecurityContext securityContext)
         throws NotFoundException {
      // do some magic!
      return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
   }

   @Override
   public Response cancelRefund(String refundId, Cancellation body, SecurityContext securityContext)
         throws NotFoundException {
      // do some magic!
      return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
   }

   @Override
   public Response confirmPayment(String paymentId, PaymentConfirmation body, SecurityContext securityContext)
         throws NotFoundException {
      // do some magic!
      return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
   }

   @Override
   public Response confirmRefund(String refundId, RefundConfirmation body, SecurityContext securityContext)
         throws NotFoundException {
      // do some magic!
      return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
   }

   @Override
   public Response createPayment(PaymentRequest body, SecurityContext securityContext) throws NotFoundException {
      // do some magic!
      return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
   }

   @Override
   public Response createRefund(RefundRequest body, SecurityContext securityContext) throws NotFoundException {
      // do some magic!
      return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
   }

   @Override
   public Response reversePayment(PaymentRequest body, SecurityContext securityContext) throws NotFoundException {
      // do some magic!
      return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
   }

   @Override
   public Response reverseRefund(RefundRequest body, SecurityContext securityContext) throws NotFoundException {
      // do some magic!
      return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
   }
}
