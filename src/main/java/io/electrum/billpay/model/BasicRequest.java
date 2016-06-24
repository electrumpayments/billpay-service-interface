package io.electrum.billpay.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * The data required in all requests
 **/
public abstract class BasicRequest {

   protected MessageId messageId = null;
   protected Merchant merchant = null;

   /**
    * The data required to uniquely identify a message
    **/
   public BasicRequest messageId(MessageId messageId) {
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
   public BasicRequest merchant(Merchant merchant) {
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
}
