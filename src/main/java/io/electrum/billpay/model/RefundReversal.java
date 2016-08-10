package io.electrum.billpay.model;

import io.electrum.vas.Utils;
import io.electrum.vas.model.BasicReversal;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class RefundReversal extends BasicReversal {

   private RefundRequest refundRequest = null;

   /**
    * The RefundReversal object previously present in a createRefund operation for which no response was received
    */
   public RefundReversal issuerReference(RefundRequest refundRequest) {
      this.refundRequest = refundRequest;
      return this;
   }

   @ApiModelProperty(required = true, value = "The RefundRequest object previously present in a createRefund operation for which no response was received")
   @JsonProperty("refundRequest")
   @NotNull
   public RefundRequest getRefundRequest() {
      return refundRequest;
   }

   public void setRefundRequest(RefundRequest paymentRequest) {
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
