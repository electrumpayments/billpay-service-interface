package io.electrum.billpay.api.validation;

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

import org.joda.time.DateTime;
import org.testng.annotations.Test;

import io.electrum.billpay.api.IRefundsResource;
import io.electrum.billpay.api.RefundsResource;
import io.electrum.billpay.model.RefundRequest;
import io.electrum.vas.model.BasicAdvice;
import io.electrum.vas.model.BasicReversal;

public class TestRefundsResource {

   ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
   ExecutableValidator executableValidator = factory.getValidator().forExecutables();

   @Test
   public void testConfirmRefund_Successful() throws NoSuchMethodException {
      // Setup
      RefundsResource refundsResource = new RefundsResourceTest();
      Method method =
            RefundsResource.class.getMethod(
                  "confirmRefund",
                  String.class,
                  String.class,
                  BasicAdvice.class,
                  SecurityContext.class,
                  AsyncResponse.class,
                  Request.class,
                  HttpServletRequest.class,
                  HttpHeaders.class,
                  UriInfo.class);
      String id = UUID.randomUUID().toString();
      String requestId = UUID.randomUUID().toString();
      BasicAdvice basicAdvice = new BasicAdvice().id(id).requestId(requestId).time(DateTime.now());
      Object[] parameterValues = { id, requestId, basicAdvice, null, null, null, null, null, null };
      // Test
      Set<ConstraintViolation<RefundsResource>> violationSet =
            executableValidator.validateParameters(refundsResource, method, parameterValues);

      // Validate
      assertEquals(violationSet.size(), 0);
   }

   @Test
   public void testConfirmRefund_Uuid_InvalidIdAndRequestId() throws NoSuchMethodException {
      // Setup
      RefundsResource refundsResource = new RefundsResourceTest();
      Method method =
            RefundsResource.class.getMethod(
                  "confirmRefund",
                  String.class,
                  String.class,
                  BasicAdvice.class,
                  SecurityContext.class,
                  AsyncResponse.class,
                  Request.class,
                  HttpServletRequest.class,
                  HttpHeaders.class,
                  UriInfo.class);
      String id = "id";
      String requestId = "requestId";
      BasicAdvice basicAdvice = new BasicAdvice().id(id).requestId(requestId).time(DateTime.now());
      Object[] parameterValues = { id, requestId, basicAdvice, null, null, null, null, null, null };
      // Test
      Set<ConstraintViolation<RefundsResource>> violationSet =
            executableValidator.validateParameters(refundsResource, method, parameterValues);

      // Validate
      assertEquals(violationSet.size(), 2);
      Set<String> violationMessages =
            violationSet.stream()
                  .map(violation -> violation.getInvalidValue() + " " + violation.getMessage())
                  .collect(Collectors.toSet());
      assertTrue(violationMessages.contains("id must be a valid UUID"));
      assertTrue(violationMessages.contains("requestId must be a valid UUID"));
   }

   @Test
   public void testConfirmRefund_ConsistentAdviceId_InvalidId() throws NoSuchMethodException {
      // Setup
      RefundsResource refundsResource = new RefundsResourceTest();
      Method method =
            RefundsResource.class.getMethod(
                  "confirmRefund",
                  String.class,
                  String.class,
                  BasicAdvice.class,
                  SecurityContext.class,
                  AsyncResponse.class,
                  Request.class,
                  HttpServletRequest.class,
                  HttpHeaders.class,
                  UriInfo.class);
      String id = UUID.randomUUID().toString();
      String requestId = UUID.randomUUID().toString();
      BasicAdvice basicAdvice =
            new BasicAdvice().id(UUID.randomUUID().toString()).requestId(requestId).time(DateTime.now());
      Object[] parameterValues = { id, requestId, basicAdvice, null, null, null, null, null, null };
      // Test
      Set<ConstraintViolation<RefundsResource>> violationSet =
            executableValidator.validateParameters(refundsResource, method, parameterValues);

      // Validate
      assertEquals(violationSet.size(), 1);
      assertEquals(violationSet.toArray(new ConstraintViolation[] {})[0].getMessage(), "arg0 must match entity id");
   }

   @Test
   public void testConfirmRefund_ConsistentAdviceId_InvalidRequestId() throws NoSuchMethodException {
      // Setup
      RefundsResource refundsResource = new RefundsResourceTest();
      Method method =
            RefundsResource.class.getMethod(
                  "confirmRefund",
                  String.class,
                  String.class,
                  BasicAdvice.class,
                  SecurityContext.class,
                  AsyncResponse.class,
                  Request.class,
                  HttpServletRequest.class,
                  HttpHeaders.class,
                  UriInfo.class);
      String id = UUID.randomUUID().toString();
      String requestId = UUID.randomUUID().toString();
      BasicAdvice basicAdvice = new BasicAdvice().id(id).requestId(UUID.randomUUID().toString()).time(DateTime.now());
      Object[] parameterValues = { id, requestId, basicAdvice, null, null, null, null, null, null };
      // Test
      Set<ConstraintViolation<RefundsResource>> violationSet =
            executableValidator.validateParameters(refundsResource, method, parameterValues);

      // Validate
      assertEquals(violationSet.size(), 1);
      assertEquals(
            violationSet.toArray(new ConstraintViolation[] {})[0].getMessage(),
            "arg1 must match entity requestId");
   }

   @Test
   public void testCreateRefund_Successful() throws NoSuchMethodException {
      // Setup
      RefundsResource refundsResource = new RefundsResourceTest();
      Method method =
            RefundsResource.class.getMethod(
                  "createRefund",
                  String.class,
                  RefundRequest.class,
                  SecurityContext.class,
                  AsyncResponse.class,
                  Request.class,
                  HttpServletRequest.class,
                  HttpHeaders.class,
                  UriInfo.class);
      String id = UUID.randomUUID().toString();
      RefundRequest refundRequest =
            (RefundRequest) new RefundRequest().issuerReference("123456")
                  .refundReason("")
                  .id(id)
                  .time(DateTime.now())
                  .originator(originator())
                  .client(institution());
      Object[] parameterValues = { id, refundRequest, null, null, null, null, null, null };
      // Test
      Set<ConstraintViolation<RefundsResource>> violationSet =
            executableValidator.validateParameters(refundsResource, method, parameterValues);

      // Validate
      assertEquals(violationSet.size(), 0);
   }

   @Test
   public void testCreateRefund_Uuid_InvalidId() throws NoSuchMethodException {
      // Setup
      RefundsResource refundsResource = new RefundsResourceTest();
      Method method =
            RefundsResource.class.getMethod(
                  "createRefund",
                  String.class,
                  RefundRequest.class,
                  SecurityContext.class,
                  AsyncResponse.class,
                  Request.class,
                  HttpServletRequest.class,
                  HttpHeaders.class,
                  UriInfo.class);
      String id = "id";
      RefundRequest refundRequest =
            (RefundRequest) new RefundRequest().issuerReference("123456")
                  .refundReason("")
                  .id(id)
                  .time(DateTime.now())
                  .originator(originator())
                  .client(institution());
      Object[] parameterValues = { id, refundRequest, null, null, null, null, null, null };
      // Test
      Set<ConstraintViolation<RefundsResource>> violationSet =
            executableValidator.validateParameters(refundsResource, method, parameterValues);

      // Validate
      assertEquals(violationSet.size(), 1);
      ConstraintViolation<RefundsResource> violation = (ConstraintViolation) violationSet.toArray()[0];
      assertEquals(violation.getInvalidValue() + " " + violation.getMessage(), "id must be a valid UUID");
   }

   @Test
   public void testCreateRefund_ConsistentAdviceId_InvalidId() throws NoSuchMethodException {
      // Setup
      RefundsResource refundsResource = new RefundsResourceTest();
      Method method =
            RefundsResource.class.getMethod(
                  "createRefund",
                  String.class,
                  RefundRequest.class,
                  SecurityContext.class,
                  AsyncResponse.class,
                  Request.class,
                  HttpServletRequest.class,
                  HttpHeaders.class,
                  UriInfo.class);
      String id = UUID.randomUUID().toString();
      RefundRequest refundRequest =
            (RefundRequest) new RefundRequest().issuerReference("123456")
                  .refundReason("")
                  .id(UUID.randomUUID().toString())
                  .time(DateTime.now())
                  .originator(originator())
                  .client(institution());
      Object[] parameterValues = { id, refundRequest, null, null, null, null, null, null };
      // Test
      Set<ConstraintViolation<RefundsResource>> violationSet =
            executableValidator.validateParameters(refundsResource, method, parameterValues);

      // Validate
      assertEquals(violationSet.size(), 1);
      assertEquals(violationSet.toArray(new ConstraintViolation[] {})[0].getMessage(), "arg0 must match entity id");
   }

   @Test
   public void testReverseRefund_Successful() throws NoSuchMethodException {
      // Setup
      RefundsResource refundsResource = new RefundsResourceTest();
      Method method =
            RefundsResource.class.getMethod(
                  "reverseRefund",
                  String.class,
                  String.class,
                  BasicReversal.class,
                  SecurityContext.class,
                  AsyncResponse.class,
                  Request.class,
                  HttpServletRequest.class,
                  HttpHeaders.class,
                  UriInfo.class);
      String id = UUID.randomUUID().toString();
      String requestId = UUID.randomUUID().toString();
      BasicReversal basicReversal =
            (BasicReversal) new BasicReversal().reversalReason(BasicReversal.ReversalReason.CANCELLED)
                  .id(id)
                  .requestId(requestId)
                  .time(DateTime.now());
      Object[] parameterValues = { id, requestId, basicReversal, null, null, null, null, null, null };
      // Test
      Set<ConstraintViolation<RefundsResource>> violationSet =
            executableValidator.validateParameters(refundsResource, method, parameterValues);

      // Validate
      assertEquals(violationSet.size(), 0);
   }

   @Test
   public void testReverseRefund_Uuid_InvalidIdAndRequestId() throws NoSuchMethodException {
      // Setup
      RefundsResource refundsResource = new RefundsResourceTest();
      Method method =
            RefundsResource.class.getMethod(
                  "reverseRefund",
                  String.class,
                  String.class,
                  BasicReversal.class,
                  SecurityContext.class,
                  AsyncResponse.class,
                  Request.class,
                  HttpServletRequest.class,
                  HttpHeaders.class,
                  UriInfo.class);
      String id = "id";
      String requestId = "requestId";
      BasicReversal basicReversal =
            (BasicReversal) new BasicReversal().reversalReason(BasicReversal.ReversalReason.CANCELLED)
                  .id(id)
                  .requestId(requestId)
                  .time(DateTime.now());
      Object[] parameterValues = { id, requestId, basicReversal, null, null, null, null, null, null };
      // Test
      Set<ConstraintViolation<RefundsResource>> violationSet =
            executableValidator.validateParameters(refundsResource, method, parameterValues);

      // Validate
      assertEquals(violationSet.size(), 2);
      Set<String> violationMessages =
            violationSet.stream()
                  .map(violation -> violation.getInvalidValue() + " " + violation.getMessage())
                  .collect(Collectors.toSet());
      assertTrue(violationMessages.contains("id must be a valid UUID"));
      assertTrue(violationMessages.contains("requestId must be a valid UUID"));
   }

   @Test
   public void testReverseRefund_ConsistentAdviceId_InvalidId() throws NoSuchMethodException {
      // Setup
      RefundsResource refundsResource = new RefundsResourceTest();
      Method method =
            RefundsResource.class.getMethod(
                  "reverseRefund",
                  String.class,
                  String.class,
                  BasicReversal.class,
                  SecurityContext.class,
                  AsyncResponse.class,
                  Request.class,
                  HttpServletRequest.class,
                  HttpHeaders.class,
                  UriInfo.class);
      String id = UUID.randomUUID().toString();
      String requestId = UUID.randomUUID().toString();
      BasicReversal basicReversal =
            (BasicReversal) new BasicReversal().reversalReason(BasicReversal.ReversalReason.CANCELLED)
                  .id(UUID.randomUUID().toString())
                  .requestId(requestId)
                  .time(DateTime.now());
      Object[] parameterValues = { id, requestId, basicReversal, null, null, null, null, null, null };
      // Test
      Set<ConstraintViolation<RefundsResource>> violationSet =
            executableValidator.validateParameters(refundsResource, method, parameterValues);

      // Validate
      assertEquals(violationSet.size(), 1);
      assertEquals(violationSet.toArray(new ConstraintViolation[] {})[0].getMessage(), "arg0 must match entity id");
   }

   @Test
   public void testReverseRefund_ConsistentAdviceId_InvalidRequestId() throws NoSuchMethodException {
      // Setup
      RefundsResource refundsResource = new RefundsResourceTest();
      Method method =
            RefundsResource.class.getMethod(
                  "reverseRefund",
                  String.class,
                  String.class,
                  BasicReversal.class,
                  SecurityContext.class,
                  AsyncResponse.class,
                  Request.class,
                  HttpServletRequest.class,
                  HttpHeaders.class,
                  UriInfo.class);
      String id = UUID.randomUUID().toString();
      String requestId = UUID.randomUUID().toString();
      BasicReversal basicReversal =
            (BasicReversal) new BasicReversal().reversalReason(BasicReversal.ReversalReason.CANCELLED)
                  .id(id)
                  .requestId(UUID.randomUUID().toString())
                  .time(DateTime.now());
      Object[] parameterValues = { id, requestId, basicReversal, null, null, null, null, null, null };
      // Test
      Set<ConstraintViolation<RefundsResource>> violationSet =
            executableValidator.validateParameters(refundsResource, method, parameterValues);

      // Validate
      assertEquals(violationSet.size(), 1);
      assertEquals(
            violationSet.toArray(new ConstraintViolation[] {})[0].getMessage(),
            "arg1 must match entity requestId");
   }

   private static class RefundsResourceTest extends RefundsResource {
      @Override
      protected IRefundsResource getResourceImplementation() {
         return null;
      }
   }

}
