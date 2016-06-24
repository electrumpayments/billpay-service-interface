package io.electrum.billpay.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * The data resulting from all requests
 **/
public abstract class BasicResponse {

   protected Account account = null;
   protected Customer customer = null;
   protected Institution processor = null;
   protected Institution receiver = null;

   /**
    * The customer account detail
    **/
   public BasicResponse account(Account account) {
      this.account = account;
      return this;
   }

   @ApiModelProperty(required = true, value = "The customer account detail")
   @JsonProperty("account")
   @NotNull
   public Account getAccount() {
      return account;
   }

   public void setAccount(Account account) {
      this.account = account;
   }

   /**
    * Customer detail
    **/
   public BasicResponse customer(Customer customer) {
      this.customer = customer;
      return this;
   }

   @ApiModelProperty(value = "Customer detail")
   @JsonProperty("customer")
   public Customer getCustomer() {
      return customer;
   }

   public void setCustomer(Customer customer) {
      this.customer = customer;
   }

   /**
    * Detail regarding the institution that processed the message
    **/
   public BasicResponse processor(Institution processor) {
      this.processor = processor;
      return this;
   }

   @ApiModelProperty(value = "Detail regarding the institution that processed the message")
   @JsonProperty("processor")
   public Institution getProcessor() {
      return processor;
   }

   public void setProcessor(Institution processor) {
      this.processor = processor;
   }

   /**
    * Detail regarding the bill issuing institution
    **/
   public BasicResponse receiver(Institution receiver) {
      this.receiver = receiver;
      return this;
   }

   @ApiModelProperty(required = true, value = "Detail regarding the bill issuing institution")
   @JsonProperty("receiver")
   @NotNull
   public Institution getReceiver() {
      return receiver;
   }

   public void setReceiver(Institution receiver) {
      this.receiver = receiver;
   }
}
