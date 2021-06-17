package io.electrum.billpay.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @since v4.11.0
 */
@ApiModel(description = "Category to which a bill issuer can belong")
public class Category {

   @ApiModelProperty(required = true, value = "Unique identifier for this category")
   @JsonProperty("id")
   @NotNull
   @Length(max = 40)
   protected String id = null;

   @ApiModelProperty(required = true, value = "Category name")
   @JsonProperty("name")
   @NotNull
   @Length(max = 100)
   protected String name = null;

   /**
    * @param id
    *           a unique identifier for this category category
    * @return this Object
    **/
   public Category id(String id) {
      this.id = id;
      return this;
   }

   /**
    * @return a unique identifier for this category category
    **/
   public String getId() {
      return id;
   }

   /**
    * @param id
    *           unique identifier for this category category
    **/
   public void setId(String id) {
      this.id = id;
   }

   /**
    * @param name
    *           descriptive name for the category
    * @return this Object
    **/
   public Category name(String name) {
      this.name = name;
      return this;
   }

   /**
    * @return the descriptive name for the category
    **/
   public String getName() {
      return name;
   }

   /**
    * @param name
    *           descriptive name for the category
    **/
   public void setName(String name) {
      this.name = name;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      Category category = (Category) o;
      return Objects.equals(getId(), category.getId()) && Objects.equals(getName(), category.getName());
   }

   @Override
   public int hashCode() {
      return Objects.hash(getId(), getName());
   }

   @Override
   public String toString() {
      return "Category{" + "id='" + id + '\'' + ", name='" + name + '\'' + '}';
   }
}
