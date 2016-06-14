package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * The data resulting from an account lookup request
 **/
@ApiModel(description = "The data resulting from an account lookup request")
public class AccountLookupResponse {

   private Account account = null;
   private Customer customer = null;
   private Institution processor = null;
   private Institution receiver = null;
   private SlipData slipData = null;

   /**
    * The customer account detail
    **/
   public AccountLookupResponse account(Account account) {
      this.account = account;
      return this;
   }

   @ApiModelProperty(required = true, value = "The customer account detail")
   @JsonProperty("account")
   @NotNull
   public Account getAccount() {
      return account;
   }

   public void setAccount(Account account) {
      this.account = account;
   }

   /**
    * Customer detail
    **/
   public AccountLookupResponse customer(Customer customer) {
      this.customer = customer;
      return this;
   }

   @ApiModelProperty(value = "Custoemr detail")
   @JsonProperty("customer")
   public Customer getCustomer() {
      return customer;
   }

   public void setCustomer(Customer customer) {
      this.customer = customer;
   }

   /**
    * Detail regarding the institution that processed the message
    **/
   public AccountLookupResponse processor(Institution processor) {
      this.processor = processor;
      return this;
   }

   @ApiModelProperty(value = "Detail regarding the institution that processed the message")
   @JsonProperty("processor")
   public Institution getProcessor() {
      return processor;
   }

   public void setProcessor(Institution processor) {
      this.processor = processor;
   }

   /**
    * Detail regarding the bill issuing institution
    **/
   public AccountLookupResponse receiver(Institution receiver) {
      this.receiver = receiver;
      return this;
   }

   @ApiModelProperty(required = true, value = "Detail regarding the bill issuing institution")
   @JsonProperty("receiver")
   @NotNull
   public Institution getReceiver() {
      return receiver;
   }

   public void setReceiver(Institution receiver) {
      this.receiver = receiver;
   }

   /**
    * Data that should be printed on the customer receipt
    **/
   public AccountLookupResponse slipData(SlipData slipData) {
      this.slipData = slipData;
      return this;
   }

   @ApiModelProperty(value = "Data that should be printed on the customer receipt")
   @JsonProperty("slipData")
   public SlipData getSlipData() {
      return slipData;
   }

   public void setSlipData(SlipData slipData) {
      this.slipData = slipData;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      AccountLookupResponse accountLookupResponse = (AccountLookupResponse) o;
      return Objects.equals(account, accountLookupResponse.account)
            && Objects.equals(customer, accountLookupResponse.customer)
            && Objects.equals(processor, accountLookupResponse.processor)
            && Objects.equals(receiver, accountLookupResponse.receiver)
            && Objects.equals(slipData, accountLookupResponse.slipData);
   }

   @Override
   public int hashCode() {
      return Objects.hash(account, customer, processor, receiver, slipData);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class AccountLookupResponse {\n");

      sb.append("    account: ").append(toIndentedString(account)).append("\n");
      sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
      sb.append("    processor: ").append(toIndentedString(processor)).append("\n");
      sb.append("    receiver: ").append(toIndentedString(receiver)).append("\n");
      sb.append("    slipData: ").append(toIndentedString(slipData)).append("\n");
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
