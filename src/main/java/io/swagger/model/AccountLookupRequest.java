package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * The data required to request account info
 **/

@ApiModel(description = "The data required to request account info")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-06-13T18:34:39.493Z")
public class AccountLookupRequest {

   private AccountRef accountRef = null;
   private MessageId messageId = null;
   private Merchant merchant = null;

   /**
   **/
   public AccountLookupRequest accountRef(AccountRef accountRef) {
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
   public AccountLookupRequest messageId(MessageId messageId) {
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
   public AccountLookupRequest merchant(Merchant merchant) {
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
