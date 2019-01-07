package io.electrum.billpay.model;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.internal.Nullable;

import io.electrum.vas.Utils;
import io.electrum.vas.model.Amounts;
import io.electrum.vas.model.PaymentMethod;
import io.electrum.vas.model.Tender;
import io.electrum.vas.model.Transaction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Represents a request to perform a payment
 **/
@ApiModel(description = "Represents a request to perform a payment")
public class PaymentRequest extends Transaction {

   private String accountRef = null;
   private Amounts amounts = null;
   private List<Tender> tenders = null;
   private List<PaymentMethod> paymentMethods = null;
   private Customer customer = null;

   /**
    * A reference number identifying the bill payments processor, bill issuer, and customer
    **/
   public PaymentRequest accountRef(String accountRef) {
      this.accountRef = accountRef;
      return this;
   }

   @ApiModelProperty(required = true, value = "A reference number identifying the bill payments processor, bill issuer, and customer")
   @JsonProperty("accountRef")
   @NotNull
   @Length(min = 6, max = 40)
   public String getAccountRef() {
      return accountRef;
   }

   public void setAccountRef(String accountRef) {
      this.accountRef = accountRef;
   }

   /**
    * Contains the payment amount.
    **/
   public PaymentRequest amounts(Amounts amounts) {
      this.amounts = amounts;
      return this;
   }

   @ApiModelProperty(required = true, value = "Contains the payment amount.")
   @JsonProperty("amounts")
   @NotNull
   @Valid
   public Amounts getAmounts() {
      return amounts;
   }

   public void setAmounts(Amounts amounts) {
      this.amounts = amounts;
   }

   public PaymentRequest tender(List<Tender> tenders) {
      this.tenders = tenders;
      return this;
   }

   @ApiModelProperty(required = false, value = "Contains the tenders for the payment request if available")
   @JsonProperty("tenders")
   @Nullable
   public List<Tender> getTenders() {
      return tenders;
   }

   public void setTenders(List<Tender> tenders) {
      this.tenders = tenders;
   }

   public PaymentRequest paymentMethods(List<PaymentMethod> paymentMethods) {
      this.paymentMethods = paymentMethods;
      return this;
   }

   @ApiModelProperty(required = false, value = "Contains the payment method for the payment request if available")
   @JsonProperty("paymentMethods")
   @Nullable
   public List<PaymentMethod> getPaymentMethods() {
      return paymentMethods;
   }

   public void setPaymentMethods(List<PaymentMethod> paymentMethods) {
      this.paymentMethods = paymentMethods;
   }

   @Override
   public String toString() {
      return new StringBuilder().append("PaymentRequest{")
            .append(System.lineSeparator())
            .append("    accountRef: ")
            .append(Utils.toIndentedString(accountRef))
            .append(System.lineSeparator())
            .append("    amounts: ")
            .append(Utils.toIndentedString(amounts))
            .append(System.lineSeparator())
            .append("    tenders: ")
            .append(Utils.toIndentedString(tenders))
            .append(System.lineSeparator())
            .append("    paymentMethods: ")
            .append(Utils.toIndentedString(paymentMethods))
            .append(System.lineSeparator())
            .append("    customer: ")
            .append(Utils.toIndentedString(customer))
            .append(System.lineSeparator())
            .append("}")
            .toString();
   }
}
