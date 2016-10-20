package io.electrum.billpay.model;

import java.util.Objects;

import javax.validation.constraints.Pattern;

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

   protected String issuerReference = null;
   private String phoneNumber = null;

   /**
    * An identifier that is printed on the customer slip and uniquely identifies the payment on the bill issuer's
    * system. This value is used by the customer to request a refund when the service supports this function, and it is
    * thus important that this number is unique.
    **/
   public SlipData issuerReference(String issuerReference) {
      this.issuerReference = issuerReference;
      return this;
   }

   @ApiModelProperty(value = "An identifier that is printed on the customer slip and uniquely identifies the payment on the bill issuer's system. This value is used by the customer to request a refund when the service supports this function, and it is thus important that this number is unique.")
   @JsonProperty("issuerReference")
   @Pattern(regexp = "[A-Z0-9]{1,20}")
   public String getIssuerReference() {
      return issuerReference;
   }

   public void setIssuerReference(String issuerReference) {
      this.issuerReference = issuerReference;
   }

   /**
    * The call centre phone number
    **/
   public BillSlipData phoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
      return this;
   }

   @ApiModelProperty(value = "The call centre phone number")
   @JsonProperty("phoneNumber")
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
      return Objects.equals(messageLines, slipData.messageLines) && Objects.equals(phoneNumber, slipData.phoneNumber)
            && Objects.equals(issuerReference, slipData.issuerReference);
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
      sb.append("    phoneNumber: ").append(Utils.toIndentedString(phoneNumber)).append("\n");
      sb.append("    issuerReference: ").append(Utils.toIndentedString(issuerReference)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
