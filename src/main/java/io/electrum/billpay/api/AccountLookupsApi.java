package io.electrum.billpay.api;

import io.electrum.billpay.api.factories.AccountLookupsApiServiceFactory;
import io.electrum.billpay.model.AccountLookupRequest;
import io.electrum.billpay.model.AccountLookupResponse;
import io.electrum.billpay.model.ErrorDetail;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/accountLookups")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@Api(description = "the accountLookups API", authorizations = { @Authorization("httpBasic") })
public class AccountLookupsApi {
   private final AccountLookupsApiService delegate = AccountLookupsApiServiceFactory.getAccountLookupsApi();

   @POST
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(value = "Request account info", notes = "Requests the current status of the account identified by the supplied account reference. Not all services support account lookups. In the case where this function is not supported for the requested service, a 501 HTTP status code may be returned", response = AccountLookupResponse.class, tags = {})
   @ApiResponses(value = {
         @ApiResponse(code = 200, message = "Success", response = AccountLookupResponse.class),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 501, message = "Not implemented - in the case where the service does not support account lookups"),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public Response requestAccountInfo(
         @ApiParam(value = "An account lookup request", required = true) AccountLookupRequest body,
         @Context SecurityContext securityContext) throws NotFoundException {
      return delegate.requestAccountInfo(body, securityContext);
   }
}
