package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Represents a request to refund a payment
 **/

@ApiModel(description = "Represents a request to refund a payment")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-06-13T18:34:39.493Z")
public class RefundRequest {

   private MessageId messageId = null;
   private IssuerReference issuerReference = null;
   private String refundReason = null;

   /**
   **/
   public RefundRequest messageId(MessageId messageId) {
      this.messageId = messageId;
      return this;
   }

   @ApiModelProperty(required = true, value = "")
   @JsonProperty("messageId")
   public MessageId getMessageId() {
      return messageId;
   }

   public void setMessageId(MessageId messageId) {
      this.messageId = messageId;
   }

   /**
   **/
   public RefundRequest issuerReference(IssuerReference issuerReference) {
      this.issuerReference = issuerReference;
      return this;
   }

   @ApiModelProperty(required = true, value = "")
   @JsonProperty("issuerReference")
   public IssuerReference getIssuerReference() {
      return issuerReference;
   }

   public void setIssuerReference(IssuerReference issuerReference) {
      this.issuerReference = issuerReference;
   }

   /**
    * The reason for the refund as given by the customer
    **/
   public RefundRequest refundReason(String refundReason) {
      this.refundReason = refundReason;
      return this;
   }

   @ApiModelProperty(required = true, value = "The reason for the refund as given by the customer")
   @JsonProperty("refundReason")
   public String getRefundReason() {
      return refundReason;
   }

   public void setRefundReason(String refundReason) {
      this.refundReason = refundReason;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      RefundRequest refundRequest = (RefundRequest) o;
      return Objects.equals(messageId, refundRequest.messageId)
            && Objects.equals(issuerReference, refundRequest.issuerReference)
            && Objects.equals(refundReason, refundRequest.refundReason);
   }

   @Override
   public int hashCode() {
      return Objects.hash(messageId, issuerReference, refundReason);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class RefundRequest {\n");

      sb.append("    messageId: ").append(toIndentedString(messageId)).append("\n");
      sb.append("    issuerReference: ").append(toIndentedString(issuerReference)).append("\n");
      sb.append("    refundReason: ").append(toIndentedString(refundReason)).append("\n");
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
