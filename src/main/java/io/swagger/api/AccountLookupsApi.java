package io.swagger.api;

import io.swagger.annotations.ApiParam;
import io.swagger.api.factories.AccountLookupsApiServiceFactory;
import io.swagger.model.AccountLookupRequest;
import io.swagger.model.AccountLookupResponse;

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
@io.swagger.annotations.Api(description = "the accountLookups API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-06-13T18:34:39.493Z")
public class AccountLookupsApi {
   private final AccountLookupsApiService delegate = AccountLookupsApiServiceFactory.getAccountLookupsApi();

   @POST
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @io.swagger.annotations.ApiOperation(value = "Request account info", notes = "Requests the current status of the account identified by the supplied account reference. Not all services support account lookups. In the case where this function is not supported for the requested service, a 501 HTTP status code may be returned", response = AccountLookupResponse.class, tags = {})
   @io.swagger.annotations.ApiResponses(value = {
         @io.swagger.annotations.ApiResponse(code = 200, message = "Success", response = AccountLookupResponse.class),
         @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request", response = AccountLookupResponse.class),
         @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error", response = AccountLookupResponse.class),
         @io.swagger.annotations.ApiResponse(code = 501, message = "Not implemented - in the case where the service does not support account lookups", response = AccountLookupResponse.class),
         @io.swagger.annotations.ApiResponse(code = 503, message = "Service Unavailable", response = AccountLookupResponse.class),
         @io.swagger.annotations.ApiResponse(code = 504, message = "Gateway Timeout", response = AccountLookupResponse.class),
         @io.swagger.annotations.ApiResponse(code = 200, message = "Failure", response = AccountLookupResponse.class) })
   public Response requestAccountInfo(
         @ApiParam(value = "An account lookup request", required = true) AccountLookupRequest body,
         @Context SecurityContext securityContext) throws NotFoundException {
      return delegate.requestAccountInfo(body, securityContext);
   }
}
