package io.electrum.billpay.api;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import org.joda.time.DateTime;
import org.testng.annotations.Test;

import io.electrum.vas.model.TenderAdvice;

public class TestPaymentResource {

   ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
   ExecutableValidator executableValidator = factory.getValidator().forExecutables();

   @Test
   public void testConfirmPaymentSuccessful() throws NoSuchMethodException {
      // Setup
      PaymentsResource paymentsResource = new PaymentsResourceTest();
      Method method =
            PaymentsResource.class.getMethod(
                  "confirmPayment",
                  String.class,
                  String.class,
                  TenderAdvice.class,
                  SecurityContext.class,
                  AsyncResponse.class,
                  Request.class,
                  HttpServletRequest.class,
                  HttpHeaders.class,
                  UriInfo.class);
      String id = UUID.randomUUID().toString();
      String requestId = UUID.randomUUID().toString();
      TenderAdvice tenderAdvice = (TenderAdvice) new TenderAdvice().id(id).requestId(requestId).time(DateTime.now());
      Object[] parameterValues = { id, requestId, tenderAdvice, null, null, null, null, null, null };
      // Test
      Set<ConstraintViolation<PaymentsResource>> violationSet =
            executableValidator.validateParameters(paymentsResource, method, parameterValues);

      // Validate
      assertEquals(violationSet.size(), 0);
   }

   @Test
   public void testConfirmPaymentInvalidId() throws NoSuchMethodException {
      // Setup
      PaymentsResource paymentsResource = new PaymentsResourceTest();
      Method method =
              PaymentsResource.class.getMethod(
                      "confirmPayment",
                      String.class,
                      String.class,
                      TenderAdvice.class,
                      SecurityContext.class,
                      AsyncResponse.class,
                      Request.class,
                      HttpServletRequest.class,
                      HttpHeaders.class,
                      UriInfo.class);
      String id = UUID.randomUUID().toString();
      String requestId = UUID.randomUUID().toString();
      TenderAdvice tenderAdvice = (TenderAdvice) new TenderAdvice().id(UUID.randomUUID().toString()).requestId(requestId).time(DateTime.now());
      Object[] parameterValues = { id, requestId, tenderAdvice, null, null, null, null, null, null };
      // Test
      Set<ConstraintViolation<PaymentsResource>> violationSet =
              executableValidator.validateParameters(paymentsResource, method, parameterValues);

      // Validate
      assertEquals(violationSet.size(), 1);
      assertEquals(violationSet.toArray(new ConstraintViolation[]{})[0].getMessage(), "must match entity requestId");
   }

   private static class PaymentsResourceTest extends PaymentsResource {
      @Override
      protected IPaymentsResource getResourceImplementation() {
         return null;
      }
   }

}
