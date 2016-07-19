package io.electrum.billpay.model;

import io.electrum.vas.Utils;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The data resulting from an account lookup request
 **/
@ApiModel(description = "The data resulting from an account lookup request")
public class AccountLookupResponse extends BillpayResponse {

   private SlipData slipData = null;

   /**
    * Data that should be printed on the customer receipt
    **/
   public AccountLookupResponse slipData(SlipData slipData) {
      this.slipData = slipData;
      return this;
   }

   @ApiModelProperty(value = "Data that should be printed on the customer receipt")
   @JsonProperty("slipData")
   public SlipData getSlipData() {
      return slipData;
   }

   public void setSlipData(SlipData slipData) {
      this.slipData = slipData;
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class AccountLookupResponse {\n");

      sb.append("    linkData: ").append(Utils.toIndentedString(linkData)).append("\n");
      sb.append("    account: ").append(Utils.toIndentedString(account)).append("\n");
      sb.append("    customer: ").append(Utils.toIndentedString(customer)).append("\n");
      sb.append("    slipData: ").append(Utils.toIndentedString(slipData)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
