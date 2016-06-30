package io.electrum.billpay.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Objects;

/**
 * Payment request specific data
 **/
@ApiModel(description = "Payment request specific data")
public class PaymentRequestDetail {

   private String clientRef = null;
   private LedgerAmount requestAmount = null;

   /**
    * A reference number useful to the client for identifying transactions, also knows as a retrieval reference number
    **/
   public PaymentRequestDetail clientRef(String clientRef) {
      this.clientRef = clientRef;
      return this;
   }

   @ApiModelProperty(value = "A reference number useful to the client for identifying transactions, also knows as a retrieval reference number")
   @JsonProperty("clientRef")
   @Pattern(regexp = "[A-Za-z0-9 ]{0,12}")
   public String getClientRef() {
      return clientRef;
   }

   public void setClientRef(String clientRef) {
      this.clientRef = clientRef;
   }

   /**
    * The requested amount
    **/
   public PaymentRequestDetail requestAmount(LedgerAmount requestAmount) {
      this.requestAmount = requestAmount;
      return this;
   }

   @ApiModelProperty(required = true)
   @JsonProperty("requestAmount")
   @NotNull
   public LedgerAmount getRequestAmount() {
      return requestAmount;
   }

   public void setRequestAmount(LedgerAmount requestAmount) {
      this.requestAmount = requestAmount;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      PaymentRequestDetail paymentRequestDetail = (PaymentRequestDetail) o;
      return Objects.equals(clientRef, paymentRequestDetail.clientRef)
            && Objects.equals(requestAmount, paymentRequestDetail.requestAmount);
   }

   @Override
   public int hashCode() {
      return Objects.hash(clientRef, requestAmount);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class PaymentRequestDetail {\n");

      sb.append("    clientRef: ").append(toIndentedString(clientRef)).append("\n");
      sb.append("    requestAmount: ").append(toIndentedString(requestAmount)).append("\n");
      sb.append("}");
      return sb.toString();
   }

   /**
    * Convert the given object to string with each line indented by 4 spaces (except the first line).
    */
   private String toIndentedString(Object o) {
      if (o == null) {
         return "null";
      }
      return o.toString().replace("\n", "\n    ");
   }
}
