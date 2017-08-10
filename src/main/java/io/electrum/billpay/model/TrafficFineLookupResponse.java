package io.electrum.billpay.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The data resulting from a traffic fine lookup request
 **/
@ApiModel(description = "The data resulting from a traffic fine lookup request")
public class TrafficFineLookupResponse extends BillpayResponse {
   protected TrafficFine trafficFine = null;

   /**
    * The traffic fine detail
    **/
   public BillpayResponse trafficFine(TrafficFine trafficFine) {
      this.trafficFine = trafficFine;
      return this;
   }

   @ApiModelProperty(required = true, value = "The traffic fine detail")
   @JsonProperty("trafficFine")
   @NotNull
   @Valid
   public TrafficFine getTrafficFine() {
      return trafficFine;
   }

   public void setTrafficFine(TrafficFine trafficFine) {
      this.trafficFine = trafficFine;
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class TrafficFineLookupResponse {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    time: ").append(Utils.toIndentedString(time)).append("\n");
      sb.append("    originator: ").append(Utils.toIndentedString(originator)).append("\n");
      sb.append("    client: ").append(Utils.toIndentedString(client)).append("\n");
      sb.append("    settlementEntity: ").append(Utils.toIndentedString(settlementEntity)).append("\n");
      sb.append("    receiver: ").append(Utils.toIndentedString(receiver)).append("\n");
      sb.append("    slipData: ").append(Utils.toIndentedString(slipData)).append("\n");
      sb.append("    amounts: ").append(Utils.toIndentedString(amounts)).append("\n");
      sb.append("    customer: ").append(Utils.toIndentedString(customer)).append("\n");
      sb.append("    trafficFine: ").append(Utils.toIndentedString(trafficFine)).append("\n");
      sb.append("    thirdPartyIdentifiers: ").append(Utils.toIndentedString(thirdPartyIdentifiers)).append("\n");
      sb.append("    basketRef: ").append(Utils.toIndentedString(basketRef)).append("\n");
      sb.append("    partPaymentAllowed: ").append(Utils.toIndentedString(partPaymentAllowed)).append("\n");
      sb.append("    overPaymentAllowed: ").append(Utils.toIndentedString(overPaymentAllowed)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
