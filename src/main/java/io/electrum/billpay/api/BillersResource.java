package io.electrum.billpay.api;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import io.electrum.billpay.model.Biller;
import io.electrum.billpay.model.ErrorDetail;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

@Path(BillersResource.PATH)
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
@Api(description = "the payments API", authorizations = { @Authorization("httpBasic") })
public abstract class BillersResource {

   protected abstract IBillersResource getResourceImplementation();

   public static final String RESOURCE_PATH = "/billers";
   public static final String PATH = BillpayApi.API_BASE_PATH + RESOURCE_PATH;

   public static class GetBillers {
      public static final String OPERATION = "listBillers";
      public static final int SUCCESS = 200;
      public static final String PATH = "/";
      public static final String RELATIVE_PATH = PATH;
      public static final String FULL_PATH = BillersResource.PATH + RELATIVE_PATH;

      public static class QueryParameters {
         public static final String CHANNEL_NAME = "channelName";
      }
   }

   @GET
   @Path(GetBillers.RELATIVE_PATH)
   @Produces({ "application/json" })
   @ApiOperation(nickname = GetBillers.OPERATION, value = "Retrieves a list of available bill issuers."
    + "If a list of available bill issuers is maintained, this API call returns the list of bille issuers. " +
           "If such a list is not maintained, then a 501 Not Implemented status code will be returned.") //todo notes
   @ApiResponses(value = { @ApiResponse(code = GetBillers.SUCCESS, message = "Success", response = Biller.class, responseContainer = "List"),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 501, message = "Not implemented"),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public final void getBillers(
         @ApiParam(value = "The name of the channel to retrieve billers for. If set only billers matching this " +
                 "channel name will be returned. If not set, all billers will be returned.")
         @QueryParam(GetBillers.QueryParameters.CHANNEL_NAME) @NotNull String channelName,
         @Context SecurityContext securityContext,
         @Suspended AsyncResponse asyncResponse,
         @Context Request request,
         @Context HttpServletRequest httpServletRequest,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo) {

      getResourceImplementation().getBillersImpl(
            channelName,
            securityContext,
            asyncResponse,
            request,
            httpServletRequest,
            httpHeaders,
            uriInfo);
   }
}
