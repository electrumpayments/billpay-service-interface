package io.electrum.billpay.model;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;

/**
 * Represents a response to a payment request
 **/
@ApiModel(description = "Represents a response to a payment request")
public class PolicyPaymentResponse extends BillpayResponse {

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class PolicyPaymentResponse {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    time: ").append(Utils.toIndentedString(time)).append("\n");
      sb.append("    originator: ").append(Utils.toIndentedString(originator)).append("\n");
      sb.append("    client: ").append(Utils.toIndentedString(client)).append("\n");
      sb.append("    settlementEntity: ").append(Utils.toIndentedString(settlementEntity)).append("\n");
      sb.append("    receiver: ").append(Utils.toIndentedString(receiver)).append("\n");
      sb.append("    slipData: ").append(Utils.toIndentedString(slipData)).append("\n");
      sb.append("    amounts: ").append(Utils.toIndentedString(amounts)).append("\n");
      sb.append("    thirdPartyIdentifiers: ").append(Utils.toIndentedString(thirdPartyIdentifiers)).append("\n");
      sb.append("    slipData: ").append(Utils.toIndentedString(slipData)).append("\n");
      sb.append("    basketRef: ").append(Utils.toIndentedString(basketRef)).append("\n");
      sb.append("    partPaymentAllowed: ").append(Utils.toIndentedString(partPaymentAllowed)).append("\n");
      sb.append("    overPaymentAllowed: ").append(Utils.toIndentedString(overPaymentAllowed)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
