package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Represents the data required to confirm a previously created refund
 **/
@ApiModel(description = "Represents the data required to confirm a previously created refund")
public class RefundConfirmation {

   private Object linkData = null;
   private MessageId messageId = null;

   /**
    * The unaltered linkData object as supplied in the createRefund response. Required if the createRefund response
    * contained linkData
    **/
   public RefundConfirmation linkData(Object linkData) {
      this.linkData = linkData;
      return this;
   }

   @ApiModelProperty(value = "The unaltered linkData object as supplied in the createRefund response. Required if the createRefund response contained linkData")
   @JsonProperty("linkData")
   public Object getLinkData() {
      return linkData;
   }

   public void setLinkData(Object linkData) {
      this.linkData = linkData;
   }

   /**
    * The data required to uniquely identify a message
    **/
   public RefundConfirmation messageId(MessageId messageId) {
      this.messageId = messageId;
      return this;
   }

   @ApiModelProperty(required = true, value = "The data required to uniquely identify a message")
   @JsonProperty("messageId")
   @NotNull
   public MessageId getMessageId() {
      return messageId;
   }

   public void setMessageId(MessageId messageId) {
      this.messageId = messageId;
   }

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
