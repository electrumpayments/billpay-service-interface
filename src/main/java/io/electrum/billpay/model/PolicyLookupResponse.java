package io.electrum.billpay.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The data resulting from a policy lookup request
 **/
@ApiModel(description = "The data resulting from a policy lookup request")
public class PolicyLookupResponse extends BillpayResponse {
   protected Policy policy = null;

   /**
    * The customer policy detail
    **/
   public BillpayResponse policy(Policy policy) {
      this.policy = policy;
      return this;
   }

   @ApiModelProperty(required = true, value = "The customer policy detail")
   @JsonProperty("policy")
   @NotNull
   public Policy getPolicy() {
      return policy;
   }

   public void setPolicy(Policy policy) {
      this.policy = policy;
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class PolicyLookupResponse {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    time: ").append(Utils.toIndentedString(time)).append("\n");
      sb.append("    originator: ").append(Utils.toIndentedString(originator)).append("\n");
      sb.append("    client: ").append(Utils.toIndentedString(client)).append("\n");
      sb.append("    settlementEntity: ").append(Utils.toIndentedString(settlementEntity)).append("\n");
      sb.append("    receiver: ").append(Utils.toIndentedString(receiver)).append("\n");
      sb.append("    slipData: ").append(Utils.toIndentedString(slipData)).append("\n");
      sb.append("    amounts: ").append(Utils.toIndentedString(amounts)).append("\n");
      sb.append("    customer: ").append(Utils.toIndentedString(customer)).append("\n");
      sb.append("    policy: ").append(Utils.toIndentedString(policy)).append("\n");
      sb.append("    thirdPartyIdentifiers: ").append(Utils.toIndentedString(thirdPartyIdentifiers)).append("\n");
      sb.append("    basketRef: ").append(Utils.toIndentedString(basketRef)).append("\n");
      sb.append("    partPaymentAllowed: ").append(Utils.toIndentedString(partPaymentAllowed)).append("\n");
      sb.append("    overPaymentAllowed: ").append(Utils.toIndentedString(overPaymentAllowed)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
