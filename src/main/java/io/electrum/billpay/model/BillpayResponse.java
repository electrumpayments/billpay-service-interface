package io.electrum.billpay.model;

import java.io.IOException;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.JsonUtil;
import io.electrum.vas.model.Amounts;
import io.electrum.vas.model.SlipData;
import io.electrum.vas.model.Transaction;
import io.swagger.annotations.ApiModelProperty;

public abstract class BillpayResponse extends Transaction {

   @ApiModelProperty(value = "Customer detail")
   @JsonProperty("customer")
   @Valid
   protected Customer customer = null;

   @ApiModelProperty(required = true, value = "The message amount details such as account balance.", dataType = "io.electrum.billpay.model.BillpayAmounts")
   @JsonProperty("amounts")
   @NotNull
   @Valid
   protected BillpayAmounts amounts = null;

   @ApiModelProperty(required = true, value = "Data that should be printed on the customer receipt")
   @JsonProperty("slipData")
   @NotNull
   @Valid
   protected BillSlipData slipData = null;

   @ApiModelProperty(value = "Indicates whether a payment amount may be less than the amount due. Defaults to false.")
   protected boolean partPaymentAllowed = false;

   @ApiModelProperty(value = "Indicates whether a payment amount may be less than the amount due. Replaces old primitive value to allow for null when not provided.")
   @JsonProperty("partPaymentAllowed")
   @JsonAlias("partPayment")
   protected Boolean partPayment = null;

   @ApiModelProperty(value = "Indicates whether a payment amount may be more than the amount due. Defaults to false.")
   protected boolean overPaymentAllowed = false;

   @ApiModelProperty(value = "Indicates whether a payment amount may be more than the amount due. Replaces old primitive value to allow for null when not provided.")
   @JsonProperty("overPaymentAllowed")
   @JsonAlias("overPayment")
   protected Boolean overPayment = null;

   /**
    * Customer detail
    **/
   public BillpayResponse customer(Customer customer) {
      this.customer = customer;
      return this;
   }

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
   @ApiModelProperty(access = "overloaded-method")
   public BillpayResponse amounts(Amounts amounts) {
      try {
         this.amounts = JsonUtil.deserialize(JsonUtil.serialize(amounts, Amounts.class), BillpayAmounts.class);
         return this;
      } catch (IOException ioe) {
         throw new RuntimeException(ioe);
      }
   }

   public <T extends Amounts> T getAmounts() {
      return (T) amounts;
   }

   /**
    * @param amounts
    * @since v4.8.0
    */
   public void setAmounts(BillpayAmounts amounts) {
      this.amounts = amounts;
   }

   /**
    * @param amounts
    * @deprecated - Use {@link #setAmounts(BillpayAmounts)} instead.
    */
   @Deprecated
   @JsonIgnore
   @ApiModelProperty(access = "overloaded-method")
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

   public BillSlipData getSlipData() {
      return slipData;
   }

   public void setSlipData(BillSlipData slipData) {
      this.slipData = slipData;
   }

   /**
    * Indicates whether a payment amount may be less than the amount due. Sets both the primitive value as well as the
    * boxed value
    **/
   public BillpayResponse partPaymentAllowed(boolean partPaymentAllowed) {
      this.partPaymentAllowed = partPaymentAllowed;
      this.partPayment = partPaymentAllowed;
      return this;
   }

   /**
    * Returns partPayment if not null otherwise returns partPaymentAllowed (which defaults to false).
    * 
    * @return A boolean value. Defaults to false if nothing is set.
    * @deprecated since version 4.8.2. Replaced by {@link #getPartPayment()}
    */
   @JsonIgnore
   @Deprecated
   public boolean getPartPaymentAllowed() {
      if (partPayment == null) {
         return partPaymentAllowed;
      }
      return partPayment;
   }

   /**
    * Method to replace old {@link #getPartPaymentAllowed()} to return an optional which will be empty if partPayment is
    * never set otherwise returns partPayment
    * 
    * @return Optional.empty() if partPayment is not set otherwise partPayment
    * @since 4.8.2
    */
   public Optional<Boolean> getPartPayment() {
      return Optional.ofNullable(partPayment);
   }

   /**
    * Sets both the primitive variable partPaymentAllowed as well as the boxed variable partPayment
    * 
    * @param partPaymentAllowed
    *           Indicates whether part payments are allowed
    */

   public void setPartPaymentAllowed(boolean partPaymentAllowed) {
      this.partPaymentAllowed = partPaymentAllowed;
      this.partPayment = partPaymentAllowed;
   }

   /**
    * Indicates whether a payment amount may be more than the amount due. Sets both the primitive value as well as the
    * boxed value
    **/
   public BillpayResponse overPaymentAllowed(boolean overPaymentAllowed) {
      this.overPaymentAllowed = overPaymentAllowed;
      this.overPayment = overPaymentAllowed;
      return this;
   }

   /**
    * Returns overPayment if not null otherwise returns overPaymentAllowed (which defaults to false).
    *
    * @return A boolean value. Defaults to false if nothing is set.
    * @deprecated since version 4.8.2. Replaced by {@link #getOverPayment()}
    */
   @JsonIgnore
   @Deprecated
   public boolean getOverPaymentAllowed() {
      if (overPayment == null) {
         return overPaymentAllowed;
      }
      return overPayment;
   }

   /**
    * Method to replace old {@link #getOverPaymentAllowed()} to return an optional which will be empty if overPayment is
    * never set otherwise returns overPayment
    *
    * @return Optional.empty() if overPayment is not set otherwise overPayment
    * @since 4.8.2
    */
   public Optional<Boolean> getOverPayment() {
      return Optional.ofNullable(overPayment);
   }

   /**
    * Sets both the primitive variable overPaymentAllowed as well as the boxed variable overPayment
    *
    * @param overPaymentAllowed
    *           Indicates whether over payments are allowed
    */
   public void setOverPaymentAllowed(boolean overPaymentAllowed) {
      this.overPaymentAllowed = overPaymentAllowed;
      this.overPayment = overPaymentAllowed;
   }
}
