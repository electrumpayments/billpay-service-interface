package io.electrum.billpay.api;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import io.electrum.billpay.model.AccountLookupRequest;
import io.electrum.billpay.model.AccountLookupResponse;
import io.electrum.billpay.model.ErrorDetail;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

@Path("/accountLookups/{requestId}")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@Api(description = "the accountLookups API", authorizations = { @Authorization("httpBasic") })
public abstract class AccountLookupsResource {

   protected abstract IAccountLookupsResource getResourceImplementation();

   @POST
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(value = "BasicRequest account info", notes = "Requests the current status of the account identified by the supplied account reference. Not all services support account lookups. In the case where this function is not supported for the requested service, a 501 HTTP status code may be returned")
   @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = AccountLookupResponse.class),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 501, message = "Not implemented", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public void requestAccountInfo(
         @ApiParam(value = "The randomly generated UUID of this request", required = true) @PathParam("requestId") UUID requestId,
         @ApiParam(value = "An account lookup request", required = true) AccountLookupRequest body,
         @Context SecurityContext securityContext,
         @Suspended AsyncResponse asyncResponse,
         @Context Request request,
         @Context HttpServletRequest httpServletRequest,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo) {

      getResourceImplementation().requestAccountInfo(
            requestId,
            body,
            securityContext,
            asyncResponse,
            request,
            httpServletRequest,
            httpHeaders,
            uriInfo);
   }
}
