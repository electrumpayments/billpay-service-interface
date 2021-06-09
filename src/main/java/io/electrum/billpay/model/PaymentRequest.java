package io.electrum.billpay.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.JsonUtil;
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

   @ApiModelProperty(required = true, value = "A reference number identifying the bill payments processor, bill issuer, and customer")
   @JsonProperty("accountRef")
   @NotNull
   @Length(min = 6, max = 40)
   private String accountRef = null;

   @ApiModelProperty(required = true, value = "Contains the payment amount.", dataType = "io.electrum.billpay.model.BillpayAmounts")
   @JsonProperty("amounts")
   @NotNull
   @Valid
   private BillpayAmounts amounts = null;

   @ApiModelProperty(required = false, value = "Contains the tenders for the payment request if available")
   @JsonProperty("tenders")
   private List<Tender> tenders = new ArrayList<>();

   @ApiModelProperty(required = false, value = "Contains the payment method for the payment request if available")
   @JsonProperty("paymentMethods")
   private List<PaymentMethod> paymentMethods = new ArrayList<>();

   @ApiModelProperty(value = "Customer detail")
   @JsonProperty("customer")
   @Valid
   private Customer customer = null;

   @ApiModelProperty(required = false, value = "Contains the information about the bill issuer")
   @JsonProperty("biller")
   @Valid
   private Biller biller = null;

   /**
    * A reference number identifying the bill payments processor, bill issuer, and customer
    **/
   public PaymentRequest accountRef(String accountRef) {
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
    * Contains the payment amount.
    * 
    * @since v4.8.0
    **/
   public PaymentRequest amounts(BillpayAmounts amounts) {
      this.amounts = amounts;
      return this;
   }

   /**
    * Contains the payment amount.
    * 
    * @deprecated - Use {@link #amounts(BillpayAmounts)} instead.
    **/
   @Deprecated
   @JsonIgnore
   @ApiModelProperty(access = "overloaded-method")
   public PaymentRequest amounts(Amounts amounts) {
      try {
         this.amounts = JsonUtil.deserialize(JsonUtil.serialize(amounts, Amounts.class), BillpayAmounts.class);
         return this;
      } catch (IOException ioe) {
         throw new RuntimeException(ioe);
      }
   }

   public <T extends Amounts> T getAmounts() {
      return (T) amounts;
   }

   /**
    * @since v4.8.0
    * @param amounts
    */
   public void setAmounts(BillpayAmounts amounts) {
      this.amounts = amounts;
   }

   /**
    * 
    * @param amounts
    * @deprecated - Use {@link #setAmounts(BillpayAmounts)} instead.
    */
   @Deprecated
   @JsonIgnore
   @ApiModelProperty(access = "overloaded-method")
   public void setAmounts(Amounts amounts) {
      try {
         this.amounts = JsonUtil.deserialize(JsonUtil.serialize(amounts, Amounts.class), BillpayAmounts.class);
      } catch (IOException ioe) {
         throw new RuntimeException(ioe);
      }
   }

   public PaymentRequest tender(List<Tender> tenders) {
      this.tenders = tenders;
      return this;
   }

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

   public List<PaymentMethod> getPaymentMethods() {
      return paymentMethods;
   }

   public void setPaymentMethods(List<PaymentMethod> paymentMethods) {
      this.paymentMethods = paymentMethods;
   }

   /**
    * Customer detail
    **/
   public PaymentRequest customer(Customer customer) {
      this.customer = customer;
      return this;
   }

   public Customer getCustomer() {
      return customer;
   }

   public void setCustomer(Customer customer) {
      this.customer = customer;
   }

   /**
    * Biller
    **/
   public PaymentRequest biller(Biller biller) {
      this.biller = biller;
      return this;
   }

   public Biller getBiller() {
      return biller;
   }

   public void setBiller(Biller biller) {
      this.biller = biller;
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
            .append("    biller: ")
            .append(Utils.toIndentedString(biller))
            .append(System.lineSeparator())
            .append("}")
            .append(System.lineSeparator())
            .append(super.toString())
            .toString();
   }
}
