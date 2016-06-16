package io.electrum.billpay.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Objects;

/**
 * Represents a response to a refund request
 **/
@ApiModel(description = "Represents a response to a refund request")
public class RefundResponse {

   private String id = null;
   private Account account = null;
   private Customer customer = null;
   private Object linkData = null;
   private Institution processor = null;
   private Institution receiver = null;

   /**
    * An identifier that uniquely identifies the payment
    **/
   public RefundResponse id(String id) {
      this.id = id;
      return this;
   }

   @ApiModelProperty(required = true, value = "An identifier that uniquely identifies the payment")
   @JsonProperty("id")
   @NotNull
   @Pattern(regexp = "[A-Za-z0-9._~-]{1,40}")
   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   /**
    * The customer account detail
    **/
   public RefundResponse account(Account account) {
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
   public RefundResponse customer(Customer customer) {
      this.customer = customer;
      return this;
   }

   @ApiModelProperty
   @JsonProperty("customer")
   public Customer getCustomer() {
      return customer;
   }

   public void setCustomer(Customer customer) {
      this.customer = customer;
   }

   /**
    * This object may be used by the server to link a refund to a refund confirmation or cancellation, and should be
    * provided unaltered by clients in corresponding requests
    **/
   public RefundResponse linkData(Object linkData) {
      this.linkData = linkData;
      return this;
   }

   @ApiModelProperty(value = "This object may be used by the server to link a refund to a refund confirmation or cancellation, and should be provided unaltered by clients in corresponding requests")
   @JsonProperty("linkData")
   public Object getLinkData() {
      return linkData;
   }

   public void setLinkData(Object linkData) {
      this.linkData = linkData;
   }

   /**
    * Detail regarding the institution that processed the messag
    **/
   public RefundResponse processor(Institution processor) {
      this.processor = processor;
      return this;
   }

   @ApiModelProperty
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
   public RefundResponse receiver(Institution receiver) {
      this.receiver = receiver;
      return this;
   }

   @ApiModelProperty(required = true)
   @JsonProperty("receiver")
   @NotNull
   public Institution getReceiver() {
      return receiver;
   }

   public void setReceiver(Institution receiver) {
      this.receiver = receiver;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      RefundResponse refundResponse = (RefundResponse) o;
      return Objects.equals(id, refundResponse.id) && Objects.equals(account, refundResponse.account)
            && Objects.equals(customer, refundResponse.customer) && Objects.equals(linkData, refundResponse.linkData)
            && Objects.equals(processor, refundResponse.processor) && Objects.equals(receiver, refundResponse.receiver);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, account, customer, linkData, processor, receiver);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class RefundResponse {\n");

      sb.append("    id: ").append(toIndentedString(id)).append("\n");
      sb.append("    account: ").append(toIndentedString(account)).append("\n");
      sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
      sb.append("    linkData: ").append(toIndentedString(linkData)).append("\n");
      sb.append("    processor: ").append(toIndentedString(processor)).append("\n");
      sb.append("    receiver: ").append(toIndentedString(receiver)).append("\n");
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
