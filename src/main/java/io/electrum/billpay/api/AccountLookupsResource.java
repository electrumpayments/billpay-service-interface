package io.electrum.billpay.api;

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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import io.electrum.billpay.model.AccountLookupRequest;
import io.electrum.billpay.model.AccountLookupResponse;
import io.electrum.billpay.model.ErrorDetail;
import io.electrum.billpay.model.PolicyLookupRequest;
import io.electrum.billpay.model.PolicyLookupResponse;
import io.electrum.billpay.model.TrafficFineLookupRequest;
import io.electrum.billpay.model.TrafficFineLookupResponse;
import io.electrum.billpay.utils.Paths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

@Path(Paths.BASE_PATH)
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@Api(description = "the accountLookups API", authorizations = { @Authorization("httpBasic") })
public abstract class AccountLookupsResource {

   protected abstract IAccountLookupsResource getResourceImplementation();

   @POST
   @Path(Paths.REQUEST_ACCOUNT_INFO)
   @Consumes({MediaType.APPLICATION_JSON})
   @Produces({MediaType.APPLICATION_JSON})
   @ApiOperation(value = "Basic account information request",
           nickname = Operations.REQUEST_ACCOUNT_INFO,
           notes = "Requests the current status of the account identified by the supplied account reference. Not all services support account lookups. In the case where this function is not supported for the requested service, a 501 HTTP status code may be returned")
   @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = AccountLookupResponse.class),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 501, message = "Not implemented", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public void requestAccountInfo(
         @ApiParam(value = "The randomly generated UUID of this request", required = true) @PathParam("requestId") String requestId,
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

   @POST
   @Path(Paths.REQUEST_TRAFFIC_FINE_INFO)
   @Consumes({MediaType.APPLICATION_JSON})
   @Produces({MediaType.APPLICATION_JSON})
   @ApiOperation(value = "Basic traffic fine info request",
           nickname = Operations.REQUEST_TRAFFIC_FINE_INFO,
           notes = "Requests information related to a specific traffic fine as identified by the noticeNumber. In the case where this function is not supported by the relevant service provider, a 501 HTTP status code may be returned")
   @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = TrafficFineLookupResponse.class),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 501, message = "Not implemented", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public void requestTrafficFineInfo(
         @ApiParam(value = "The randomly generated UUID of this request", required = true) @PathParam("requestId") String requestId,
         @ApiParam(value = "A traffic fine lookup request", required = true) TrafficFineLookupRequest body,
         @Context SecurityContext securityContext,
         @Suspended AsyncResponse asyncResponse,
         @Context Request request,
         @Context HttpServletRequest httpServletRequest,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo) {

      getResourceImplementation().requestTrafficFineInfo(
            requestId,
            body,
            securityContext,
            asyncResponse,
            request,
            httpServletRequest,
            httpHeaders,
            uriInfo);
   }

   @POST
   @Path(Paths.REQUEST_POLICY_INFO)
   @Consumes({MediaType.APPLICATION_JSON})
   @Produces({MediaType.APPLICATION_JSON})
   @ApiOperation(value = "Basic policy info request",
           nickname = Operations.REQUEST_POLICY_INFO,
           notes = "Requests the current status of the policy identified by the supplied policy reference. Not all service providers support policy lookups. In the case where this function is not supported by the requested service provider, a 501 HTTP status code may be returned")
   @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = PolicyLookupResponse.class),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 501, message = "Not implemented", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public void requestPolicyInfo(
         @ApiParam(value = "The randomly generated UUID of this request", required = true) @PathParam("requestId") String requestId,
         @ApiParam(value = "A policy lookup request", required = true) PolicyLookupRequest body,
         @Context SecurityContext securityContext,
         @Suspended AsyncResponse asyncResponse,
         @Context Request request,
         @Context HttpServletRequest httpServletRequest,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo) {

      getResourceImplementation().requestPolicyInfo(
            requestId,
            body,
            securityContext,
            asyncResponse,
            request,
            httpServletRequest,
            httpHeaders,
            uriInfo);
   }

   public class Operations {
      public static final String REQUEST_POLICY_INFO = "requestPolicyInfo";
      public static final String REQUEST_TRAFFIC_FINE_INFO = "requestTrafficFineInfo";
      public static final String REQUEST_ACCOUNT_INFO = "requestAccountInfo";
   }

}
