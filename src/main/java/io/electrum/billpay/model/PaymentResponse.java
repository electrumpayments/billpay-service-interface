package io.electrum.billpay.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.electrum.vas.model.PaymentMethod;
import io.electrum.vas.model.Tender;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a response to a payment request
 **/
@ApiModel(description = "Represents a response to a payment request")
public class PaymentResponse extends BillpayResponse {

   @ApiModelProperty(required = true, value = "The customer account detail")
   @JsonProperty("account")
   @NotNull
   @Valid
   protected Account account = null;

   @ApiModelProperty(required = false, value = "Contains the tenders for the payment response if available")
   @JsonProperty("tenders")
   private List<Tender> tenders = new ArrayList<>();

   @ApiModelProperty(required = false, value = "Contains the payment method for the payment response if available")
   @JsonProperty("paymentMethods")
   private List<PaymentMethod> paymentMethods = new ArrayList<>();

   @ApiModelProperty(required = false, value = "Contains the information about the bill issuer")
   @JsonProperty("biller")
   @Valid
   private Biller biller = null;

   /**
    * The customer account detail
    **/
   public BillpayResponse account(Account account) {
      this.account = account;
      return this;
   }

   public Account getAccount() {
      return account;
   }

   public void setAccount(Account account) {
      this.account = account;
   }

   public PaymentResponse tender(List<Tender> tenders) {
      this.tenders = tenders;
      return this;
   }

   public List<Tender> getTenders() {
      return tenders;
   }

   public void setTenders(List<Tender> tenders) {
      this.tenders = tenders;
   }

   public PaymentResponse paymentMethods(List<PaymentMethod> paymentMethods) {
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
    * Biller
    **/
   public PaymentResponse biller(Biller biller) {
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
      return new StringBuilder()
              .append("PaymentResponse{").append(System.lineSeparator())
              .append("    account: ").append(Utils.toIndentedString(account)).append(System.lineSeparator())
              .append("    tenders: ").append(Utils.toIndentedString(tenders)).append(System.lineSeparator())
              .append("    paymentMethods: ").append(Utils.toIndentedString(paymentMethods)).append(System.lineSeparator())
              .append("    customer: ").append(Utils.toIndentedString(customer)).append(System.lineSeparator())
              .append("    amounts: ").append(Utils.toIndentedString(amounts)).append(System.lineSeparator())
              .append("    slipData: ").append(Utils.toIndentedString(slipData)).append(System.lineSeparator())
              .append("    partPaymentAllowed: ").append(Utils.toIndentedString(partPaymentAllowed)).append(System.lineSeparator())
              .append("    overPaymentAllowed: ").append(Utils.toIndentedString(overPaymentAllowed)).append(System.lineSeparator())
              .append("    id: ").append(Utils.toIndentedString(id)).append(System.lineSeparator())
              .append("    time: ").append(Utils.toIndentedString(time)).append(System.lineSeparator())
              .append("    originator: ").append(Utils.toIndentedString(originator)).append(System.lineSeparator())
              .append("    client: ").append(Utils.toIndentedString(client)).append(System.lineSeparator())
              .append("    settlementEntity: ").append(Utils.toIndentedString(settlementEntity)).append(System.lineSeparator())
              .append("    receiver: ").append(Utils.toIndentedString(receiver)).append(System.lineSeparator())
              .append("    thirdPartyIdentifiers: ").append(Utils.toIndentedString(thirdPartyIdentifiers)).append(System.lineSeparator())
              .append("    slipData: ").append(Utils.toIndentedString(slipData)).append(System.lineSeparator())
              .append("    basketRef: ").append(Utils.toIndentedString(basketRef)).append(System.lineSeparator())
              .append("    tranType: ").append(Utils.toIndentedString(tranType)).append(System.lineSeparator())
              .append("    srcAccType: ").append(Utils.toIndentedString(srcAccType)).append(System.lineSeparator())
              .append("    destAccType: ").append(Utils.toIndentedString(destAccType)).append(System.lineSeparator())
              .append("    biller: ").append(Utils.toIndentedString(biller)).append(System.lineSeparator())
            .append("}")
              .toString();
   }
}
