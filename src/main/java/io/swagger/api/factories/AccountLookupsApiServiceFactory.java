package io.swagger.api.factories;

import io.swagger.api.AccountLookupsApiService;
import io.swagger.api.impl.AccountLookupsApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-06-13T18:34:39.493Z")
public class AccountLookupsApiServiceFactory {

   private final static AccountLookupsApiService service = new AccountLookupsApiServiceImpl();

   public static AccountLookupsApiService getAccountLookupsApi() {
      return service;
   }
}
