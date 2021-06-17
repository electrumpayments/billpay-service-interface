package io.electrum.billpay.api;

import io.electrum.billpay.model.Biller;
import io.electrum.billpay.model.ErrorDetail;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

/**
 * @since v4.11.0
 */

@Path(BillersResource.PATH)
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
@Api(authorizations = { @Authorization("httpBasic") })
public abstract class BillersResource {

   protected abstract IBillersResource getResourceImplementation();

   public static final String RESOURCE_PATH = "/billers";
   public static final String PATH = BillpayApi.API_BASE_PATH + RESOURCE_PATH;

   public static class GetBillers {
      private GetBillers() {
      }

      public static final String OPERATION = "listBillers";
      public static final int SUCCESS = 200;
      public static final String PATH = "/";
      public static final String RELATIVE_PATH = PATH;
      public static final String FULL_PATH = BillersResource.PATH + RELATIVE_PATH;
   }

   @GET
   @Path(GetBillers.RELATIVE_PATH)
   @Produces({ "application/json" })
   @ApiOperation(value = "Request the list of managed billers", nickname = GetBillers.OPERATION, notes = "Request "
         + "details on managed billers. Not all services support biller management. In the case where the function "
         + "is not supported a 501 (Not implemented) HTTP status code will be returned.")
   @ApiResponses(value = {
         @ApiResponse(code = GetBillers.SUCCESS, message = "Success", response = Biller.class, responseContainer = "List"),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 501, message = "Not implemented"),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public final void getBillers(
         @Context SecurityContext securityContext,
         @Suspended AsyncResponse asyncResponse,
         @Context Request request,
         @Context HttpServletRequest httpServletRequest,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo) {

      getResourceImplementation()
            .getBillersImpl(securityContext, asyncResponse, request, httpServletRequest, httpHeaders, uriInfo);
   }
}
