package io.swagger.api.impl;

import io.swagger.api.AccountLookupsApiService;
import io.swagger.api.ApiResponseMessage;
import io.swagger.api.NotFoundException;
import io.swagger.model.AccountLookupRequest;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-06-13T18:34:39.493Z")
public class AccountLookupsApiServiceImpl extends AccountLookupsApiService {
   @Override
   public Response requestAccountInfo(AccountLookupRequest body, SecurityContext securityContext)
         throws NotFoundException {
      // do some magic!
      return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
   }
}
