package io.electrum.billpay.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.electrum.vas.Utils;
import io.electrum.vas.model.BasicReversal;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class RefundReversal extends BasicReversal {

   private RefundRequest refundRequest = null;

   /**
    * The PaymentRequest object previously present in a createPayment operation for which no response was received
    */
   public RefundReversal issuerReference(RefundRequest refundRequest) {
      this.refundRequest = refundRequest;
      return this;
   }

   @ApiModelProperty(required = true, value = "The PaymentRequest object previously present in a createPayment operation for which no response was received")
   @JsonProperty("paymentRequest")
   @NotNull
   public RefundRequest getPaymentRequest() {
      return refundRequest;
   }

   public void setPaymentRequest(RefundRequest paymentRequest) {
      this.refundRequest = paymentRequest;
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class RefundReversal {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    requestId: ").append(Utils.toIndentedString(requestId)).append("\n");
      sb.append("    time: ").append(Utils.toIndentedString(time)).append("\n");
      sb.append("    reversalReason: ").append(Utils.toIndentedString(reversalReason)).append("\n");
      sb.append("    refundRequest: ").append(Utils.toIndentedString(refundRequest)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
