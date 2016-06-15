package io.electrum.billpay.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.Objects;

/**
 * A MessageId object uniquely identifies a request. It is very important that this field is constructed carefully,
 * since a mistake here may lead to hard to find duplicate messages that typically only show up in a busy production
 * environment
 **/
@ApiModel(description = "A MessageId object uniquely identifies a request. It is very important that this field is constructed carefully, since a mistake here may lead to hard to find duplicate messages that typically only show up in a busy production environment")
public class MessageId {

   private String counter = null;
   private String institutionId = null;
   private String senderId = null;
   private Date time = null;

   /**
    * An incrementing counter. Each seperate request must be issued a new counter value. If the counter reaches 999999,
    * it must wrap back to 000000. Upon application startup, the starting value for the counter should be randomly
    * assigned rather than always starting from 000000. For transactions initiated by a physical card entry or
    * point-of-sale device, this value is typically referred to as a System Trace Audit Number (STAN) and there will be
    * one counter per device. For transactions not initiated by a physical device, each message should have a distinct
    * counter value. Typically this is achieved by assigning each entity sending transactions a unique osenderId.
    * Alternatively, effort must be taken by the client to synchronize senders so that a unique senderId, time, and
    * counter combination is guaranteed. It is not necessary for messages to be delivered in the same order as in which
    * counter values where assigned
    **/
   public MessageId counter(String counter) {
      this.counter = counter;
      return this;
   }

   @ApiModelProperty(required = true, value = "An incrementing counter. Each seperate request must be issued a new counter value. If the counter reaches 999999, it must wrap back to 000000. Upon application startup, the starting value for the counter should be randomly assigned rather than always starting from 000000. For transactions initiated by a physical card entry or point-of-sale device, this value is typically referred to as a System Trace Audit Number (STAN) and there will be one counter per device. For transactions not initiated by a physical device, each message should have a distinct counter value. Typically this is achieved by assigning each entity sending transactions a unique osenderId. Alternatively, effort must be taken by the client to synchronize senders so that a unique senderId, time, and counter combination is guaranteed. It is not necessary for messages to be delivered in the same order as in which counter values where assigned")
   @JsonProperty("counter")
   @NotNull
   @Pattern(regexp = "[0-9]{6}")
   public String getCounter() {
      return counter;
   }

   public void setCounter(String counter) {
      this.counter = counter;
   }

   /**
    * The id of the instituation originating the request, as issued by Electrum
    **/
   public MessageId institutionId(String institutionId) {
      this.institutionId = institutionId;
      return this;
   }

   @ApiModelProperty(required = true, value = "The id of the instituation originating the request, as issued by Electrum")
   @JsonProperty("institutionId")
   @NotNull
   @Pattern(regexp = "[0-9]{1,11}")
   public String getInstitutionId() {
      return institutionId;
   }

   public void setInstitutionId(String institutionId) {
      this.institutionId = institutionId;
   }

   /**
    * The id that uniquely identifies each device or system in a sender institution capabile of sending requests. For
    * transactions initiated from physical card entry or point-of-sale devices, this is the terminal id
    **/
   public MessageId senderId(String senderId) {
      this.senderId = senderId;
      return this;
   }

   @ApiModelProperty(required = true, value = "The id that uniquely identifies each device or system in a sender institution capabile of sending requests. For transactions initiated from physical card entry or point-of-sale devices, this is the terminal id")
   @JsonProperty("senderId")
   @NotNull
   @Pattern(regexp = "[a-zA-Z0-9]{8}")
   public String getSenderId() {
      return senderId;
   }

   public void setSenderId(String senderId) {
      this.senderId = senderId;
   }

   /**
    * The date and time of the request in UTC, as recorded by the sender. The format shall be as defined for date-time
    * in [RFC 3339 section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). It is recommended that the optional
    * time-secfrac be included up to millisecond precision
    **/
   public MessageId time(Date time) {
      this.time = time;
      return this;
   }

   @ApiModelProperty(required = true, value = "The date and time of the request as recorded by the sender. The format shall be as defined for date-time in [RFC 3339 section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). It is recommended that the optional time-secfrac be included up to millisecond precision")
   @JsonProperty("time")
   @NotNull
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX", timezone = "UTC")
   public Date getTime() {
      return time;
   }

   public void setTime(Date time) {
      this.time = time;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      MessageId messageId = (MessageId) o;
      return Objects.equals(counter, messageId.counter) && Objects.equals(institutionId, messageId.institutionId)
            && Objects.equals(senderId, messageId.senderId) && Objects.equals(time, messageId.time);
   }

   @Override
   public int hashCode() {
      return Objects.hash(counter, institutionId, senderId, time);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class MessageId {\n");

      sb.append("    counter: ").append(toIndentedString(counter)).append("\n");
      sb.append("    institutionId: ").append(toIndentedString(institutionId)).append("\n");
      sb.append("    senderId: ").append(toIndentedString(senderId)).append("\n");
      sb.append("    time: ").append(toIndentedString(time)).append("\n");
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
