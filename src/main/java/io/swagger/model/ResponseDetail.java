package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Response specific data
 **/
@ApiModel(description = "Response specific data")
public class ResponseDetail {

   private LedgerAmount responseAmount = null;

   /**
    * Response amount
   **/
   public ResponseDetail responseAmount(LedgerAmount responseAmount) {
      this.responseAmount = responseAmount;
      return this;
   }

   @ApiModelProperty(required = true, value = "Response amount")
   @JsonProperty("responseAmount")
   @NotNull
   public LedgerAmount getResponseAmount() {
      return responseAmount;
   }

   public void setResponseAmount(LedgerAmount responseAmount) {
      this.responseAmount = responseAmount;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      ResponseDetail responseDetail = (ResponseDetail) o;
      return Objects.equals(responseAmount, responseDetail.responseAmount);
   }

   @Override
   public int hashCode() {
      return Objects.hash(responseAmount);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class ResponseDetail {\n");

      sb.append("    responseAmount: ").append(toIndentedString(responseAmount)).append("\n");
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
