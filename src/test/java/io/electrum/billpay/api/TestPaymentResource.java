package io.electrum.billpay.api;

import static io.electrum.billpay.util.ValidationBuilderUtil.institution;
import static io.electrum.billpay.util.ValidationBuilderUtil.originator;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import io.electrum.vas.model.Amounts;
import org.joda.time.DateTime;
import org.testng.annotations.Test;

import io.electrum.billpay.model.PaymentRequest;
import io.electrum.vas.model.TenderAdvice;

public class TestPaymentResource {

   ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
   ExecutableValidator executableValidator = factory.getValidator().forExecutables();

   @Test
   public void testConfirmPayment_Successful() throws NoSuchMethodException {
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
   public void testConfirmPayment_Uuid_InvalidIdAndRequestId() throws NoSuchMethodException {
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
      String id = "id";
      String requestId = "requestId";
      TenderAdvice tenderAdvice = (TenderAdvice) new TenderAdvice().id(id).requestId(requestId).time(DateTime.now());
      Object[] parameterValues = { id, requestId, tenderAdvice, null, null, null, null, null, null };
      // Test
      Set<ConstraintViolation<PaymentsResource>> violationSet =
            executableValidator.validateParameters(paymentsResource, method, parameterValues);

      // Validate
      assertEquals(violationSet.size(), 2);
      Set<String> violationMessages =
            violationSet.stream()
                  .map(violation -> violation.getInvalidValue() + " " + violation.getMessage())
                  .collect(Collectors.toSet());
      System.out.println(violationMessages.toString());
      assertTrue(violationMessages.contains("id must be a valid UUID"));
      assertTrue(violationMessages.contains("requestId must be a valid UUID"));
   }

   @Test
   public void testConfirmPayment_ConsistentAdviceId_InvalidId() throws NoSuchMethodException {
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
      TenderAdvice tenderAdvice =
            (TenderAdvice) new TenderAdvice().id(UUID.randomUUID().toString())
                  .requestId(requestId)
                  .time(DateTime.now());
      Object[] parameterValues = { id, requestId, tenderAdvice, null, null, null, null, null, null };
      // Test
      Set<ConstraintViolation<PaymentsResource>> violationSet =
            executableValidator.validateParameters(paymentsResource, method, parameterValues);

      // Validate
      assertEquals(violationSet.size(), 1);
      assertEquals(violationSet.toArray(new ConstraintViolation[] {})[0].getMessage(), "arg0 must match entity id");
   }

   @Test
   public void testConfirmPayment_ConsistentAdviceId_InvalidRequestId() throws NoSuchMethodException {
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
      TenderAdvice tenderAdvice =
            (TenderAdvice) new TenderAdvice().id(id).requestId(UUID.randomUUID().toString()).time(DateTime.now());
      Object[] parameterValues = { id, requestId, tenderAdvice, null, null, null, null, null, null };
      // Test
      Set<ConstraintViolation<PaymentsResource>> violationSet =
            executableValidator.validateParameters(paymentsResource, method, parameterValues);

      // Validate
      assertEquals(violationSet.size(), 1);
      assertEquals(
            violationSet.toArray(new ConstraintViolation[] {})[0].getMessage(),
            "arg1 must match entity requestId");
   }

   @Test
   public void testCreatePayment_Successful() throws NoSuchMethodException {
      // Setup
      PaymentsResource paymentsResource = new PaymentsResourceTest();
      Method method =
            PaymentsResource.class.getMethod(
                  "createPayment",
                  String.class,
                  PaymentRequest.class,
                  SecurityContext.class,
                  AsyncResponse.class,
                  Request.class,
                  HttpServletRequest.class,
                  HttpHeaders.class,
                  UriInfo.class);
      String id = UUID.randomUUID().toString();
      PaymentRequest paymentRequest =
            (PaymentRequest) new PaymentRequest().id(id)
                  .time(DateTime.now())
                  .originator(originator())
                  .client(institution());
      Object[] parameterValues = { id, paymentRequest, null, null, null, null, null, null };
      // Test
      Set<ConstraintViolation<PaymentsResource>> violationSet =
            executableValidator.validateParameters(paymentsResource, method, parameterValues);

      // Validate
      assertEquals(violationSet.size(), 0);
   }

   private static class PaymentsResourceTest extends PaymentsResource {
      @Override
      protected IPaymentsResource getResourceImplementation() {
         return null;
      }
   }

}
