package io.electrum.billpay.api;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.ServerErrorException;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

/**
 * @since v4.10.0
 */
public interface IBillersResource {

   default void getBillersImpl(
         SecurityContext securityContext,
         AsyncResponse asyncResponse,
         Request request,
         HttpServletRequest httpServletRequest,
         HttpHeaders httpHeaders,
         UriInfo uriInfo) {
      asyncResponse.resume(new ServerErrorException("This operation has not been implemented.", 501));
   }
}
