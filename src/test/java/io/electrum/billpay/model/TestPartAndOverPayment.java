package io.electrum.billpay.model;

import java.io.IOException;
import java.util.Optional;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TestPartAndOverPayment {
   AccountLookupResponse testResponse;

   @Test
   public void testWithPartAndOverPayment() throws IOException {
      String accountLookupRsp = "{\n" + "\"partPaymentAllowed\":false,\n" + "\"overPaymentAllowed\":false\n" + "}";
      testResponse = new ObjectMapper().readValue(accountLookupRsp, AccountLookupResponse.class);

      Assert.assertEquals(testResponse.getPartPayment(), Optional.of(false));
      Assert.assertFalse(testResponse.getPartPaymentAllowed());
      Assert.assertEquals(testResponse.getOverPayment(), Optional.of(false));
      Assert.assertFalse(testResponse.getOverPaymentAllowed());
   }

   @Test
   public void testPartAndOverPaymentTrue() throws IOException {
      String accountLookupRsp = "{\n" + "\"partPaymentAllowed\":true,\n" + "\"overPaymentAllowed\":true\n" + "}";
      testResponse = new ObjectMapper().readValue(accountLookupRsp, AccountLookupResponse.class);

      Assert.assertEquals(testResponse.getPartPayment(), Optional.of(true));
      Assert.assertTrue(testResponse.getPartPaymentAllowed());
      Assert.assertEquals(testResponse.getOverPayment(), Optional.of(true));
      Assert.assertTrue(testResponse.getOverPaymentAllowed());
   }

   @Test
   public void testPartAndOverPaymentMissing() throws IOException {
      String accountLookupRsp = "{\n" + "}";
      testResponse = new ObjectMapper().readValue(accountLookupRsp, AccountLookupResponse.class);

      Assert.assertEquals(testResponse.getPartPayment(), Optional.empty());
      Assert.assertFalse(testResponse.getPartPaymentAllowed());
      Assert.assertEquals(testResponse.getOverPayment(), Optional.empty());
      Assert.assertFalse(testResponse.getOverPaymentAllowed());
   }

   @Test
   public void testJsonAlias() throws IOException {
      String accountLookupRsp = "{\n" + "\"partPayment\":true,\n" + "\"overPayment\":true\n" + "}";
      testResponse = new ObjectMapper().readValue(accountLookupRsp, AccountLookupResponse.class);

      Assert.assertEquals(testResponse.getPartPayment(), Optional.of(true));
      Assert.assertTrue(testResponse.getPartPaymentAllowed());
      Assert.assertEquals(testResponse.getOverPayment(), Optional.of(true));
      Assert.assertTrue(testResponse.getOverPaymentAllowed());
   }

}
