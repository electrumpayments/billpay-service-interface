package io.electrum.billpay.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * The data resulting from an account lookup request
 **/
@ApiModel(description = "The data resulting from an account lookup request")
public class AccountLookupResponse extends BasicResponse {

   private SlipData slipData = null;

   /**
    * Data that should be printed on the customer receipt
    **/
   public AccountLookupResponse slipData(SlipData slipData) {
      this.slipData = slipData;
      return this;
   }

   @ApiModelProperty(value = "Data that should be printed on the customer receipt")
   @JsonProperty("slipData")
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
      AccountLookupResponse accountLookupResponse = (AccountLookupResponse) o;
      return Objects.equals(account, accountLookupResponse.account)
            && Objects.equals(customer, accountLookupResponse.customer)
            && Objects.equals(processor, accountLookupResponse.processor)
            && Objects.equals(receiver, accountLookupResponse.receiver)
            && Objects.equals(slipData, accountLookupResponse.slipData);
   }

   @Override
   public int hashCode() {
      return Objects.hash(account, customer, processor, receiver, slipData);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class AccountLookupResponse {\n");

      sb.append("    account: ").append(toIndentedString(account)).append("\n");
      sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
      sb.append("    processor: ").append(toIndentedString(processor)).append("\n");
      sb.append("    receiver: ").append(toIndentedString(receiver)).append("\n");
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
