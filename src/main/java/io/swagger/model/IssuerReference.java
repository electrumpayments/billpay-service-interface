package io.swagger.model;

import io.swagger.annotations.ApiModel;

import java.util.Objects;

/**
 * An identifier that is printed on the customer slip and uniquely identifies the payment on the bill issuer&#39;s
 * system. This value is used by the customer to request a refund when the service supports this function, and it is
 * thus important that this number is unique
 **/

@ApiModel(description = "An identifier that is printed on the customer slip and uniquely identifies the payment on the bill issuer's system. This value is used by the customer to request a refund when the service supports this function, and it is thus important that this number is unique")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-06-13T18:34:39.493Z")
public class IssuerReference {

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      IssuerReference issuerReference = (IssuerReference) o;
      return true;
   }

   @Override
   public int hashCode() {
      return Objects.hash();
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class IssuerReference {\n");

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
