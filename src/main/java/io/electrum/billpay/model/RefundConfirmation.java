package io.electrum.billpay.model;

import io.swagger.annotations.ApiModel;

import java.util.Objects;

/**
 * Represents the data required to confirm a previously created refund
 **/
@ApiModel(description = "Represents the data required to confirm a previously created refund")
public class RefundConfirmation extends BasicAdvice {

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      RefundConfirmation refundConfirmation = (RefundConfirmation) o;
      return Objects.equals(linkData, refundConfirmation.linkData)
            && Objects.equals(messageId, refundConfirmation.messageId);
   }

   @Override
   public int hashCode() {
      return Objects.hash(linkData, messageId);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class RefundConfirmation {\n");

      sb.append("    linkData: ").append(toIndentedString(linkData)).append("\n");
      sb.append("    messageId: ").append(toIndentedString(messageId)).append("\n");
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
