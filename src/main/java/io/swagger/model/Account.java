package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.Objects;

/**
 * Represents the status of a customer account
 **/

@ApiModel(description = "Represents the status of a customer account")
public class Account {

   private AccountRef accountRef = null;
   private LedgerAmount balance = null;
   private Date dueDate = null;

   /**
    * A reference number identifying the bill payments processor, bill issuer, and customer
    **/
   public Account accountRef(AccountRef accountRef) {
      this.accountRef = accountRef;
      return this;
   }

   @ApiModelProperty(required = true, value = "A reference number identifying the bill payments processor, bill issuer, and customer")
   @JsonProperty("accountRef")
   public AccountRef getAccountRef() {
      return accountRef;
   }

   public void setAccountRef(AccountRef accountRef) {
      this.accountRef = accountRef;
   }

   /**
    * The customer account balance
    **/
   public Account balance(LedgerAmount balance) {
      this.balance = balance;
      return this;
   }

   @ApiModelProperty(value = "The customer account balance")
   @JsonProperty("balance")
   public LedgerAmount getBalance() {
      return balance;
   }

   public void setBalance(LedgerAmount balance) {
      this.balance = balance;
   }

   /**
    * The effective date of the current billing period
    **/
   public Account dueDate(Date dueDate) {
      this.dueDate = dueDate;
      return this;
   }

   @ApiModelProperty(value = "The effective date of the current billing period")
   @JsonProperty("dueDate")
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yy-MM-dd", timezone = "UTC")
   public Date getDueDate() {
      return dueDate;
   }

   public void setDueDate(Date dueDate) {
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
      return Objects.equals(accountRef, account.accountRef) && Objects.equals(balance, account.balance)
            && Objects.equals(dueDate, account.dueDate);
   }

   @Override
   public int hashCode() {
      return Objects.hash(accountRef, balance, dueDate);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class Account {\n");

      sb.append("    accountRef: ").append(toIndentedString(accountRef)).append("\n");
      sb.append("    balance: ").append(toIndentedString(balance)).append("\n");
      sb.append("    dueDate: ").append(toIndentedString(dueDate)).append("\n");
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
