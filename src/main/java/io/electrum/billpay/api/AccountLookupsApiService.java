package io.electrum.billpay.api;

import io.electrum.billpay.model.AccountLookupRequest;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-06-13T18:34:39.493Z")
public abstract class AccountLookupsApiService {
   public abstract Response requestAccountInfo(AccountLookupRequest body, SecurityContext securityContext)
         throws NotFoundException;
}
