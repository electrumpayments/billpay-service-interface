package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Request specific data
 **/

@ApiModel(description = "Request specific data")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-06-13T18:34:39.493Z")
public class RequestDetail {

   private String clientRef = null;
   private LedgerAmount requestAmount = null;

   /**
    * A reference number useful to the client for identifying transactions, also knows as a retrieval reference number
    **/
   public RequestDetail clientRef(String clientRef) {
      this.clientRef = clientRef;
      return this;
   }

   @ApiModelProperty(value = "A reference number useful to the client for identifying transactions, also knows as a retrieval reference number")
   @JsonProperty("clientRef")
   public String getClientRef() {
      return clientRef;
   }

   public void setClientRef(String clientRef) {
      this.clientRef = clientRef;
   }

   /**
   **/
   public RequestDetail requestAmount(LedgerAmount requestAmount) {
      this.requestAmount = requestAmount;
      return this;
   }

   @ApiModelProperty(required = true, value = "")
   @JsonProperty("requestAmount")
   public LedgerAmount getRequestAmount() {
      return requestAmount;
   }

   public void setRequestAmount(LedgerAmount requestAmount) {
      this.requestAmount = requestAmount;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      RequestDetail requestDetail = (RequestDetail) o;
      return Objects.equals(clientRef, requestDetail.clientRef)
            && Objects.equals(requestAmount, requestDetail.requestAmount);
   }

   @Override
   public int hashCode() {
      return Objects.hash(clientRef, requestAmount);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class RequestDetail {\n");

      sb.append("    clientRef: ").append(toIndentedString(clientRef)).append("\n");
      sb.append("    requestAmount: ").append(toIndentedString(requestAmount)).append("\n");
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
