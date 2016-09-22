package io.electrum.billpay.model;

import io.electrum.vas.model.Amounts;
import io.electrum.vas.model.Transaction;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public abstract class BillpayResponse extends Transaction {
   protected Account account = null;
   protected Customer customer = null;
   protected Amounts amounts = null;

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

   /**
    * The message amount details such as account balance.
    **/
   public BillpayResponse amounts(Amounts amounts) {
      this.amounts = amounts;
      return this;
   }

   @ApiModelProperty(required = true, value = "The message amount details such as account balance.")
   @JsonProperty("amounts")
   @NotNull
   public Amounts getAmounts() {
      return amounts;
   }

   public void setAmounts(Amounts amounts) {
      this.amounts = amounts;
   }
}
