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

   protected String policyRef = null;
   protected LocalDate dueDate = null;

   /**
    * A reference number identifying the policy to the processor.
    **/
   public Policy policyRef(String policyRef) {
      this.policyRef = policyRef;
      return this;
   }

   @ApiModelProperty(required = true, value = "A reference number identifying the policy to the processor.")
   @JsonProperty("policyRef")
   @NotNull
   @Length(min = 6, max = 40)
   public String getPolicyRef() {
      return policyRef;
   }

   public void setPolicyRef(String policyRef) {
      this.policyRef = policyRef;
   }

   /**
    * The date by which the next policy payment must be made.
    **/
   public Policy dueDate(LocalDate dueDate) {
      this.dueDate = dueDate;
      return this;
   }

   @ApiModelProperty(value = "The date by which the next policy payment must be made.")
   @JsonProperty("dueDate")
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yy-MM-dd", timezone = "UTC")
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
      return Objects.equals(policyRef, policy.policyRef) && Objects.equals(dueDate, policy.dueDate);
   }

   @Override
   public int hashCode() {
      return Objects.hash(policyRef, dueDate);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class Policy {\n");

      sb.append("    policyRef: ").append(Utils.toIndentedString(policyRef)).append("\n");
      sb.append("    dueDate: ").append(Utils.toIndentedString(dueDate)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
