package io.swagger.model;

import io.swagger.annotations.ApiModel;

import java.util.Objects;

/**
 * A reference number identifying the bill issuer as well as the customer account
 **/

@ApiModel(description = "A reference number identifying the bill issuer as well as the customer account")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-06-13T18:34:39.493Z")
public class AccountRef {

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      AccountRef accountRef = (AccountRef) o;
      return true;
   }

   @Override
   public int hashCode() {
      return Objects.hash();
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class AccountRef {\n");

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
