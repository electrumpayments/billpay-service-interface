package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * The data required to request account info
 **/

@ApiModel(description = "The data required to request account info")
public class AccountLookupRequest {

   private String accountRef = null;
   private MessageId messageId = null;
   private Merchant merchant = null;

   /**
    * A reference number identifying the bill payments processor, bill issuer, and customer
    **/
   public AccountLookupRequest accountRef(String accountRef) {
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
    * The data required to uniquely identify a message
    **/
   public AccountLookupRequest messageId(MessageId messageId) {
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

   /**
    * Merchant data. Required if available
    **/
   public AccountLookupRequest merchant(Merchant merchant) {
      this.merchant = merchant;
      return this;
   }

   @ApiModelProperty(value = "Merchant data. Required if available")
   @JsonProperty("merchant")
   public Merchant getMerchant() {
      return merchant;
   }

   public void setMerchant(Merchant merchant) {
      this.merchant = merchant;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      AccountLookupRequest accountLookupRequest = (AccountLookupRequest) o;
      return Objects.equals(accountRef, accountLookupRequest.accountRef)
            && Objects.equals(messageId, accountLookupRequest.messageId)
            && Objects.equals(merchant, accountLookupRequest.merchant);
   }

   @Override
   public int hashCode() {
      return Objects.hash(accountRef, messageId, merchant);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class AccountLookupRequest {\n");

      sb.append("    accountRef: ").append(toIndentedString(accountRef)).append("\n");
      sb.append("    messageId: ").append(toIndentedString(messageId)).append("\n");
      sb.append("    merchant: ").append(toIndentedString(merchant)).append("\n");
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
