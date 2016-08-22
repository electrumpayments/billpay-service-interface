package io.electrum.billpay.model;

import io.electrum.vas.Utils;
import io.electrum.vas.model.ThirdPartyIdentifier;
import io.electrum.vas.model.Transaction;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The data required to request account info
 **/
@ApiModel(description = "The data required to request account info")
public class AccountLookupRequest extends Transaction {

   private String accountRef = null;

   /**
    * A reference number identifying the bill payments processor, bill issuer, and customer
    **/
   public AccountLookupRequest accountRef(String accountRef) {
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

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class AccountLookupRequest {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    accountRef: ").append(Utils.toIndentedString(accountRef)).append("\n");
      sb.append("    time: ").append(Utils.toIndentedString(time)).append("\n");
      sb.append("    originator: ").append(Utils.toIndentedString(originator)).append("\n");
      sb.append("    client: ").append(Utils.toIndentedString(client)).append("\n");
      sb.append("    settlementEntity: ").append(Utils.toIndentedString(settlementEntity)).append("\n");
      sb.append("    receiver: ").append(Utils.toIndentedString(receiver)).append("\n");
      sb.append("    transactionIdentifiers: [");
      for (ThirdPartyIdentifier thirdPartyIdentifier : thirdPartyIdentifiers) {
         sb.append(Utils.toIndentedString("\n    ")).append(Utils.toIndentedString(thirdPartyIdentifier));
      }
      sb.append("    ]\n");
      sb.append("}");
      return sb.toString();
   }
}
