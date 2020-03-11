package io.electrum.billpay.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.electrum.vas.model.SlipData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Data that may be printed on the customer slip for information purposes
 **/
@ApiModel(description = "Data that may be printed on the customer slip for information purposes")
public class BillSlipData extends SlipData {

   @ApiModelProperty(value = "The call centre phone number")
   @JsonProperty("phoneNumber")
   protected String phoneNumber = null;

   /**
    * The call centre phone number
    **/
   public BillSlipData phoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
      return this;
   }

   public String getPhoneNumber() {
      return phoneNumber;
   }

   public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      BillSlipData slipData = (BillSlipData) o;
      return Objects.equals(messageLines, slipData.messageLines) && Objects.equals(slipWidth, slipData.slipWidth)
            && Objects.equals(issuerReference, slipData.issuerReference)
            && Objects.equals(phoneNumber, slipData.phoneNumber);
   }

   @Override
   public int hashCode() {
      return Objects.hash(messageLines, phoneNumber, issuerReference);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class BillSlipData {\n");

      sb.append("    messageLines: ").append(Utils.toIndentedString(messageLines)).append("\n");
      sb.append("    slipWidth: ").append(Utils.toIndentedString(slipWidth)).append("\n");
      sb.append("    issuerReference: ").append(Utils.toIndentedString(issuerReference)).append("\n");
      sb.append("    phoneNumber: ").append(Utils.toIndentedString(phoneNumber)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
