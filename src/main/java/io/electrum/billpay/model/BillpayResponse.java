package io.electrum.billpay.model;

import java.io.IOException;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.JsonUtil;
import io.electrum.vas.model.Amounts;
import io.electrum.vas.model.SlipData;
import io.electrum.vas.model.Transaction;
import io.swagger.annotations.ApiModelProperty;

public abstract class BillpayResponse extends Transaction {
   protected Customer customer = null;
   protected BillpayAmounts amounts = null;
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
   @Valid
   public Customer getCustomer() {
      return customer;
   }

   public void setCustomer(Customer customer) {
      this.customer = customer;
   }

   /**
    * The message amount details such as account balance.
    * 
    * @since v4.8.0
    **/
   public BillpayResponse amounts(BillpayAmounts amounts) {
      this.amounts = amounts;
      return this;
   }

   /**
    * The message amount details such as account balance.
    * 
    * @deprecated - Use {@link #amounts(BillpayAmounts)} instead.
    **/
   @Deprecated
   @JsonIgnore
   @ApiModelProperty(name = "amounts", access = "overloaded-method")
   public BillpayResponse amounts(Amounts amounts) {
      try {
         this.amounts = JsonUtil.deserialize(JsonUtil.serialize(amounts, Amounts.class), BillpayAmounts.class);
         return this;
      } catch (IOException ioe) {
         throw new RuntimeException(ioe);
      }
   }

   @ApiModelProperty(required = true, value = "The message amount details such as account balance.", dataType = "io.electrum.billpay.model.BillpayAmounts")
   @JsonProperty("amounts")
   @NotNull
   @Valid
   public <T extends Amounts> T getAmounts() {
      return (T) amounts;
   }

   /**
    * @since v4.8.0
    * @param amounts
    */
   public void setAmounts(BillpayAmounts amounts) {
      this.amounts = amounts;
   }

   /**
    * 
    * @param amounts
    * @deprecated - Use {@link #setAmounts(BillpayAmounts)} instead.
    */
   @Deprecated
   @JsonIgnore
   @ApiModelProperty(name = "amounts", access = "overloaded-method")
   public void setAmounts(Amounts amounts) {
      try {
         this.amounts = JsonUtil.deserialize(JsonUtil.serialize(amounts, Amounts.class), BillpayAmounts.class);
      } catch (IOException ioe) {
         throw new RuntimeException(ioe);
      }
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
   @Valid
   public BillSlipData getSlipData() {
      return slipData;
   }

   public void setSlipData(BillSlipData slipData) {
      this.slipData = slipData;
   }

   /**
    * Indicates whether a payment amount may be less than the amount due. Defaults to true.
    **/
   public BillpayResponse partPaymentAllowed(boolean partPaymentAllowed) {
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
   public BillpayResponse overPaymentAllowed(boolean overPaymentAllowed) {
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
