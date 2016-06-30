package io.electrum.billpay.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents the data required to confirm a previously created payment
 **/
@ApiModel(description = "Represents the data required to confirm a previously created payment")
public class PaymentConfirmation extends BasicAdvice {

   private List<Tender> tenders = new ArrayList<>();

   /**
    * An array of tenders used to pay for the transaction
    **/
   public PaymentConfirmation tenders(List<Tender> tenders) {
      this.tenders = tenders;
      return this;
   }

   @ApiModelProperty(required = true, value = "An array of tenders used to pay for the transaction")
   @JsonProperty("tenders")
   @NotEmpty
   public List<Tender> getTenders() {
      return tenders;
   }

   public void setTenders(List<Tender> tenders) {
      this.tenders = tenders;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      PaymentConfirmation paymentConfirmation = (PaymentConfirmation) o;
      return Objects.equals(linkData, paymentConfirmation.linkData)
            && Objects.equals(messageId, paymentConfirmation.messageId)
            && Objects.equals(tenders, paymentConfirmation.tenders);
   }

   @Override
   public int hashCode() {
      return Objects.hash(linkData, messageId, tenders);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class PaymentConfirmation {\n");

      sb.append("    linkData: ").append(toIndentedString(linkData)).append("\n");
      sb.append("    messageId: ").append(toIndentedString(messageId)).append("\n");
      sb.append("    tenders: ").append(toIndentedString(tenders)).append("\n");
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
