package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Represents a response to a payment request
 **/

@ApiModel(description = "Represents a response to a payment request")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-06-13T18:34:39.493Z")
public class PaymentResponse {

   private String id = null;
   private Account account = null;
   private Customer customer = null;
   private Object linkData = null;
   private Institution processor = null;
   private Institution receiver = null;
   private ResponseDetail responseDetail = null;
   private SlipData slipData = null;

   /**
    * An identifier that uniquely identifies the payment
    **/
   public PaymentResponse id(String id) {
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
   public PaymentResponse account(Account account) {
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
   public PaymentResponse customer(Customer customer) {
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
    * This object may be used by the server to link a payment to a payment confirmation or cancellation, and should be
    * provided unaltered by clients in corresponding requests
    **/
   public PaymentResponse linkData(Object linkData) {
      this.linkData = linkData;
      return this;
   }

   @ApiModelProperty(value = "This object may be used by the server to link a payment to a payment confirmation or cancellation, and should be provided unaltered by clients in corresponding requests")
   @JsonProperty("linkData")
   public Object getLinkData() {
      return linkData;
   }

   public void setLinkData(Object linkData) {
      this.linkData = linkData;
   }

   /**
   **/
   public PaymentResponse processor(Institution processor) {
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
   public PaymentResponse receiver(Institution receiver) {
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

   /**
   **/
   public PaymentResponse responseDetail(ResponseDetail responseDetail) {
      this.responseDetail = responseDetail;
      return this;
   }

   @ApiModelProperty(required = true, value = "")
   @JsonProperty("responseDetail")
   public ResponseDetail getResponseDetail() {
      return responseDetail;
   }

   public void setResponseDetail(ResponseDetail responseDetail) {
      this.responseDetail = responseDetail;
   }

   /**
   **/
   public PaymentResponse slipData(SlipData slipData) {
      this.slipData = slipData;
      return this;
   }

   @ApiModelProperty(required = true, value = "")
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
      PaymentResponse paymentResponse = (PaymentResponse) o;
      return Objects.equals(id, paymentResponse.id) && Objects.equals(account, paymentResponse.account)
            && Objects.equals(customer, paymentResponse.customer) && Objects.equals(linkData, paymentResponse.linkData)
            && Objects.equals(processor, paymentResponse.processor)
            && Objects.equals(receiver, paymentResponse.receiver)
            && Objects.equals(responseDetail, paymentResponse.responseDetail)
            && Objects.equals(slipData, paymentResponse.slipData);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, account, customer, linkData, processor, receiver, responseDetail, slipData);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class PaymentResponse {\n");

      sb.append("    id: ").append(toIndentedString(id)).append("\n");
      sb.append("    account: ").append(toIndentedString(account)).append("\n");
      sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
      sb.append("    linkData: ").append(toIndentedString(linkData)).append("\n");
      sb.append("    processor: ").append(toIndentedString(processor)).append("\n");
      sb.append("    receiver: ").append(toIndentedString(receiver)).append("\n");
      sb.append("    responseDetail: ").append(toIndentedString(responseDetail)).append("\n");
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
