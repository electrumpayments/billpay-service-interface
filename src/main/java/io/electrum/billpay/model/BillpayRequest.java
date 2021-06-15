package io.electrum.billpay.model;

import io.electrum.vas.model.Transaction;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BillpayRequest extends Transaction {

   @ApiModelProperty(value = "The getBillers operation includes a list of available "
         + "categories for each biller. This field can be used to associate a single one of those "
         + "categories with the request transaction.")
   @JsonProperty("categories")
   @Valid
   protected Category selectedCategory;

   /**
    *
    * @param selectedCategory
    *           the category to associate with this request transaction
    * @return this Object
    */
   public BillpayRequest selectedCategory(Category selectedCategory) {
      this.selectedCategory = selectedCategory;
      return this;
   }

   /**
    *
    * @return the category to associate with this request transaction
    */
   public Category getSelectedCategory() {
      return selectedCategory;
   }

   /**
    *
    * @param selectedCategory
    *           the category to associate with this request transaction
    */
   public void setSelectedCategory(Category selectedCategory) {
      this.selectedCategory = selectedCategory;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      if (!super.equals(o))
         return false;
      BillpayRequest that = (BillpayRequest) o;
      return Objects.equals(getSelectedCategory(), that.getSelectedCategory());
   }

   @Override
   public int hashCode() {
      return Objects.hash(super.hashCode(), getSelectedCategory());
   }

   @Override
   public String toString() {
      return "BillpayRequest{" + "selectedCategory=" + selectedCategory + "} " + super.toString();
   }
}
