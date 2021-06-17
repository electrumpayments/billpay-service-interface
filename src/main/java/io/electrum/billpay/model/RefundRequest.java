package io.electrum.billpay.model;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a request to refund a payment
 **/
@ApiModel(description = "Represents a request to refund a payment")
public class RefundRequest extends BillpayRequest {

   @ApiModelProperty(required = true, value = "An identifier that is printed on the customer slip and uniquely identifies the payment on the bill issuer's system. This value is used by the customer to request a refund when the service supports this function, and it is thus important that this number is unique")
   @JsonProperty("issuerReference")
   @NotNull
   @Pattern(regexp = "[A-Z0-9]{1,20}")
   private String issuerReference = null;

   @ApiModelProperty(required = true, value = "The reason for the refund as given by the customer")
   @JsonProperty("refundReason")
   @NotNull
   @Length(max = 20)
   private String refundReason = null;

   /**
    * An identifier that is printed on the customer slip and uniquely identifies the payment on the bill issuer's
    * system. This value is used by the customer to request a refund when the service supports this function, and it is
    * thus important that this number is unique
    **/
   public RefundRequest issuerReference(String issuerReference) {
      this.issuerReference = issuerReference;
      return this;
   }

   public String getIssuerReference() {
      return issuerReference;
   }

   public void setIssuerReference(String issuerReference) {
      this.issuerReference = issuerReference;
   }

   /**
    * The reason for the refund as given by the customer
    **/
   public RefundRequest refundReason(String refundReason) {
      this.refundReason = refundReason;
      return this;
   }

   public String getRefundReason() {
      return refundReason;
   }

   public void setRefundReason(String refundReason) {
      this.refundReason = refundReason;
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class RefundRequest {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    time: ").append(Utils.toIndentedString(time)).append("\n");
      sb.append("    originator: ").append(Utils.toIndentedString(originator)).append("\n");
      sb.append("    client: ").append(Utils.toIndentedString(client)).append("\n");
      sb.append("    settlementEntity: ").append(Utils.toIndentedString(settlementEntity)).append("\n");
      sb.append("    receiver: ").append(Utils.toIndentedString(receiver)).append("\n");
      sb.append("    issuerReference: ").append(Utils.toIndentedString(issuerReference)).append("\n");
      sb.append("    refundReason: ").append(Utils.toIndentedString(refundReason)).append("\n");
      sb.append("    thirdPartyIdentifiers: ").append(Utils.toIndentedString(thirdPartyIdentifiers)).append("\n");
      sb.append("    slipData: ").append(Utils.toIndentedString(slipData)).append("\n");
      sb.append("    basketRef: ").append(Utils.toIndentedString(basketRef)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
