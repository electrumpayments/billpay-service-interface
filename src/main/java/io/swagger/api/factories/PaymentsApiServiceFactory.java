package io.swagger.api.factories;

import io.swagger.api.PaymentsApiService;
import io.swagger.api.impl.PaymentsApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-06-13T18:34:39.493Z")
public class PaymentsApiServiceFactory {

   private final static PaymentsApiService service = new PaymentsApiServiceImpl();

   public static PaymentsApiService getPaymentsApi() {
      return service;
   }
}
