package io.electrum.billpay.api.impl;

import io.electrum.billpay.api.ApiResponseMessage;
import io.electrum.billpay.api.NotFoundException;
import io.electrum.billpay.api.AccountLookupsApiService;
import io.electrum.billpay.model.AccountLookupRequest;

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
