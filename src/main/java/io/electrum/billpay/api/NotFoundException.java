package io.electrum.billpay.api;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-06-13T18:34:39.493Z")
public class NotFoundException extends ApiException {
   private int code;

   public NotFoundException(int code, String msg) {
      super(code, msg);
      this.code = code;
   }
}
