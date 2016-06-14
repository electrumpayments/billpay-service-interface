package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * An amount object only containing value and currency, and optionally an indicator of DEBIT/CREDIT
 **/

@ApiModel(description = "An amount object only containing value and currency, and optionally an indicator of DEBIT/CREDIT")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-06-13T18:34:39.493Z")
public class LedgerAmount {

   private String amount = null;
   private String currency = null;

   /**
    * Indicates whether this amount is a debit or a credit. Only required when the amount can be either a debit or a
    * credit
    */
   public enum LedgerIndicatorEnum {
      DEBIT("DEBIT"),

      CREDIT("CREDIT");
      private String value;

      LedgerIndicatorEnum(String value) {
         this.value = value;
      }

      @Override
      @JsonValue
      public String toString() {
         return String.valueOf(value);
      }
   }

   private LedgerIndicatorEnum ledgerIndicator = null;

   /**
    * Amount in minor denomination, e.g. R799.95 is encoded as 79995
    **/
   public LedgerAmount amount(String amount) {
      this.amount = amount;
      return this;
   }

   @ApiModelProperty(required = true, value = "Amount in minor denomination, e.g. R799.95 is encoded as 79995")
   @JsonProperty("amount")
   public String getAmount() {
      return amount;
   }

   public void setAmount(String amount) {
      this.amount = amount;
   }

   /**
    * Three digit currency number from ISO 4217, e.g. South African Rand is encoded as 710
    **/
   public LedgerAmount currency(String currency) {
      this.currency = currency;
      return this;
   }

   @ApiModelProperty(required = true, value = "Three digit currency number from ISO 4217, e.g. South African Rand is encoded as 710")
   @JsonProperty("currency")
   public String getCurrency() {
      return currency;
   }

   public void setCurrency(String currency) {
      this.currency = currency;
   }

   /**
    * Indicates whether this amount is a debit or a credit. Only required when the amount can be either a debit or a
    * credit
    **/
   public LedgerAmount ledgerIndicator(LedgerIndicatorEnum ledgerIndicator) {
      this.ledgerIndicator = ledgerIndicator;
      return this;
   }

   @ApiModelProperty(value = "Indicates whether this amount is a debit or a credit. Only required when the amount can be either a debit or a credit")
   @JsonProperty("ledgerIndicator")
   public LedgerIndicatorEnum getLedgerIndicator() {
      return ledgerIndicator;
   }

   public void setLedgerIndicator(LedgerIndicatorEnum ledgerIndicator) {
      this.ledgerIndicator = ledgerIndicator;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      LedgerAmount ledgerAmount = (LedgerAmount) o;
      return Objects.equals(amount, ledgerAmount.amount) && Objects.equals(currency, ledgerAmount.currency)
            && Objects.equals(ledgerIndicator, ledgerAmount.ledgerIndicator);
   }

   @Override
   public int hashCode() {
      return Objects.hash(amount, currency, ledgerIndicator);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class LedgerAmount {\n");

      sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
      sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
      sb.append("    ledgerIndicator: ").append(toIndentedString(ledgerIndicator)).append("\n");
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
