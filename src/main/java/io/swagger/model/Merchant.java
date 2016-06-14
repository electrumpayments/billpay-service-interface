package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Merchant related data. Must be included if available
 **/

@ApiModel(description = "Merchant related data. Must be included if available")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-06-13T18:34:39.493Z")
public class Merchant {

   private String merchantType = null;
   private String merchantId = null;
   private MerchantName merchantName = null;

   /**
    * The assigned four digit merchant category code
    **/
   public Merchant merchantType(String merchantType) {
      this.merchantType = merchantType;
      return this;
   }

   @ApiModelProperty(required = true, value = "The assigned four digit merchant category code")
   @JsonProperty("merchantType")
   public String getMerchantType() {
      return merchantType;
   }

   public void setMerchantType(String merchantType) {
      this.merchantType = merchantType;
   }

   /**
    * The assigned merchant identifier. Also known as card acceptor id
    **/
   public Merchant merchantId(String merchantId) {
      this.merchantId = merchantId;
      return this;
   }

   @ApiModelProperty(required = true, value = "The assigned merchant identifier. Also known as card acceptor id")
   @JsonProperty("merchantId")
   public String getMerchantId() {
      return merchantId;
   }

   public void setMerchantId(String merchantId) {
      this.merchantId = merchantId;
   }

   /**
   **/
   public Merchant merchantName(MerchantName merchantName) {
      this.merchantName = merchantName;
      return this;
   }

   @ApiModelProperty(required = true, value = "")
   @JsonProperty("merchantName")
   public MerchantName getMerchantName() {
      return merchantName;
   }

   public void setMerchantName(MerchantName merchantName) {
      this.merchantName = merchantName;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      Merchant merchant = (Merchant) o;
      return Objects.equals(merchantType, merchant.merchantType) && Objects.equals(merchantId, merchant.merchantId)
            && Objects.equals(merchantName, merchant.merchantName);
   }

   @Override
   public int hashCode() {
      return Objects.hash(merchantType, merchantId, merchantName);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class Merchant {\n");

      sb.append("    merchantType: ").append(toIndentedString(merchantType)).append("\n");
      sb.append("    merchantId: ").append(toIndentedString(merchantId)).append("\n");
      sb.append("    merchantName: ").append(toIndentedString(merchantName)).append("\n");
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
