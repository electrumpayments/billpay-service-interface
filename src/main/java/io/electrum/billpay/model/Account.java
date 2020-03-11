package io.electrum.billpay.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.joda.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Represents the status of a customer account
 **/

@ApiModel(description = "Represents the status of a customer account")
public class Account {

   @ApiModelProperty(required = true, value = "A reference number identifying the bill payments processor, bill issuer, and customer")
   @JsonProperty("accountRef")
   @NotNull
   @Length(min = 6, max = 40)
   protected String accountRef = null;

   @ApiModelProperty(value = "The effective date of the current billing period in the format yyyy-MM-dd")
   @JsonProperty("dueDate")
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
   protected LocalDate dueDate = null;

   /**
    * A reference number identifying the bill payments processor, bill issuer, and customer
    **/
   public Account accountRef(String accountRef) {
      this.accountRef = accountRef;
      return this;
   }

   public String getAccountRef() {
      return accountRef;
   }

   public void setAccountRef(String accountRef) {
      this.accountRef = accountRef;
   }

   /**
    * The effective date of the current billing period
    **/
   public Account dueDate(LocalDate dueDate) {
      this.dueDate = dueDate;
      return this;
   }

   public LocalDate getDueDate() {
      return dueDate;
   }

   public void setDueDate(LocalDate dueDate) {
      this.dueDate = dueDate;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      Account account = (Account) o;
      return Objects.equals(accountRef, account.accountRef) && Objects.equals(dueDate, account.dueDate);
   }

   @Override
   public int hashCode() {
      return Objects.hash(accountRef, dueDate);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class Account {\n");

      sb.append("    accountRef: ").append(Utils.toIndentedString(accountRef)).append("\n");
      sb.append("    dueDate: ").append(Utils.toIndentedString(dueDate)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
