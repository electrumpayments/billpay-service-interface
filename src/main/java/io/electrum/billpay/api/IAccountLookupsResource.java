package io.electrum.billpay.api;

import io.electrum.billpay.model.AccountLookupRequest;

import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

public interface IAccountLookupsResource {

   void requestAccountInfoImpl(
         String id,
         AccountLookupRequest body,
         SecurityContext securityContext,
         AsyncResponse asyncResponse,
         HttpHeaders httpHeaders,
         UriInfo uriInfo);
}
