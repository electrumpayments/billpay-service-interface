package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * A tender used by a customer towards a payment
 **/

@ApiModel(description = "A tender used by a customer towards a payment")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-06-13T18:34:39.493Z")
public class Tender {

   /**
    * The type of account
    */
   public enum AccountTypeEnum {
      DEFAULT("DEFAULT"),

      SAVINGS("SAVINGS"),

      CHEQUE("CHEQUE"),

      CREDIT("CREDIT"),

      UNIVERSAL("UNIVERSAL"),

      ELECTRONIC_PURSE("ELECTRONIC_PURSE"),

      STORED_VALUE("STORED_VALUE");
      private String value;

      AccountTypeEnum(String value) {
         this.value = value;
      }

      @Override
      @JsonValue
      public String toString() {
         return String.valueOf(value);
      }
   }

   private AccountTypeEnum accountType = AccountTypeEnum.DEFAULT;
   private LedgerAmount amount = null;
   private String cardNumber = null;
   private String reference = null;

   /**
    * The type of tender used
    */
   public enum TenderTypeEnum {
      CASH("CASH"),

      CHECQUE("CHECQUE"),

      CREDIT_CARD("CREDIT_CARD"),

      DEBIT_CARD("DEBIT_CARD"),

      WALLET("WALLET"),

      ROUNDING("ROUNDING"),

      OTHER("OTHER");
      private String value;

      TenderTypeEnum(String value) {
         this.value = value;
      }

      @Override
      @JsonValue
      public String toString() {
         return String.valueOf(value);
      }
   }

   private TenderTypeEnum tenderType = null;

   /**
    * The type of account
    **/
   public Tender accountType(AccountTypeEnum accountType) {
      this.accountType = accountType;
      return this;
   }

   @ApiModelProperty(value = "The type of account")
   @JsonProperty("accountType")
   public AccountTypeEnum getAccountType() {
      return accountType;
   }

   public void setAccountType(AccountTypeEnum accountType) {
      this.accountType = accountType;
   }

   /**
   **/
   public Tender amount(LedgerAmount amount) {
      this.amount = amount;
      return this;
   }

   @ApiModelProperty(required = true, value = "")
   @JsonProperty("amount")
   public LedgerAmount getAmount() {
      return amount;
   }

   public void setAmount(LedgerAmount amount) {
      this.amount = amount;
   }

   /**
    * A PCI compliant masked card number, with at least the first 6 digits in the clear. Only applicable to card based
    * transactions
    **/
   public Tender cardNumber(String cardNumber) {
      this.cardNumber = cardNumber;
      return this;
   }

   @ApiModelProperty(value = "A PCI compliant masked card number, with at least the first 6 digits in the clear. Only applicable to card based transactions")
   @JsonProperty("cardNumber")
   public String getCardNumber() {
      return cardNumber;
   }

   public void setCardNumber(String cardNumber) {
      this.cardNumber = cardNumber;
   }

   /**
    * A free text reference
    **/
   public Tender reference(String reference) {
      this.reference = reference;
      return this;
   }

   @ApiModelProperty(value = "A free text reference")
   @JsonProperty("reference")
   public String getReference() {
      return reference;
   }

   public void setReference(String reference) {
      this.reference = reference;
   }

   /**
    * The type of tender used
    **/
   public Tender tenderType(TenderTypeEnum tenderType) {
      this.tenderType = tenderType;
      return this;
   }

   @ApiModelProperty(required = true, value = "The type of tender used")
   @JsonProperty("tenderType")
   public TenderTypeEnum getTenderType() {
      return tenderType;
   }

   public void setTenderType(TenderTypeEnum tenderType) {
      this.tenderType = tenderType;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      Tender tender = (Tender) o;
      return Objects.equals(accountType, tender.accountType) && Objects.equals(amount, tender.amount)
            && Objects.equals(cardNumber, tender.cardNumber) && Objects.equals(reference, tender.reference)
            && Objects.equals(tenderType, tender.tenderType);
   }

   @Override
   public int hashCode() {
      return Objects.hash(accountType, amount, cardNumber, reference, tenderType);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class Tender {\n");

      sb.append("    accountType: ").append(toIndentedString(accountType)).append("\n");
      sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
      sb.append("    cardNumber: ").append(toIndentedString(cardNumber)).append("\n");
      sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
      sb.append("    tenderType: ").append(toIndentedString(tenderType)).append("\n");
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
