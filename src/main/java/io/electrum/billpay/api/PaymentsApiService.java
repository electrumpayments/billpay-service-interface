package io.electrum.billpay.api;

import io.electrum.billpay.model.Cancellation;
import io.electrum.billpay.model.PaymentConfirmation;
import io.electrum.billpay.model.PaymentRequest;
import io.electrum.billpay.model.RefundConfirmation;
import io.electrum.billpay.model.RefundRequest;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-06-13T18:34:39.493Z")
public abstract class PaymentsApiService {
   public abstract Response cancelPayment(String paymentId, Cancellation body, SecurityContext securityContext)
         throws NotFoundException;

   public abstract Response cancelRefund(String refundId, Cancellation body, SecurityContext securityContext)
         throws NotFoundException;

   public abstract Response confirmPayment(String paymentId, PaymentConfirmation body, SecurityContext securityContext)
         throws NotFoundException;

   public abstract Response confirmRefund(String refundId, RefundConfirmation body, SecurityContext securityContext)
         throws NotFoundException;

   public abstract Response createPayment(PaymentRequest body, SecurityContext securityContext)
         throws NotFoundException;

   public abstract Response createRefund(RefundRequest body, SecurityContext securityContext) throws NotFoundException;

   public abstract Response reversePayment(PaymentRequest body, SecurityContext securityContext)
         throws NotFoundException;

   public abstract Response reverseRefund(RefundRequest body, SecurityContext securityContext) throws NotFoundException;
}
