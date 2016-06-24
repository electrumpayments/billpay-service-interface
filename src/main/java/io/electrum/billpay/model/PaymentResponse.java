package io.electrum.billpay.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Represents a response to a payment request
 **/
@ApiModel(description = "Represents a response to a payment request")
public class PaymentResponse extends LinkableResponse {

   private PaymentResponseDetail paymentResponseDetail = null;
   private SlipData slipData = null;

   /**
    * Response specific details
    **/
   public PaymentResponse responseDetail(PaymentResponseDetail paymentResponseDetail) {
      this.paymentResponseDetail = paymentResponseDetail;
      return this;
   }

   @ApiModelProperty(required = true, value = "Response specific details")
   @JsonProperty("paymentResponseDetail")
   @NotNull
   public PaymentResponseDetail getPaymentResponseDetail() {
      return paymentResponseDetail;
   }

   public void setPaymentResponseDetail(PaymentResponseDetail paymentResponseDetail) {
      this.paymentResponseDetail = paymentResponseDetail;
   }

   /**
    * Data that should be printed on the customer receipt
    **/
   public PaymentResponse slipData(SlipData slipData) {
      this.slipData = slipData;
      return this;
   }

   @ApiModelProperty(required = true, value = "Data that should be printed on the customer receipt")
   @JsonProperty("slipData")
   @NotNull
   public SlipData getSlipData() {
      return slipData;
   }

   public void setSlipData(SlipData slipData) {
      this.slipData = slipData;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      PaymentResponse paymentResponse = (PaymentResponse) o;
      return Objects.equals(id, paymentResponse.id) && Objects.equals(account, paymentResponse.account)
            && Objects.equals(customer, paymentResponse.customer) && Objects.equals(linkData, paymentResponse.linkData)
            && Objects.equals(processor, paymentResponse.processor)
            && Objects.equals(receiver, paymentResponse.receiver)
            && Objects.equals(paymentResponseDetail, paymentResponse.paymentResponseDetail)
            && Objects.equals(slipData, paymentResponse.slipData);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, account, customer, linkData, processor, receiver, paymentResponseDetail, slipData);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class PaymentResponse {\n");

      sb.append("    id: ").append(toIndentedString(id)).append("\n");
      sb.append("    account: ").append(toIndentedString(account)).append("\n");
      sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
      sb.append("    linkData: ").append(toIndentedString(linkData)).append("\n");
      sb.append("    processor: ").append(toIndentedString(processor)).append("\n");
      sb.append("    receiver: ").append(toIndentedString(receiver)).append("\n");
      sb.append("    paymentResponseDetail: ").append(toIndentedString(paymentResponseDetail)).append("\n");
      sb.append("    slipData: ").append(toIndentedString(slipData)).append("\n");
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
