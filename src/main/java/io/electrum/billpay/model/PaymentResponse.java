package io.electrum.billpay.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.electrum.vas.Utils;
import io.electrum.vas.model.BasicResponse;
import io.electrum.vas.model.LedgerAmount;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * Represents a response to a payment request
 **/
@ApiModel(description = "Represents a response to a payment request")
public class PaymentResponse extends BasicResponse {

   private Account account = null;
   private Customer customer = null;
   private SlipData slipData = null;
   private LedgerAmount responseAmount = null;

   /**
    * The customer account detail
    **/
   public PaymentResponse account(Account account) {
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
   public PaymentResponse customer(Customer customer) {
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
    * Data that should be printed on the customer receipt
    **/
   public PaymentResponse slipData(SlipData slipData) {
      this.slipData = slipData;
      return this;
   }

   @ApiModelProperty(required = true, value = "Data that should be printed on the customer receipt")
   @JsonProperty("slipData")
   @NotNull
   public SlipData getSlipData() {
      return slipData;
   }

   public void setSlipData(SlipData slipData) {
      this.slipData = slipData;
   }

   /**
    * Response amount
    **/
   public PaymentResponse responseAmount(LedgerAmount responseAmount) {
      this.responseAmount = responseAmount;
      return this;
   }

   @ApiModelProperty(required = true, value = "Response amount")
   @JsonProperty("responseAmount")
   @NotNull
   public LedgerAmount getResponseAmount() {
      return responseAmount;
   }

   public void setResponseAmount(LedgerAmount responseAmount) {
      this.responseAmount = responseAmount;
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class PaymentResponse {\n");

      sb.append("    linkData: ").append(Utils.toIndentedString(linkData)).append("\n");
      sb.append("    account: ").append(Utils.toIndentedString(account)).append("\n");
      sb.append("    customer: ").append(Utils.toIndentedString(customer)).append("\n");
      sb.append("    slipData: ").append(Utils.toIndentedString(slipData)).append("\n");
      sb.append("    responseAmount: ").append(Utils.toIndentedString(responseAmount)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
