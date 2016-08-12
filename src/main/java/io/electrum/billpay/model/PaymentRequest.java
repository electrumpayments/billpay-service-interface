package io.electrum.billpay.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.electrum.vas.Utils;
import io.electrum.vas.model.BasicRequest;
import io.electrum.vas.model.LedgerAmount;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Represents a request to perform a payment
 **/
@ApiModel(description = "Represents a request to perform a payment")
public class PaymentRequest extends BasicRequest {

   private String accountRef = null;
   private LedgerAmount requestAmount = null;

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
    * The requested amount
    **/
   public PaymentRequest requestAmount(LedgerAmount requestAmount) {
      this.requestAmount = requestAmount;
      return this;
   }

   @ApiModelProperty(required = true, value = "The cash amount, in minor denomination, paid by the customer to settle the bill")
   @JsonProperty("requestAmount")
   @NotNull
   public LedgerAmount getRequestAmount() {
      return requestAmount;
   }

   public void setRequestAmount(LedgerAmount requestAmount) {
      this.requestAmount = requestAmount;
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class PaymentRequest {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    time: ").append(Utils.toIndentedString(time)).append("\n");
      sb.append("    sender: ").append(Utils.toIndentedString(sender)).append("\n");
      sb.append("    accountRef: ").append(Utils.toIndentedString(accountRef)).append("\n");
      sb.append("    requestAmount: ").append(Utils.toIndentedString(requestAmount)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
