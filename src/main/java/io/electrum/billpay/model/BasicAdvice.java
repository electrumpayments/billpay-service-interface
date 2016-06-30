package io.electrum.billpay.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * Represents the data required for all advice messages
 **/
public abstract class BasicAdvice {

   protected Object linkData = null;
   protected MessageId messageId = null;

   /**
    * The unaltered linkData object as supplied in the createPayment response. Required if the createPayment response
    * contained linkData
    **/
   public BasicAdvice linkData(Object linkData) {
      this.linkData = linkData;
      return this;
   }

   @ApiModelProperty(value = "The unaltered linkData object as supplied in the createPayment response. Required if the createPayment response contained linkData")
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
   public BasicAdvice messageId(MessageId messageId) {
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
}
