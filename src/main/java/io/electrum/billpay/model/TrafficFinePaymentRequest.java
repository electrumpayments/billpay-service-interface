package io.electrum.billpay.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.electrum.vas.model.Amounts;
import io.electrum.vas.model.Transaction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Represents a request to perform a payment of a traffic fine.
 **/
@ApiModel(description = "Represents a request to perform a payment of a traffic fine.")
public class TrafficFinePaymentRequest extends Transaction {

   private String noticeNumber = null;
   private Amounts amounts = null;

   /**
    * A reference number identifying the traffic fine to the service provider.
    **/
   public TrafficFinePaymentRequest noticeNumber(String noticeNumber) {
      this.noticeNumber = noticeNumber;
      return this;
   }

   @ApiModelProperty(required = true, value = "A reference number identifying the traffic fine to the service provider.")
   @JsonProperty("noticeNumber")
   @NotNull
   @Length(min = 6, max = 40)
   public String getNoticeNumber() {
      return noticeNumber;
   }

   public void setNoticeNumber(String noticeNumber) {
      this.noticeNumber = noticeNumber;
   }

   /**
    * Contains the payment amount.
    **/
   public TrafficFinePaymentRequest amounts(Amounts amounts) {
      this.amounts = amounts;
      return this;
   }

   @ApiModelProperty(required = true, value = "Contains the payment amount.")
   @JsonProperty("amounts")
   @NotNull
   @Valid
   public Amounts getAmounts() {
      return amounts;
   }

   public void setAmounts(Amounts amounts) {
      this.amounts = amounts;
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class TrafficFinePaymentRequest {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    time: ").append(Utils.toIndentedString(time)).append("\n");
      sb.append("    originator: ").append(Utils.toIndentedString(originator)).append("\n");
      sb.append("    client: ").append(Utils.toIndentedString(client)).append("\n");
      sb.append("    settlementEntity: ").append(Utils.toIndentedString(settlementEntity)).append("\n");
      sb.append("    receiver: ").append(Utils.toIndentedString(receiver)).append("\n");
      sb.append("    noticeNumber: ").append(Utils.toIndentedString(noticeNumber)).append("\n");
      sb.append("    amounts: ").append(Utils.toIndentedString(amounts)).append("\n");
      sb.append("    thirdPartyIdentifiers: ").append(Utils.toIndentedString(thirdPartyIdentifiers)).append("\n");
      sb.append("    slipData: ").append(Utils.toIndentedString(slipData)).append("\n");
      sb.append("    basketRef: ").append(Utils.toIndentedString(basketRef)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
