package io.electrum.billpay.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.electrum.vas.Utils;
import io.electrum.vas.model.BasicReversal;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class PaymentReversal extends BasicReversal {

   private PaymentRequest paymentRequest = null;

   /**
    * The PaymentRequest object previously present in a createPaymentImpl operation for which no response was received
    */
   public PaymentReversal issuerReference(PaymentRequest paymentRequest) {
      this.paymentRequest = paymentRequest;
      return this;
   }

   @ApiModelProperty(required = true, value = "The PaymentRequest object previously present in a createPaymentImpl operation for which no response was received")
   @JsonProperty("paymentRequest")
   @NotNull
   public PaymentRequest getPaymentRequest() {
      return paymentRequest;
   }

   public void setPaymentRequest(PaymentRequest paymentRequest) {
      this.paymentRequest = paymentRequest;
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class PaymentReversal {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    requestId: ").append(Utils.toIndentedString(requestId)).append("\n");
      sb.append("    time: ").append(Utils.toIndentedString(time)).append("\n");
      sb.append("    reversalReason: ").append(Utils.toIndentedString(reversalReason)).append("\n");
      sb.append("    paymentRequest: ").append(Utils.toIndentedString(paymentRequest)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
