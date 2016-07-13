package io.electrum.billpay.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.electrum.vas.Utils;
import io.electrum.vas.model.BasicRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * The data required to request account info
 **/
@ApiModel(description = "The data required to request account info")
public class AccountLookupRequest extends BasicRequest {

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
      sb.append("    time: ").append(Utils.toIndentedString(time)).append("\n");
      sb.append("    sender: ").append(Utils.toIndentedString(sender)).append("\n");
      sb.append("    accountRef: ").append(Utils.toIndentedString(accountRef)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
