package io.electrum.billpay.api.factories;

import io.electrum.billpay.api.AccountLookupsApiService;
import io.electrum.billpay.api.impl.AccountLookupsApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-06-13T18:34:39.493Z")
public class AccountLookupsApiServiceFactory {

   private final static AccountLookupsApiService service = new AccountLookupsApiServiceImpl();

   public static AccountLookupsApiService getAccountLookupsApi() {
      return service;
   }
}
