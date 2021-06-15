package io.electrum.billpay.model;

import io.electrum.vas.JsonUtil;
import io.electrum.vas.model.Amounts;
import io.electrum.vas.model.PaymentMethod;
import io.electrum.vas.model.Tender;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a request to perform a payment of a traffic fine.
 **/
@ApiModel(description = "Represents a request to perform a payment of a traffic fine.")
public class TrafficFinePaymentRequest extends BillpayRequest {

   @ApiModelProperty(required = true, value = "A reference number identifying the traffic fine to the service provider.")
   @JsonProperty("noticeNumber")
   @NotNull
   @Length(min = 6, max = 40)
   private String noticeNumber = null;

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
    * A reference number identifying the traffic fine to the service provider.
    **/
   public TrafficFinePaymentRequest noticeNumber(String noticeNumber) {
      this.noticeNumber = noticeNumber;
      return this;
   }

   public String getNoticeNumber() {
      return noticeNumber;
   }

   public void setNoticeNumber(String noticeNumber) {
      this.noticeNumber = noticeNumber;
   }

   /**
    * Contains the payment amount.
    * 
    * @since v4.8.0
    **/
   public TrafficFinePaymentRequest amounts(BillpayAmounts amounts) {
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
   public TrafficFinePaymentRequest amounts(Amounts amounts) {
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

   public TrafficFinePaymentRequest tender(List<Tender> tenders) {
      this.tenders = tenders;
      return this;
   }

   public List<Tender> getTenders() {
      return tenders;
   }

   public void setTenders(List<Tender> tenders) {
      this.tenders = tenders;
   }

   public TrafficFinePaymentRequest paymentMethods(List<PaymentMethod> paymentMethods) {
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
   public TrafficFinePaymentRequest customer(Customer customer) {
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
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      if (!super.equals(o))
         return false;
      TrafficFinePaymentRequest that = (TrafficFinePaymentRequest) o;
      return Objects.equals(getNoticeNumber(), that.getNoticeNumber())
            && Objects.equals(getAmounts(), that.getAmounts()) && Objects.equals(getTenders(), that.getTenders())
            && Objects.equals(getPaymentMethods(), that.getPaymentMethods())
            && Objects.equals(getCustomer(), that.getCustomer());
   }

   @Override
   public int hashCode() {
      return Objects
            .hash(super.hashCode(), getNoticeNumber(), getAmounts(), getTenders(), getPaymentMethods(), getCustomer());
   }

   @Override
   public String toString() {
      return "TrafficFinePaymentRequest{" + "noticeNumber='" + noticeNumber + '\'' + ", amounts=" + amounts
            + ", tenders=" + tenders + ", paymentMethods=" + paymentMethods + ", customer=" + customer + "} "
            + super.toString();
   }
}
