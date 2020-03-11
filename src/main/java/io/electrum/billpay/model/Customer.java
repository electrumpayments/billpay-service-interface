package io.electrum.billpay.model;

import java.util.Objects;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A bill payment customer
 **/
@ApiModel(description = "A bill payment customer")
public class Customer {

   @ApiModelProperty(value = "The customer's first name(s)")
   @JsonProperty("firstName")
   @Length(max = 40)
   private String firstName = null;

   @ApiModelProperty(value = "The customer's last name")
   @JsonProperty("lastName")
   @Length(max = 40)
   private String lastName = null;

   @ApiModelProperty(value = "The customer's address")
   @JsonProperty("address")
   @Length(max = 80)
   private String address = null;

   @ApiModelProperty(value = "The customer's ID Number")
   @JsonProperty("idNumber")
   @Length(max = 13)
   private String idNumber = null;

   @ApiModelProperty(value = "The customer's contact number")
   @JsonProperty("contactNumber")
   @Length(max = 40)
   private String contactNumber = null;

   /**
    * The customer's first name(s)
    **/
   public Customer firstName(String firstName) {
      this.firstName = firstName;
      return this;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   /**
    * The customer's last name
    **/
   public Customer lastName(String lastName) {
      this.lastName = lastName;
      return this;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   /**
    * The customer's address
    **/
   public Customer address(String address) {
      this.address = address;
      return this;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   /**
    * The customer's ID number
    **/
   public Customer idNumber(String idNumber) {
      this.idNumber = idNumber;
      return this;
   }

   public String getIdNumber() {
      return idNumber;
   }

   public void setIdNumber(String idNumber) {
      this.idNumber = idNumber;
   }

   /**
    * The customer's contact number
    **/
   public Customer contactNumber(String contactNumber) {
      this.contactNumber = contactNumber;
      return this;
   }

   public String getContactNumber() {
      return contactNumber;
   }

   public void setContactNumber(String contactNumber) {
      this.contactNumber = contactNumber;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      Customer customer = (Customer) o;
      return Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName)
            && Objects.equals(address, customer.address) && Objects.equals(idNumber, customer.idNumber)
            && Objects.equals(contactNumber, customer.contactNumber);
   }

   @Override
   public int hashCode() {
      return Objects.hash(firstName, lastName, address, idNumber, contactNumber);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class Customer {\n");

      sb.append("    firstName: ").append(Utils.toIndentedString(firstName)).append("\n");
      sb.append("    lastName: ").append(Utils.toIndentedString(lastName)).append("\n");
      sb.append("    address: ").append(Utils.toIndentedString(address)).append("\n");
      sb.append("    idNumber: ").append(Utils.toIndentedString(idNumber)).append("\n");
      sb.append("    contactNumber: ").append(Utils.toIndentedString(contactNumber)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
