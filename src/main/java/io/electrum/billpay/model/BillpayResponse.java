package io.electrum.billpay.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.electrum.vas.model.BasicResponse;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public abstract class BillpayResponse extends BasicResponse {
   protected Account account = null;
   protected Customer customer = null;

   /**
    * The customer account detail
    **/
   public BillpayResponse account(Account account) {
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
   public BillpayResponse customer(Customer customer) {
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
}
