package io.electrum.billpay.model;

import io.swagger.annotations.ApiModel;

import java.util.Objects;

/**
 * Represents the data required to cancel a previously created payment
 **/
@ApiModel(description = "Represents the data required to cancel a previously created payment")
public class Cancellation extends BasicAdvice {

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      Cancellation cancellation = (Cancellation) o;
      return Objects.equals(linkData, cancellation.linkData) && Objects.equals(messageId, cancellation.messageId);
   }

   @Override
   public int hashCode() {
      return Objects.hash(linkData, messageId);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class Cancellation {\n");

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
