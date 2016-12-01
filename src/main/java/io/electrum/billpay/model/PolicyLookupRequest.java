package io.electrum.billpay.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.electrum.vas.model.Transaction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The data required to request policy info
 **/
@ApiModel(description = "The data required to request policy info")
public class PolicyLookupRequest extends Transaction {

   private String policyNumber = null;

   /**
    * A reference number identifying the policy to the service provider.
    **/
   public PolicyLookupRequest policyNumber(String policyNumber) {
      this.policyNumber = policyNumber;
      return this;
   }

   @ApiModelProperty(required = true, value = "A reference number identifying the policy to the service provider.")
   @JsonProperty("policyNumber")
   @NotNull
   @Length(min = 6, max = 40)
   public String getPolicyNumber() {
      return policyNumber;
   }

   public void setPolicyNumber(String policyNumber) {
      this.policyNumber = policyNumber;
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class PolicyLookupRequest {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    policyNumber: ").append(Utils.toIndentedString(policyNumber)).append("\n");
      sb.append("    time: ").append(Utils.toIndentedString(time)).append("\n");
      sb.append("    originator: ").append(Utils.toIndentedString(originator)).append("\n");
      sb.append("    client: ").append(Utils.toIndentedString(client)).append("\n");
      sb.append("    settlementEntity: ").append(Utils.toIndentedString(settlementEntity)).append("\n");
      sb.append("    receiver: ").append(Utils.toIndentedString(receiver)).append("\n");
      sb.append("    thirdPartyIdentifiers: ").append(Utils.toIndentedString(thirdPartyIdentifiers)).append("\n");
      sb.append("    slipData: ").append(Utils.toIndentedString(slipData)).append("\n");
      sb.append("    basketRef: ").append(Utils.toIndentedString(basketRef)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
