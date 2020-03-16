package io.electrum.billpay.api.validation;

import static io.electrum.billpay.util.ValidationBuilderUtil.institution;
import static io.electrum.billpay.util.ValidationBuilderUtil.originator;
import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;
import java.util.Set;
import java.util.UUID;

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

import io.electrum.billpay.api.AccountLookupsResource;
import io.electrum.billpay.api.IAccountLookupsResource;
import io.electrum.billpay.model.AccountLookupRequest;
import io.electrum.billpay.model.PolicyLookupRequest;
import io.electrum.billpay.model.TrafficFineLookupRequest;

public class TestAccountLookupsResource {

   ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
   ExecutableValidator executableValidator = factory.getValidator().forExecutables();

   @Test
   public void testRequestAccountInfo_Successful() throws NoSuchMethodException {
      // Setup
      AccountLookupsResource accountLookupsResource = new AccountLookupsResourceTest();
      Method method =
            AccountLookupsResource.class.getMethod(
                  "requestAccountInfo",
                  String.class,
                  AccountLookupRequest.class,
                  SecurityContext.class,
                  AsyncResponse.class,
                  Request.class,
                  HttpServletRequest.class,
                  HttpHeaders.class,
                  UriInfo.class);
      String id = UUID.randomUUID().toString();
      AccountLookupRequest accountLookupRequest =
            (AccountLookupRequest) new AccountLookupRequest().accountRef("123456")
                  .id(id)
                  .time(DateTime.now())
                  .originator(originator())
                  .client(institution());
      Object[] parameterValues = { id, accountLookupRequest, null, null, null, null, null, null };
      // Test
      Set<ConstraintViolation<AccountLookupsResource>> violationSet =
            executableValidator.validateParameters(accountLookupsResource, method, parameterValues);

      // Validate
      assertEquals(violationSet.size(), 0);
   }

   @Test
   public void testRequestAccountInfo_Uuid_InvalidId() throws NoSuchMethodException {
      // Setup
      AccountLookupsResource accountLookupsResource = new AccountLookupsResourceTest();
      Method method =
            AccountLookupsResource.class.getMethod(
                  "requestAccountInfo",
                  String.class,
                  AccountLookupRequest.class,
                  SecurityContext.class,
                  AsyncResponse.class,
                  Request.class,
                  HttpServletRequest.class,
                  HttpHeaders.class,
                  UriInfo.class);
      String id = "id";
      AccountLookupRequest accountLookupRequest =
            (AccountLookupRequest) new AccountLookupRequest().accountRef("123456")
                  .id(id)
                  .time(DateTime.now())
                  .originator(originator())
                  .client(institution());
      Object[] parameterValues = { id, accountLookupRequest, null, null, null, null, null, null };
      // Test
      Set<ConstraintViolation<AccountLookupsResource>> violationSet =
            executableValidator.validateParameters(accountLookupsResource, method, parameterValues);

      // Validate
      assertEquals(violationSet.size(), 1);
      ConstraintViolation<AccountLookupsResource> violation = (ConstraintViolation) violationSet.toArray()[0];
      assertEquals(violation.getInvalidValue() + " " + violation.getMessage(), "id must be a valid UUID");
   }

   @Test
   public void testRequestAccountInfo_ConsistentAdviceId_InvalidId() throws NoSuchMethodException {
      // Setup
      AccountLookupsResource accountLookupsResource = new AccountLookupsResourceTest();
      Method method =
            AccountLookupsResource.class.getMethod(
                  "requestAccountInfo",
                  String.class,
                  AccountLookupRequest.class,
                  SecurityContext.class,
                  AsyncResponse.class,
                  Request.class,
                  HttpServletRequest.class,
                  HttpHeaders.class,
                  UriInfo.class);
      String id = UUID.randomUUID().toString();
      AccountLookupRequest accountLookupRequest =
            (AccountLookupRequest) new AccountLookupRequest().accountRef("123456")
                  .id(UUID.randomUUID().toString())
                  .time(DateTime.now())
                  .originator(originator())
                  .client(institution());
      Object[] parameterValues = { id, accountLookupRequest, null, null, null, null, null, null };
      // Test
      Set<ConstraintViolation<AccountLookupsResource>> violationSet =
            executableValidator.validateParameters(accountLookupsResource, method, parameterValues);

      // Validate
      assertEquals(violationSet.size(), 1);
      assertEquals(violationSet.toArray(new ConstraintViolation[] {})[0].getMessage(), "arg0 must match entity id");
   }

   @Test
   public void testRequestTrafficFineInfo_Successful() throws NoSuchMethodException {
      // Setup
      AccountLookupsResource accountLookupsResource = new AccountLookupsResourceTest();
      Method method =
            AccountLookupsResource.class.getMethod(
                  "requestTrafficFineInfo",
                  String.class,
                  TrafficFineLookupRequest.class,
                  SecurityContext.class,
                  AsyncResponse.class,
                  Request.class,
                  HttpServletRequest.class,
                  HttpHeaders.class,
                  UriInfo.class);
      String id = UUID.randomUUID().toString();
      TrafficFineLookupRequest trafficFineLookupRequest =
            (TrafficFineLookupRequest) new TrafficFineLookupRequest().noticeNumber("123456")
                  .id(id)
                  .time(DateTime.now())
                  .originator(originator())
                  .client(institution());
      Object[] parameterValues = { id, trafficFineLookupRequest, null, null, null, null, null, null };
      // Test
      Set<ConstraintViolation<AccountLookupsResource>> violationSet =
            executableValidator.validateParameters(accountLookupsResource, method, parameterValues);

      // Validate
      assertEquals(violationSet.size(), 0);
   }

   @Test
   public void testRequestTrafficFineInfo_Uuid_InvalidId() throws NoSuchMethodException {
      // Setup
      AccountLookupsResource accountLookupsResource = new AccountLookupsResourceTest();
      Method method =
            AccountLookupsResource.class.getMethod(
                  "requestTrafficFineInfo",
                  String.class,
                  TrafficFineLookupRequest.class,
                  SecurityContext.class,
                  AsyncResponse.class,
                  Request.class,
                  HttpServletRequest.class,
                  HttpHeaders.class,
                  UriInfo.class);
      String id = "id";
      TrafficFineLookupRequest trafficFineLookupRequest =
            (TrafficFineLookupRequest) new TrafficFineLookupRequest().noticeNumber("123456")
                  .id(id)
                  .time(DateTime.now())
                  .originator(originator())
                  .client(institution());
      Object[] parameterValues = { id, trafficFineLookupRequest, null, null, null, null, null, null };
      // Test
      Set<ConstraintViolation<AccountLookupsResource>> violationSet =
            executableValidator.validateParameters(accountLookupsResource, method, parameterValues);

      // Validate
      assertEquals(violationSet.size(), 1);
      ConstraintViolation<AccountLookupsResource> violation = (ConstraintViolation) violationSet.toArray()[0];
      assertEquals(violation.getInvalidValue() + " " + violation.getMessage(), "id must be a valid UUID");
   }

   @Test
   public void testRequestTrafficFineInfo_ConsistentAdviceId_InvalidId() throws NoSuchMethodException {
      // Setup
      AccountLookupsResource accountLookupsResource = new AccountLookupsResourceTest();
      Method method =
            AccountLookupsResource.class.getMethod(
                  "requestTrafficFineInfo",
                  String.class,
                  TrafficFineLookupRequest.class,
                  SecurityContext.class,
                  AsyncResponse.class,
                  Request.class,
                  HttpServletRequest.class,
                  HttpHeaders.class,
                  UriInfo.class);
      String id = UUID.randomUUID().toString();
      TrafficFineLookupRequest trafficFineLookupRequest =
            (TrafficFineLookupRequest) new TrafficFineLookupRequest().noticeNumber("123456")
                  .id(UUID.randomUUID().toString())
                  .time(DateTime.now())
                  .originator(originator())
                  .client(institution());
      Object[] parameterValues = { id, trafficFineLookupRequest, null, null, null, null, null, null };
      // Test
      Set<ConstraintViolation<AccountLookupsResource>> violationSet =
            executableValidator.validateParameters(accountLookupsResource, method, parameterValues);

      // Validate
      assertEquals(violationSet.size(), 1);
      assertEquals(violationSet.toArray(new ConstraintViolation[] {})[0].getMessage(), "arg0 must match entity id");
   }

   @Test
   public void testRequestPolicyInfo_Successful() throws NoSuchMethodException {
      // Setup
      AccountLookupsResource accountLookupsResource = new AccountLookupsResourceTest();
      Method method =
            AccountLookupsResource.class.getMethod(
                  "requestPolicyInfo",
                  String.class,
                  PolicyLookupRequest.class,
                  SecurityContext.class,
                  AsyncResponse.class,
                  Request.class,
                  HttpServletRequest.class,
                  HttpHeaders.class,
                  UriInfo.class);
      String id = UUID.randomUUID().toString();
      PolicyLookupRequest policyLookupRequest =
            (PolicyLookupRequest) new PolicyLookupRequest().policyNumber("123456")
                  .id(id)
                  .time(DateTime.now())
                  .originator(originator())
                  .client(institution());
      Object[] parameterValues = { id, policyLookupRequest, null, null, null, null, null, null };
      // Test
      Set<ConstraintViolation<AccountLookupsResource>> violationSet =
            executableValidator.validateParameters(accountLookupsResource, method, parameterValues);

      // Validate
      assertEquals(violationSet.size(), 0);
   }

   @Test
   public void testRequestPolicyInfo_Uuid_InvalidId() throws NoSuchMethodException {
      // Setup
      AccountLookupsResource accountLookupsResource = new AccountLookupsResourceTest();
      Method method =
            AccountLookupsResource.class.getMethod(
                  "requestPolicyInfo",
                  String.class,
                  PolicyLookupRequest.class,
                  SecurityContext.class,
                  AsyncResponse.class,
                  Request.class,
                  HttpServletRequest.class,
                  HttpHeaders.class,
                  UriInfo.class);
      String id = "id";
      PolicyLookupRequest policyLookupRequest =
            (PolicyLookupRequest) new PolicyLookupRequest().policyNumber("123456")
                  .id(id)
                  .time(DateTime.now())
                  .originator(originator())
                  .client(institution());
      Object[] parameterValues = { id, policyLookupRequest, null, null, null, null, null, null };
      // Test
      Set<ConstraintViolation<AccountLookupsResource>> violationSet =
            executableValidator.validateParameters(accountLookupsResource, method, parameterValues);

      // Validate
      assertEquals(violationSet.size(), 1);
      ConstraintViolation<AccountLookupsResource> violation = (ConstraintViolation) violationSet.toArray()[0];
      assertEquals(violation.getInvalidValue() + " " + violation.getMessage(), "id must be a valid UUID");
   }

   @Test
   public void testRequestPolicyInfo_ConsistentAdviceId_InvalidId() throws NoSuchMethodException {
      // Setup
      AccountLookupsResource accountLookupsResource = new AccountLookupsResourceTest();
      Method method =
            AccountLookupsResource.class.getMethod(
                  "requestPolicyInfo",
                  String.class,
                  PolicyLookupRequest.class,
                  SecurityContext.class,
                  AsyncResponse.class,
                  Request.class,
                  HttpServletRequest.class,
                  HttpHeaders.class,
                  UriInfo.class);
      String id = UUID.randomUUID().toString();
      PolicyLookupRequest policyLookupRequest =
            (PolicyLookupRequest) new PolicyLookupRequest().policyNumber("123456")
                  .id(UUID.randomUUID().toString())
                  .time(DateTime.now())
                  .originator(originator())
                  .client(institution());
      Object[] parameterValues = { id, policyLookupRequest, null, null, null, null, null, null };
      // Test
      Set<ConstraintViolation<AccountLookupsResource>> violationSet =
            executableValidator.validateParameters(accountLookupsResource, method, parameterValues);

      // Validate
      assertEquals(violationSet.size(), 1);
      assertEquals(violationSet.toArray(new ConstraintViolation[] {})[0].getMessage(), "arg0 must match entity id");
   }

   private static class AccountLookupsResourceTest extends AccountLookupsResource {
      @Override
      protected IAccountLookupsResource getResourceImplementation() {
         return null;
      }
   }

}
