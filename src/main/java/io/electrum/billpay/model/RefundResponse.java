package io.electrum.billpay.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;

/**
 * Represents a response to a payment request
 **/
@ApiModel(description = "Represents a response to a refund request")
public class RefundResponse extends BillpayResponse {

   @ApiModelProperty(value = "The customer account detail")
   @JsonProperty("account")
   @Valid
   protected Account account = null;

   @ApiModelProperty(value = "The customer trafficFine detail")
   @JsonProperty("trafficFine")
   @Valid
   protected TrafficFine trafficFine = null;

   @ApiModelProperty(value = "The customer policy detail")
   @JsonProperty("policy")
   @Valid
   protected Policy policy = null;

   /**
    * The customer account detail
    **/
   public BillpayResponse account(Account account) {
      this.account = account;
      return this;
   }

   public Account getAccount() {
      return account;
   }

   public void setAccount(Account account) {
      this.account = account;
   }

   /**
    * The trafficFine detail
    **/
   public BillpayResponse trafficFine(TrafficFine trafficFine) {
      this.trafficFine = trafficFine;
      return this;
   }

   public TrafficFine getTrafficFine() {
      return trafficFine;
   }

   public void setTrafficFine(TrafficFine trafficFine) {
      this.trafficFine = trafficFine;
   }

   /**
    * The policy detail
    **/
   public BillpayResponse policy(Policy policy) {
      this.policy = policy;
      return this;
   }

   public Policy getPolicy() {
      return policy;
   }

   public void setPolicy(Policy policy) {
      this.policy = policy;
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class RefundResponse {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    time: ").append(Utils.toIndentedString(time)).append("\n");
      sb.append("    originator: ").append(Utils.toIndentedString(originator)).append("\n");
      sb.append("    client: ").append(Utils.toIndentedString(client)).append("\n");
      sb.append("    settlementEntity: ").append(Utils.toIndentedString(settlementEntity)).append("\n");
      sb.append("    receiver: ").append(Utils.toIndentedString(receiver)).append("\n");
      sb.append("    slipData: ").append(Utils.toIndentedString(slipData)).append("\n");
      sb.append("    amounts: ").append(Utils.toIndentedString(amounts)).append("\n");
      sb.append("    customer: ").append(Utils.toIndentedString(customer)).append("\n");
      sb.append("    account: ").append(Utils.toIndentedString(account)).append("\n");
      sb.append("    trafficFine: ").append(Utils.toIndentedString(trafficFine)).append("\n");
      sb.append("    policy: ").append(Utils.toIndentedString(policy)).append("\n");
      sb.append("    thirdPartyIdentifiers: ").append(Utils.toIndentedString(thirdPartyIdentifiers)).append("\n");
      sb.append("    slipData: ").append(Utils.toIndentedString(slipData)).append("\n");
      sb.append("    basketRef: ").append(Utils.toIndentedString(basketRef)).append("\n");
      sb.append("    overPaymentAllowed: ").append(Utils.toIndentedString(overPayment)).append("\n");
      sb.append("    partPaymentAllowed: ").append(Utils.toIndentedString(partPayment)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
