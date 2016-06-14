package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Processing or receiving institution details
 **/

@ApiModel(description = "Processing or receiving institution details")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-06-13T18:34:39.493Z")
public class Institution {

   private String id = null;
   private String name = null;

   /**
    * The institution's id
    **/
   public Institution id(String id) {
      this.id = id;
      return this;
   }

   @ApiModelProperty(value = "The institution's id")
   @JsonProperty("id")
   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   /**
    * The institutions's name
    **/
   public Institution name(String name) {
      this.name = name;
      return this;
   }

   @ApiModelProperty(value = "The institutions's name")
   @JsonProperty("name")
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      Institution institution = (Institution) o;
      return Objects.equals(id, institution.id) && Objects.equals(name, institution.name);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, name);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class Institution {\n");

      sb.append("    id: ").append(toIndentedString(id)).append("\n");
      sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
