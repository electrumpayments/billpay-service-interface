package io.electrum.billpay.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Represents a request to perform a payment
 **/
@ApiModel(description = "Represents a request to perform a payment")
public class PaymentRequest extends BasicRequest {

   private String accountRef = null;
   private PaymentRequestDetail paymentRequestDetail = null;

   /**
    * A reference number identifying the bill payments processor, bill issuer, and customer
    **/
   public PaymentRequest accountRef(String accountRef) {
      this.accountRef = accountRef;
      return this;
   }

   @ApiModelProperty(required = true, value = "A reference number identifying the bill payments processor, bill issuer, and customer")
   @JsonProperty("accountRef")
   @NotNull
   @Length(min = 6, max = 40)
   public String getAccountRef() {
      return accountRef;
   }

   public void setAccountRef(String accountRef) {
      this.accountRef = accountRef;
   }

   /**
    * Request specific details
    **/
   public PaymentRequest paymentRequestDetail(PaymentRequestDetail paymentRequestDetail) {
      this.paymentRequestDetail = paymentRequestDetail;
      return this;
   }

   @ApiModelProperty(required = true, value = "Request specific details")
   @JsonProperty("paymentRequestDetail")
   @NotNull
   public PaymentRequestDetail getPaymentRequestDetail() {
      return paymentRequestDetail;
   }

   public void setPaymentRequestDetail(PaymentRequestDetail paymentRequestDetail) {
      this.paymentRequestDetail = paymentRequestDetail;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      PaymentRequest paymentRequest = (PaymentRequest) o;
      return Objects.equals(accountRef, paymentRequest.accountRef)
            && Objects.equals(messageId, paymentRequest.messageId) && Objects.equals(merchant, paymentRequest.merchant)
            && Objects.equals(paymentRequestDetail, paymentRequest.paymentRequestDetail);
   }

   @Override
   public int hashCode() {
      return Objects.hash(accountRef, messageId, merchant, paymentRequestDetail);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class PaymentRequest {\n");

      sb.append("    accountRef: ").append(toIndentedString(accountRef)).append("\n");
      sb.append("    messageId: ").append(toIndentedString(messageId)).append("\n");
      sb.append("    merchant: ").append(toIndentedString(merchant)).append("\n");
      sb.append("    paymentRequestDetail: ").append(toIndentedString(paymentRequestDetail)).append("\n");
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
