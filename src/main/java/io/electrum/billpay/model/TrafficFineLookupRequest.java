package io.electrum.billpay.model;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The data required to request traffic fine info
 **/
@ApiModel(description = "The data required to request traffic fine info")
public class TrafficFineLookupRequest extends BillpayRequest {

   @ApiModelProperty(required = true, value = "A reference number identifying the traffic fine to the service provider.")
   @JsonProperty("noticeNumber")
   @NotNull
   @Length(min = 6, max = 40)
   private String noticeNumber = null;

   /**
    * A reference number identifying the traffic fine to the service provider.
    **/
   public TrafficFineLookupRequest noticeNumber(String noticeNumber) {
      this.noticeNumber = noticeNumber;
      return this;
   }

   public String getNoticeNumber() {
      return noticeNumber;
   }

   public void setNoticeNumber(String noticeNumber) {
      this.noticeNumber = noticeNumber;
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class TrafficFineLookupRequest {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    noticeNumber: ").append(Utils.toIndentedString(noticeNumber)).append("\n");
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
