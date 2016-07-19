package io.electrum.billpay.model;

import io.electrum.vas.Utils;

import io.swagger.annotations.ApiModel;

/**
 * Represents a response to a payment request
 **/
@ApiModel(description = "Represents a response to a payment request")
public class RefundResponse extends BillpayResponse {

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class RefundResponse {\n");

      sb.append("    linkData: ").append(Utils.toIndentedString(linkData)).append("\n");
      sb.append("    account: ").append(Utils.toIndentedString(account)).append("\n");
      sb.append("    customer: ").append(Utils.toIndentedString(customer)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
