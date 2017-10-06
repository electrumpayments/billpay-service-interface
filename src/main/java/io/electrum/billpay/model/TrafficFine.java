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
 * Represents the status of a traffic fine
 **/

@ApiModel(description = "Represents the status of a traffic fine")
public class TrafficFine {

   protected String noticeNumber = null;
   protected LocalDate dueDate = null;

   /**
    * A reference number identifying the traffic fine to the processor's system.
    **/
   public TrafficFine noticeNumber(String noticeNumber) {
      this.noticeNumber = noticeNumber;
      return this;
   }

   @ApiModelProperty(required = true, value = "A reference number identifying the traffic fine to the processor's system.")
   @JsonProperty("noticeNumber")
   @NotNull
   @Length(min = 6, max = 40)
   public String getNoticeNumber() {
      return noticeNumber;
   }

   public void setNoticeNumber(String noticeNumber) {
      this.noticeNumber = noticeNumber;
   }

   /**
    * The date by which the traffic fine should be paid.
    **/
   public TrafficFine dueDate(LocalDate dueDate) {
      this.dueDate = dueDate;
      return this;
   }

   @ApiModelProperty(value = "The date by which the traffic fine should be paid in the format yyyy-MM-dd.")
   @JsonProperty("dueDate")
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
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
      TrafficFine trafficFine = (TrafficFine) o;
      return Objects.equals(noticeNumber, trafficFine.noticeNumber) && Objects.equals(dueDate, trafficFine.dueDate);
   }

   @Override
   public int hashCode() {
      return Objects.hash(noticeNumber, dueDate);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class TrafficFine {\n");

      sb.append("    noticeNumber: ").append(Utils.toIndentedString(noticeNumber)).append("\n");
      sb.append("    dueDate: ").append(Utils.toIndentedString(dueDate)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
