package io.electrum.billpay.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.joda.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Represents the status of a customer policy
 **/

@ApiModel(description = "Represents the status of a customer policy")
public class Policy {

   @ApiModelProperty(required = true, value = "A reference number identifying the policy to the processor.")
   @JsonProperty("policyNumber")
   @NotNull
   @Length(min = 6, max = 40)
   protected String policyNumber = null;

   @ApiModelProperty(value = "The date by which the next policy payment must be made in the format yyyy-MM-dd.")
   @JsonProperty("dueDate")
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
   protected LocalDate dueDate = null;

   /**
    * A reference number identifying the policy to the processor.
    **/
   public Policy policyNumber(String policyNumber) {
      this.policyNumber = policyNumber;
      return this;
   }

   public String getPolicyNumber() {
      return policyNumber;
   }

   public void setPolicyNumber(String policyNumber) {
      this.policyNumber = policyNumber;
   }

   /**
    * The date by which the next policy payment must be made.
    **/
   public Policy dueDate(LocalDate dueDate) {
      this.dueDate = dueDate;
      return this;
   }

   public LocalDate getDueDate() {
      return dueDate;
   }

   public void setDueDate(LocalDate dueDate) {
      this.dueDate = dueDate;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      Policy policy = (Policy) o;
      return Objects.equals(policyNumber, policy.policyNumber) && Objects.equals(dueDate, policy.dueDate);
   }

   @Override
   public int hashCode() {
      return Objects.hash(policyNumber, dueDate);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class Policy {\n");

      sb.append("    policyNumber: ").append(Utils.toIndentedString(policyNumber)).append("\n");
      sb.append("    dueDate: ").append(Utils.toIndentedString(dueDate)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
