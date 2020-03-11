package io.electrum.billpay.model;

import java.util.Objects;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.electrum.vas.model.Amounts;
import io.electrum.vas.model.LedgerAmount;
import io.swagger.annotations.ApiModelProperty;

public class BillpayAmounts extends Amounts {

   @ApiModelProperty(value = "The maximum amount a customer is allowed to pay towards an account, policy or some other payment.")
   @JsonProperty("maxPayableAmount")
   @Valid
   protected LedgerAmount maxPayableAmount = null;

   @ApiModelProperty(value = "The minimum amount a customer is allowed to pay towards an account, policy or some other payment.")
   @JsonProperty("minPayableAmount")
   @Valid
   protected LedgerAmount minPayableAmount = null;

   public Amounts maxPayableAmount(LedgerAmount maxPayableAmount) {
      this.maxPayableAmount = maxPayableAmount;
      return this;
   }

   /**
    * The maximum amount a customer is allowed to pay towards an account, policy or some other payment.
    * 
    * @return maxPayableAmount
    **/
   public LedgerAmount getMaxPayableAmount() {
      return maxPayableAmount;
   }

   public void setMaxPayableAmount(LedgerAmount maxPayableAmount) {
      this.maxPayableAmount = maxPayableAmount;
   }

   public Amounts minPayableAmount(LedgerAmount minPayableAmount) {
      this.minPayableAmount = minPayableAmount;
      return this;
   }

   /**
    * The minimum amount a customer is allowed to pay towards an account, policy or some other payment.
    * 
    * @return minPayableAmount
    **/
   public LedgerAmount getMinPayableAmount() {
      return minPayableAmount;
   }

   public void setMinPayableAmount(LedgerAmount minPayableAmount) {
      this.minPayableAmount = minPayableAmount;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      BillpayAmounts tender = (BillpayAmounts) o;
      return Objects.equals(maxPayableAmount, tender.maxPayableAmount)
            && Objects.equals(minPayableAmount, tender.minPayableAmount);
   }

   @Override
   public int hashCode() {
      return Objects.hash(super.hashCode(), maxPayableAmount, minPayableAmount);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class BillpayAmounts {\n");

      sb.append("    maxPayableAmount: ")
            .append(Utils.toIndentedString(maxPayableAmount))
            .append(System.lineSeparator());
      sb.append("    minPayableAmount: ")
            .append(Utils.toIndentedString(minPayableAmount))
            .append(System.lineSeparator());
      sb.append("}").append(System.lineSeparator()).append(super.toString());
      return sb.toString();
   }

}
