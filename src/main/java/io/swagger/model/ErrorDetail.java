package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Represents the outcome of a completed transaction
 **/

@ApiModel(description = "Represents the outcome of a completed transaction")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-06-13T18:34:39.493Z")
public class ErrorDetail {

   private String responseCode = null;
   private String responseMessage = null;
   private Object detailMessage = null;

   /**
    * The response code. Will always be present unless request to upstream timed out
    **/
   public ErrorDetail responseCode(String responseCode) {
      this.responseCode = responseCode;
      return this;
   }

   @ApiModelProperty(value = "The response code. Will always be present unless request to upstream timed out")
   @JsonProperty("responseCode")
   public String getResponseCode() {
      return responseCode;
   }

   public void setResponseCode(String responseCode) {
      this.responseCode = responseCode;
   }

   /**
    * The response code description
    **/
   public ErrorDetail responseMessage(String responseMessage) {
      this.responseMessage = responseMessage;
      return this;
   }

   @ApiModelProperty(required = true, value = "The response code description")
   @JsonProperty("responseMessage")
   public String getResponseMessage() {
      return responseMessage;
   }

   public void setResponseMessage(String responseMessage) {
      this.responseMessage = responseMessage;
   }

   /**
    * A free form detailed description of a particular failure condition may optionally be supplied
    **/
   public ErrorDetail detailMessage(Object detailMessage) {
      this.detailMessage = detailMessage;
      return this;
   }

   @ApiModelProperty(value = "A free form detailed description of a particular failure condition may optionally be supplied")
   @JsonProperty("detailMessage")
   public Object getDetailMessage() {
      return detailMessage;
   }

   public void setDetailMessage(Object detailMessage) {
      this.detailMessage = detailMessage;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      ErrorDetail errorDetail = (ErrorDetail) o;
      return Objects.equals(responseCode, errorDetail.responseCode)
            && Objects.equals(responseMessage, errorDetail.responseMessage)
            && Objects.equals(detailMessage, errorDetail.detailMessage);
   }

   @Override
   public int hashCode() {
      return Objects.hash(responseCode, responseMessage, detailMessage);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class ErrorDetail {\n");

      sb.append("    responseCode: ").append(toIndentedString(responseCode)).append("\n");
      sb.append("    responseMessage: ").append(toIndentedString(responseMessage)).append("\n");
      sb.append("    detailMessage: ").append(toIndentedString(detailMessage)).append("\n");
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
