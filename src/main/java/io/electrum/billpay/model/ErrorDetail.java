package io.electrum.billpay.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Represents the outcome of a completed transaction
 **/
@ApiModel(description = "Represents the outcome of a completed transaction")
public class ErrorDetail {

   /**
    * Every failure must be classified into one of the following failure types
    */
   public enum ErrorType {
      DUPLICATE_RECORD("DUPLICATE_RECORD"),
      FORMAT_ERROR("FORMAT_ERROR"),
      FUNCTION_NOT_SUPPORTED("FUNCTION_NOT_SUPPORTED"),
      GENERAL_ERROR("GENERAL_ERROR"),
      INVALID_AMOUNT("INVALID_AMOUNT"),
      ROUTING_ERROR("ROUTING_ERROR"),
      TRANSACTION_NOT_SUPPORTED("TRANSACTION_NOT_SUPPORTED"),
      UNABLE_TO_LOCATE_RECORD("UNABLE_TO_LOCATE_RECORD"),
      UNKNOWN_CUSTOMER_ACCOUNT("UNKNOWN_CUSTOMER_ACCOUNT"),
      UPSTREAM_UNAVAILABLE("UPSTREAM_UNAVAILABLE"),
      ACCOUNT_ALREADY_SETTLED("ACCOUNT_ALREADY_SETTLED"),
      INVALID_PRODUCT("INVALID_PRODUCT"),
      INVALID_MERCHANT("INVALID_MERCHANT"),
      RECEIVER_BLACKLISTED("RECEIVER_BLACKLISTED"),
      LUHN_CHECK_FAILED("LUHN_CHECK_FAILED"),
      BLOCKED_USING_SETTLEMENT_ENTITY("BLOCKED_USING_SETTLEMENT_ENTITY"),
      BELOW_MINIMUM_ALLOWED_AMOUNT("BELOW_MINIMUM_ALLOWED_AMOUNT"),
      ABOVE_MAXIMUM_ALLOWED_AMOUNT("ABOVE_MAXIMUM_ALLOWED_AMOUNT");

      private String value;

      ErrorType(String value) {
         this.value = value;
      }

      @Override
      @JsonValue
      public String toString() {
         return String.valueOf(value);
      }
   }

   /**
    * The following request types are recognised
    */
   public enum RequestType {
      ACCOUNT_LOOKUP_REQUEST("ACCOUNT_LOOKUP_REQUEST"),
      TRAFFIC_FINE_LOOKUP_REQUEST("TRAFFIC_FINE_LOOKUP_REQUEST"),
      POLICY_LOOKUP_REQUEST("POLICY_LOOKUP_REQUEST"),
      PAYMENT_REQUEST("PAYMENT_REQUEST"),
      TRAFFIC_FINE_PAYMENT_REQUEST("TRAFFIC_FINE_PAYMENT_REQUEST"),
      POLICY_PAYMENT_REQUEST("POLICY_PAYMENT_REQUEST"),
      PAYMENT_REVERSAL("PAYMENT_REVERSAL"),
      TRAFFIC_FINE_PAYMENT_REVERSAL("TRAFFIC_FINE_PAYMENT_REVERSAL"),
      PAYMENT_CONFIRMATION("PAYMENT_CONFIRMATION"),
      TRAFFIC_FINE_PAYMENT_CONFIRMATION("TRAFFIC_FINE_PAYMENT_CONFIRMATION"),
      REFUND_REQUEST("REFUND_REQUEST"),
      REFUND_REVERSAL("REFUND_REVERSAL"),
      REFUND_CONFIRMATION("REFUND_CONFIRMATION");

      private String value;

      RequestType(String value) {
         this.value = value;
      }

      @Override
      @JsonValue
      public String toString() {
         return String.valueOf(value);
      }
   }

   @ApiModelProperty(required = true, value = "The type of error that occurred")
   @JsonProperty("errorType")
   @NotNull
   private ErrorType errorType = null;

   @ApiModelProperty(required = true, value = "A short description of the error")
   @JsonProperty("errorMessage")
   @NotNull
   @Length(max = 20)
   private String errorMessage = null;

   @ApiModelProperty(required = true, value = "The type of request being processed when the error occurred. Refer to Release Notes for deprecated values.")
   @JsonProperty("requestType")
   @NotNull
   private RequestType requestType = null;

   @ApiModelProperty(required = true, value = "The UUID of the message for which error occurred.")
   @JsonProperty("id")
   @NotNull
   private String id = null;

   @ApiModelProperty(value = "The UUID of the original request message in the case of an error occurring for an advice message.")
   @JsonProperty("originalId")
   private String originalId = null;

   @ApiModelProperty(value = "A free form detailed description of a particular failure condition may optionally be supplied")
   @JsonProperty("detailMessage")
   private Object detailMessage = null;

   /**
    * The type of error that occurred
    **/
   public ErrorDetail errorType(ErrorType errorType) {
      this.errorType = errorType;
      return this;
   }

   public ErrorType getErrorType() {
      return errorType;
   }

   public void setErrorType(ErrorType errorType) {
      this.errorType = errorType;
   }

   /**
    * A short description of the error
    **/
   public ErrorDetail errorMessage(String errorMessage) {
      this.errorMessage = errorMessage;
      return this;
   }

   public String getErrorMessage() {
      return errorMessage;
   }

   public void setErrorMessage(String errorMessage) {
      this.errorMessage = errorMessage;
   }

   /**
    * The type of request being processed when the error occurred. Refer to Release Notes for deprecated values.
    **/
   public ErrorDetail requestType(RequestType requestType) {
      this.requestType = requestType;
      return this;
   }

   public RequestType getRequestType() {
      return requestType;
   }

   public void setRequestType(RequestType requestType) {
      this.requestType = requestType;
   }

   /**
    * The UUID of the message for which error occurred.
    **/
   public ErrorDetail id(String id) {
      this.id = id;
      return this;
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   /**
    * The UUID of the original request message in the case of an error occurring for an advice message.
    **/
   public ErrorDetail originalId(String originalId) {
      this.originalId = originalId;
      return this;
   }

   public String getOriginalId() {
      return originalId;
   }

   public void setOriginalId(String originalId) {
      this.originalId = originalId;
   }

   /**
    * A free form detailed description of a particular failure condition may optionally be supplied
    **/
   public ErrorDetail detailMessage(Object detailMessage) {
      this.detailMessage = detailMessage;
      return this;
   }

   public Object getDetailMessage() {
      return detailMessage;
   }

   public void setDetailMessage(Object detailMessage) {
      this.detailMessage = detailMessage;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      ErrorDetail errorDetail = (ErrorDetail) o;
      return Objects.equals(errorType, errorDetail.errorType) && Objects.equals(errorMessage, errorDetail.errorMessage)
            && Objects.equals(requestType, errorDetail.requestType) && Objects.equals(id, errorDetail.id)
            && Objects.equals(originalId, errorDetail.originalId)
            && Objects.equals(detailMessage, errorDetail.detailMessage);
   }

   @Override
   public int hashCode() {
      return Objects.hash(errorType, errorMessage, requestType, id, originalId, detailMessage);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class ErrorDetail {\n");

      sb.append("    errorType: ").append(Utils.toIndentedString(errorType)).append("\n");
      sb.append("    responseMessage: ").append(Utils.toIndentedString(errorMessage)).append("\n");
      sb.append("    requestType: ").append(Utils.toIndentedString(requestType)).append("\n");
      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    originalId: ").append(Utils.toIndentedString(originalId)).append("\n");
      sb.append("    detailMessage: ").append(Utils.toIndentedString(detailMessage)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
