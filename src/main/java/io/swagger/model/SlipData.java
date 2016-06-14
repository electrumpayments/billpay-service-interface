package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Data that may be printed on the custoemr slip for information purposes
 **/

@ApiModel(description = "Data that may be printed on the custoemr slip for information purposes")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-06-13T18:34:39.493Z")
public class SlipData {

   private List<String> messageLines = new ArrayList<String>();
   private String phoneNumber = null;
   private IssuerReference issuerReference = null;

   /**
    * An array of free text lines to be printed on the customer slip
    **/
   public SlipData messageLines(List<String> messageLines) {
      this.messageLines = messageLines;
      return this;
   }

   @ApiModelProperty(value = "An array of free text lines to be printed on the customer slip")
   @JsonProperty("messageLines")
   public List<String> getMessageLines() {
      return messageLines;
   }

   public void setMessageLines(List<String> messageLines) {
      this.messageLines = messageLines;
   }

   /**
    * The call centre phone number
    **/
   public SlipData phoneNumber(String phoneNumber) {
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

   /**
   **/
   public SlipData issuerReference(IssuerReference issuerReference) {
      this.issuerReference = issuerReference;
      return this;
   }

   @ApiModelProperty(required = true, value = "")
   @JsonProperty("issuerReference")
   public IssuerReference getIssuerReference() {
      return issuerReference;
   }

   public void setIssuerReference(IssuerReference issuerReference) {
      this.issuerReference = issuerReference;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      SlipData slipData = (SlipData) o;
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
      sb.append("class SlipData {\n");

      sb.append("    messageLines: ").append(toIndentedString(messageLines)).append("\n");
      sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
      sb.append("    issuerReference: ").append(toIndentedString(issuerReference)).append("\n");
      sb.append("}");
      return sb.toString();
   }

   /**
    * Convert the given object to string with each line indented by 4 spaces (except the first line).
    */
   private String toIndentedString(Object o) {
      if (o == null) {
         return "null";
      }
      return o.toString().replace("\n", "\n    ");
   }
}
