package io.electrum.billpay.model;

import java.util.Arrays;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @since v4.10.0
 */

@ApiModel(description = "Contains the information about the bill issuer")
public class Biller {

   @ApiModelProperty(required = false, value = "Identifier of bill issuer")
   @JsonProperty("id")
   @NotNull
   @Length(max = 40)
   protected String id = null;

   @ApiModelProperty(required = false, value = "Name of bill issuer")
   @JsonProperty("name")
   @NotNull
   @Length(max = 100)
   protected String name = null;

   @ApiModelProperty(required = false, value = "Array of Categories to which this bill issuer belongs")
   @JsonProperty("categories")
   @NotNull
   protected Category [] categories = null;

   @ApiModelProperty(required = false, value = "Only returned in the listBillers call. If false, transactions to this biller is blocked.")
   @JsonProperty(value = "allowed", defaultValue = "true")
   @NotNull
   protected boolean allowed = true; // todo how do we prevent this property being populated in any other call besides listBillers?

   /**
    * A reference number identifying the bill issuer
    **/
   public Biller id(String id) {
      this.id = id;
      return this;
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   /**
    * Name of the bill issuer
    **/
   public Biller name(String name) {
      this.name = name;
      return this;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   /**
    * Array of Categories to which this bill issuer belongs
    **/
   public Biller categories(Category [] categories) {
      this.categories = categories;
      return this;
   }

   public Category [] getCategories() {
      return categories;
   }

   public void setCategories(Category [] categories) {
      this.categories = categories;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Biller biller = (Biller) o;
      return Objects.equals(id, biller.id) && Objects.equals(name, biller.name) && Arrays.equals(categories, biller.categories);
   }

   @Override
   public int hashCode() {
      int result = Objects.hash(id, name);
      result = 31 * result + Arrays.hashCode(categories);
      return result;
   }

   @Override
   public String toString() {
      final StringBuilder sb = new StringBuilder("Biller{");
      sb.append("id='").append(id).append('\'');
      sb.append(", name='").append(name).append('\'');
      sb.append(", categories=").append(Arrays.toString(categories));
      sb.append('}');
      return sb.toString();
   }
}
