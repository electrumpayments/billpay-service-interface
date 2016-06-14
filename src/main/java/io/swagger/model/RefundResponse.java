package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Represents a response to a refund request
 **/

@ApiModel(description = "Represents a response to a refund request")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-06-13T18:34:39.493Z")
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
   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   /**
   **/
   public RefundResponse account(Account account) {
      this.account = account;
      return this;
   }

   @ApiModelProperty(required = true, value = "")
   @JsonProperty("account")
   public Account getAccount() {
      return account;
   }

   public void setAccount(Account account) {
      this.account = account;
   }

   /**
   **/
   public RefundResponse customer(Customer customer) {
      this.customer = customer;
      return this;
   }

   @ApiModelProperty(value = "")
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
   **/
   public RefundResponse processor(Institution processor) {
      this.processor = processor;
      return this;
   }

   @ApiModelProperty(value = "")
   @JsonProperty("processor")
   public Institution getProcessor() {
      return processor;
   }

   public void setProcessor(Institution processor) {
      this.processor = processor;
   }

   /**
   **/
   public RefundResponse receiver(Institution receiver) {
      this.receiver = receiver;
      return this;
   }

   @ApiModelProperty(required = true, value = "")
   @JsonProperty("receiver")
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
