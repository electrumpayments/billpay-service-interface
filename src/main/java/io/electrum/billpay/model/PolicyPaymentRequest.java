package io.electrum.billpay.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import io.electrum.vas.interfaces.HasPaymentMethods;
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
 * Represents a request to perform a payment of a traffic fine.
 **/
@ApiModel(description = "Represents a request to perform a payment of a traffic fine.")
public class PolicyPaymentRequest extends Transaction implements HasPaymentMethods {

   @ApiModelProperty(required = true, value = "A reference number identifying the policy to the service provider.")
   @JsonProperty("policyNumber")
   @NotNull
   @Length(min = 6, max = 40)
   private String policyNumber = null;

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

   /**
    * A reference number identifying the policy to the service provider.
    **/
   public PolicyPaymentRequest policyNumber(String policyNumber) {
      this.policyNumber = policyNumber;
      return this;
   }

   public String getPolicyNumber() {
      return policyNumber;
   }

   public void setPolicyNumber(String policyNumber) {
      this.policyNumber = policyNumber;
   }

   /**
    * Contains the payment amount.
    * 
    * @since v4.8.0
    **/
   public PolicyPaymentRequest amounts(BillpayAmounts amounts) {
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
   public PolicyPaymentRequest amounts(Amounts amounts) {
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

   public PolicyPaymentRequest tender(List<Tender> tenders) {
      this.tenders = tenders;
      return this;
   }

   public List<Tender> getTenders() {
      return tenders;
   }

   public void setTenders(List<Tender> tenders) {
      this.tenders = tenders;
   }

   public PolicyPaymentRequest paymentMethods(List<PaymentMethod> paymentMethods) {
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
   public PolicyPaymentRequest customer(Customer customer) {
      this.customer = customer;
      return this;
   }

   public Customer getCustomer() {
      return customer;
   }

   public void setCustomer(Customer customer) {
      this.customer = customer;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      PolicyPaymentRequest tender = (PolicyPaymentRequest) o;
      return Objects.equals(policyNumber, tender.policyNumber) && Objects.equals(amounts, tender.amounts);
   }

   @Override
   public int hashCode() {
      return Objects.hash(super.hashCode(), policyNumber, amounts);
   }

   @Override
   public String toString() {
      return new StringBuilder().append("class PolicyPaymentRequest {")
            .append(System.lineSeparator())
            .append("    policyNumber: ")
            .append(Utils.toIndentedString(policyNumber))
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
            .append(System.lineSeparator())
            .append(super.toString())
            .toString();
   }
}
