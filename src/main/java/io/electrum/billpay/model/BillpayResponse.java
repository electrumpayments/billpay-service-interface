package io.electrum.billpay.model;

import io.electrum.vas.model.Amounts;
import io.electrum.vas.model.SlipData;
import io.electrum.vas.model.Transaction;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public abstract class BillpayResponse extends Transaction {
   protected Customer customer = null;
   protected Amounts amounts = null;
   protected BillSlipData slipData = null;
   protected boolean partPaymentAllowed = true;
   protected boolean overPaymentAllowed = true;

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

   /**
    * Data that should be printed on the customer receipt
    **/
   @Override
   public BillpayResponse slipData(SlipData slipData) {
      return slipData((BillSlipData) slipData);
   }

   /**
    * Data that should be printed on the customer receipt
    **/
   public BillpayResponse slipData(BillSlipData slipData) {
      this.slipData = slipData;
      return this;
   }

   @ApiModelProperty(required = true, value = "Data that should be printed on the customer receipt")
   @JsonProperty("slipData")
   @NotNull
   public BillSlipData getSlipData() {
      return slipData;
   }

   public void setSlipData(BillSlipData slipData) {
      this.slipData = slipData;
   }

   /**
    * Indicates whether a payment amount may be less than the amount due. Defaults to true.
    **/
   public BillpayResponse partPaymentAllowed (boolean partPaymentAllowed) {
      this.partPaymentAllowed = partPaymentAllowed;
      return this;
   }

   @ApiModelProperty(value = "Indicates whether a payment amount may be less than the amount due. Defaults to true.")
   @JsonProperty("partPaymentAllowed")
   public boolean getPartPaymentAllowed() {
      return partPaymentAllowed;
   }

   public void setPartPaymentAllowed(boolean partPaymentAllowed) {
      this.partPaymentAllowed = partPaymentAllowed;
   }

   /**
    * Indicates whether a payment amount may be more than the amount due. Defaults to true.
    **/
   public BillpayResponse overPaymentAllowed (boolean overPaymentAllowed) {
      this.overPaymentAllowed = overPaymentAllowed;
      return this;
   }

   @ApiModelProperty(value = "Indicates whether a payment amount may be more than the amount due. Defaults to true.")
   @JsonProperty("overPaymentAllowed")
   public boolean getOverPaymentAllowed() {
      return overPaymentAllowed;
   }

   public void setOverPaymentAllowed(boolean overPaymentAllowed) {
      this.overPaymentAllowed = overPaymentAllowed;
   }
}
