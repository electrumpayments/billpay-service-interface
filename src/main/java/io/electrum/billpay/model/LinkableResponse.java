package io.electrum.billpay.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Represents a response that may be linked to in future
 **/
public abstract class LinkableResponse extends BasicResponse {

   protected String id = null;
   protected Object linkData = null;

   /**
    * An identifier that uniquely identifies the payment
    **/
   public LinkableResponse id(String id) {
      this.id = id;
      return this;
   }

   @ApiModelProperty(required = true, value = "An identifier that uniquely identifies the payment")
   @JsonProperty("id")
   @NotNull
   @Pattern(regexp = "[A-Za-z0-9._~-]{1,40}")
   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   /**
    * This object may be used by the server to link a payment to a payment confirmation or cancellation, and should be
    * provided unaltered by clients in corresponding requests
    **/
   public LinkableResponse linkData(Object linkData) {
      this.linkData = linkData;
      return this;
   }

   @ApiModelProperty(value = "This object may be used by the server to link a payment to a payment confirmation or cancellation, and should be provided unaltered by clients in corresponding requests")
   @JsonProperty("linkData")
   public Object getLinkData() {
      return linkData;
   }

   public void setLinkData(Object linkData) {
      this.linkData = linkData;
   }
}
