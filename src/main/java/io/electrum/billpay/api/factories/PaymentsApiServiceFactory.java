package io.electrum.billpay.api.factories;

import io.electrum.billpay.api.PaymentsApiService;
import io.electrum.billpay.api.impl.PaymentsApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-06-13T18:34:39.493Z")
public class PaymentsApiServiceFactory {

   private final static PaymentsApiService service = new PaymentsApiServiceImpl();

   public static PaymentsApiService getPaymentsApi() {
      return service;
   }
}
