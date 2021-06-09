package io.electrum.billpay.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @since v4.10.0
 */
//todo did we want this in the billpay package or VAS package?
@ApiModel(description = "Category to which a bill issuer can belong")
public class Category {

   @ApiModelProperty(required = false, value = "Unique identifier for this category")
   @JsonProperty("id")
   @NotNull
   @Length(max = 40)
   protected String id = null;

   @ApiModelProperty(required = false, value = "Category name")
   @JsonProperty("name")
   @NotNull
   @Length(max = 100)
   protected String name = null;

   /**
    * A unique number identifying the category
    **/
   public Category id(String id) {
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
    * A unique number identifying the category
    **/
   public Category name(String name) {
      this.name = name;
      return this;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Category category = (Category) o;
      return Objects.equals(id, category.id) && Objects.equals(name, category.name);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, name);
   }

   @Override
   public String toString() {
      final StringBuilder sb = new StringBuilder("Category{");
      sb.append("id='").append(id).append('\'');
      sb.append(", name='").append(name).append('\'');
      sb.append('}');
      return sb.toString();
   }
}
