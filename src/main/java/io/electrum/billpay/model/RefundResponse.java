package io.electrum.billpay.model;

import io.swagger.annotations.ApiModel;

/**
 * Represents a response to a refund request
 **/
@ApiModel(description = "Represents a response to a refund request")
public class RefundResponse extends LinkableResponse {

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class RefundResponse {\n");

      sb.append("    id: ").append(toIndentedString(id)).append("\n");
      sb.append("    account: ").append(toIndentedString(account)).append("\n");
      sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
      sb.append("    linkData: ").append(toIndentedString(linkData)).append("\n");
      sb.append("    processor: ").append(toIndentedString(processor)).append("\n");
      sb.append("    receiver: ").append(toIndentedString(receiver)).append("\n");
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
