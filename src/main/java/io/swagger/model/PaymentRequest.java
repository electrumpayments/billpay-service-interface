package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Represents a request to perform a payment
 **/

@ApiModel(description = "Represents a request to perform a payment")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-06-13T18:34:39.493Z")
public class PaymentRequest {

   private AccountRef accountRef = null;
   private MessageId messageId = null;
   private Merchant merchant = null;
   private RequestDetail requestDetail = null;

   /**
   **/
   public PaymentRequest accountRef(AccountRef accountRef) {
      this.accountRef = accountRef;
      return this;
   }

   @ApiModelProperty(required = true, value = "")
   @JsonProperty("accountRef")
   public AccountRef getAccountRef() {
      return accountRef;
   }

   public void setAccountRef(AccountRef accountRef) {
      this.accountRef = accountRef;
   }

   /**
   **/
   public PaymentRequest messageId(MessageId messageId) {
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
   public PaymentRequest merchant(Merchant merchant) {
      this.merchant = merchant;
      return this;
   }

   @ApiModelProperty(value = "")
   @JsonProperty("merchant")
   public Merchant getMerchant() {
      return merchant;
   }

   public void setMerchant(Merchant merchant) {
      this.merchant = merchant;
   }

   /**
   **/
   public PaymentRequest requestDetail(RequestDetail requestDetail) {
      this.requestDetail = requestDetail;
      return this;
   }

   @ApiModelProperty(required = true, value = "")
   @JsonProperty("requestDetail")
   public RequestDetail getRequestDetail() {
      return requestDetail;
   }

   public void setRequestDetail(RequestDetail requestDetail) {
      this.requestDetail = requestDetail;
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
            && Objects.equals(requestDetail, paymentRequest.requestDetail);
   }

   @Override
   public int hashCode() {
      return Objects.hash(accountRef, messageId, merchant, requestDetail);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class PaymentRequest {\n");

      sb.append("    accountRef: ").append(toIndentedString(accountRef)).append("\n");
      sb.append("    messageId: ").append(toIndentedString(messageId)).append("\n");
      sb.append("    merchant: ").append(toIndentedString(merchant)).append("\n");
      sb.append("    requestDetail: ").append(toIndentedString(requestDetail)).append("\n");
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
