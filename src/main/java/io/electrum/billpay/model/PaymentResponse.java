package io.electrum.billpay.model;

import io.electrum.vas.Utils;
import io.electrum.vas.model.LedgerAmount;
import io.electrum.vas.model.ThirdPartyIdentifier;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Represents a response to a payment request
 **/
@ApiModel(description = "Represents a response to a payment request")
public class PaymentResponse extends BillpayResponse {

   private SlipData slipData = null;
   private LedgerAmount responseAmount = null;

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

      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    time: ").append(Utils.toIndentedString(time)).append("\n");
      sb.append("    originator: ").append(Utils.toIndentedString(originator)).append("\n");
      sb.append("    client: ").append(Utils.toIndentedString(client)).append("\n");
      sb.append("    settlementEntity: ").append(Utils.toIndentedString(settlementEntity)).append("\n");
      sb.append("    receiver: ").append(Utils.toIndentedString(receiver)).append("\n");
      sb.append("    slipData: ").append(Utils.toIndentedString(slipData)).append("\n");
      sb.append("    responseAmount: ").append(Utils.toIndentedString(responseAmount)).append("\n");
      sb.append("    transactionIdentifiers: [");
      for(ThirdPartyIdentifier thirdPartyIdentifier : thirdPartyIdentifiers)
      {
         sb.append(Utils.toIndentedString("\n    ")).append(Utils.toIndentedString(thirdPartyIdentifier));
      }
      sb.append("    ]\n");
      sb.append("}");
      return sb.toString();
   }
}
