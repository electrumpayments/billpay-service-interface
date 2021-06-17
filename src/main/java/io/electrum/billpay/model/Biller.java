package io.electrum.billpay.model;

import io.electrum.vas.model.Institution;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @since v4.11.0
 */

@ApiModel(description = "Contains the information about the biller")
public class Biller {

   @ApiModelProperty(required = true, value = "Institution identifying the biller.")
   @JsonProperty("billerInstitution")
   @NotNull
   @Valid
   protected Institution billerInstitution;

   @ApiModelProperty(value = "List of Categories to which this biller belongs")
   @JsonProperty("categories")
   @Valid
   protected List<Category> categories = new ArrayList<>();

   @ApiModelProperty(value = "Indicates if transactions should be blocked without sending them to the upstream biller. "
         + "Transactions will be blocked if allowed is set to false, otherwise they will not be blocked.")
   @JsonProperty(value = "allowed", defaultValue = "true")
   protected boolean allowed = true;

   /**
    * @param billerInstitution
    *           the Institution identifying the biller
    * @return this object
    */
   public Biller billerInstitution(Institution billerInstitution) {
      this.billerInstitution = billerInstitution;
      return this;
   }

   /**
    * @return billerInstitution the Institution identifying the biller
    */
   public Institution getBillerInstitution() {
      return billerInstitution;
   }

   /**
    * @param billerInstitution
    *           the Institution identifying the biller
    */
   public void setBillerInstitution(Institution billerInstitution) {
      this.billerInstitution = billerInstitution;
   }

   /**
    * Indicates if transactions should be blocked without sending them to the upstream biller.
    * 
    * @param allowed
    *           <i>true</i> if transactions to the biller should be allowed, or false if they should be blocked
    *
    * @return this Object
    **/
   public Biller allowed(boolean allowed) {
      this.allowed = allowed;
      return this;
   }

   /**
    * @return <i>true</i> if transactions to the biller should be allowed, or false if they should be blocked
    */
   public boolean getAllowed() {
      return allowed;
   }

   /**
    * @param allowed
    *           <i>true</i> if transactions to the biller should be allowed, or false if they should be blocked
    **/
   public void setAllowed(boolean allowed) {
      this.allowed = allowed;
   }

   /**
    * @param categories
    *           list of {@link Category Categories} to which this biller belong
    *
    * @return this object
    **/
   public Biller categories(List<Category> categories) {
      this.categories = categories;
      return this;
   }

   /**
    * @return list of {@link Category Categories} to which this biller belong
    *
    **/
   public List<Category> getCategories() {
      return categories;
   }

   /**
    * @param categories
    *           the list of {@link Category Categories} to which this biller belong
    **/
   public void setCategories(List<Category> categories) {
      this.categories = categories;
   }
}
