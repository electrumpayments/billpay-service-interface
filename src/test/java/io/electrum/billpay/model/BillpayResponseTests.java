package io.electrum.billpay.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import javax.validation.Validation;
import javax.validation.Validator;

import io.electrum.vas.model.MerchantName;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.electrum.vas.JsonUtil;
import io.electrum.vas.model.AccountType;
import io.electrum.vas.model.Amounts;
import io.electrum.vas.model.BasicAdvice;
import io.electrum.vas.model.Institution;
import io.electrum.vas.model.LedgerAmount;
import io.electrum.vas.model.Merchant;
import io.electrum.vas.model.Originator;
import io.electrum.vas.model.ThirdPartyIdentifier;
import io.electrum.vas.model.TranType;
import io.electrum.vas.model.Transaction;

public class BillpayResponseTests {
   AccountLookupResponse testResponse;
   Transaction objectWithTrue;
   Transaction objectWithFalse;
   Transaction objectWithNull;
   String serializedValueFalse =
         "{\"id\":\"123456ID\",\"time\":\"2013-06-07T08:11:59.000Z\",\"originator\":{\"institution\":{"
               + "\"id\":\"0\",\"name\":\"someone\"},\"terminalId\":\"111\",\"merchant\":{}},\"client\":{"
               + "\"id\":\"1\",\"name\":\"someone1\"},\"settlementEntity\":{\"id\":\"2\",\"name\":"
               + "\"someone2\"},\"receiver\":{\"id\":\"3\",\"name\":\"someone3\"},\"thirdPartyIdentifiers\""
               + ":[{\"institutionId\":\"1234InsId\",\"transactionIdentifier\":\"1234transId\"}],"
               + "\"slipData\":{\"messageLines\":[],\"slipWidth\":0},\"basketRef\":\"ref\",\"tranType\":"
               + "\"BALANCE_INQUIRY\",\"srcAccType\":\"CHEQUE\",\"stan\":\"12345stan\",\"rrn\":\"12345rrn\","
               + "\"customer\":{},\"amounts\":{},\"partPaymentAllowed\":false,\"overPaymentAllowed\":false,"
               + "\"account\":{}}";
   String serializedValueTrue =
         "{\"id\":\"123456ID\",\"time\":\"2013-06-07T08:11:59.000Z\",\"originator\":{\"institution\":{"
               + "\"id\":\"0\",\"name\":\"someone\"},\"terminalId\":\"111\",\"merchant\":{}},\"client\":{"
               + "\"id\":\"1\",\"name\":\"someone1\"},\"settlementEntity\":{\"id\":\"2\",\"name\":"
               + "\"someone2\"},\"receiver\":{\"id\":\"3\",\"name\":\"someone3\"},\"thirdPartyIdentifiers\""
               + ":[{\"institutionId\":\"1234InsId\",\"transactionIdentifier\":\"1234transId\"}],"
               + "\"slipData\":{\"messageLines\":[],\"slipWidth\":0},\"basketRef\":\"ref\",\"tranType\":"
               + "\"BALANCE_INQUIRY\",\"srcAccType\":\"CHEQUE\",\"stan\":\"12345stan\",\"rrn\":\"12345rrn\","
               + "\"customer\":{},\"amounts\":{},\"partPaymentAllowed\":true,\"overPaymentAllowed\":true,"
               + "\"account\":{}}";
   String serializedValueNull =
         "{\"id\":\"123456ID\",\"time\":\"2013-06-07T08:11:59.000Z\",\"originator\":{\"institution\":{"
               + "\"id\":\"0\",\"name\":\"someone\"},\"terminalId\":\"111\",\"merchant\":{}},\"client\":{"
               + "\"id\":\"1\",\"name\":\"someone1\"},\"settlementEntity\":{\"id\":\"2\",\"name\":"
               + "\"someone2\"},\"receiver\":{\"id\":\"3\",\"name\":\"someone3\"},\"thirdPartyIdentifiers\""
               + ":[{\"institutionId\":\"1234InsId\",\"transactionIdentifier\":\"1234transId\"}],"
               + "\"slipData\":{\"messageLines\":[],\"slipWidth\":0},\"basketRef\":\"ref\",\"tranType\":"
               + "\"BALANCE_INQUIRY\",\"srcAccType\":\"CHEQUE\",\"stan\":\"12345stan\",\"rrn\":\"12345rrn\","
               + "\"customer\":{},\"amounts\":{},\"partPaymentAllowed\":null,\"overPaymentAllowed\":null,"
               + "\"account\":{}}";

   @BeforeClass
   public void createObjects() {
      DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss.SSSZ");
      objectWithTrue =
            new AccountLookupResponse().account(new Account())
                  .customer(new Customer())
                  .amounts(new BillpayAmounts())
                  .partPaymentAllowed(true)
                  .overPaymentAllowed(true)
                  .id("123456ID")
                  .time(DateTime.parse("07/06/2013 08:11:59.000Z", formatter).toDateTime(DateTimeZone.UTC))
                  .originator(
                        new Originator().institution(new Institution().id("0").name("someone"))
                              .terminalId("111")
                              .merchant(new Merchant()))
                  .client(new Institution().id("1").name("someone1"))
                  .settlementEntity(new Institution().id("2").name("someone2"))
                  .receiver(new Institution().id("3").name("someone3"))
                  .slipData(new BillSlipData())
                  .basketRef("ref")
                  .tranType(TranType.BALANCE_INQUIRY)
                  .srcAccType(AccountType.CHEQUE)
                  .rrn("12345rrn")
                  .stan("12345stan")
                  .thirdPartyIdentifiers(
                        Arrays.asList(
                              new ThirdPartyIdentifier().institutionId("1234InsId")
                                    .transactionIdentifier("1234transId")));
      objectWithFalse =
            new AccountLookupResponse().account(new Account())
                  .customer(new Customer())
                  .amounts(new BillpayAmounts())
                  .partPaymentAllowed(false)
                  .overPaymentAllowed(false)
                  .id("123456ID")
                  .time(DateTime.parse("07/06/2013 08:11:59.000Z", formatter).toDateTime(DateTimeZone.UTC))
                  .originator(
                        new Originator().institution(new Institution().id("0").name("someone"))
                              .terminalId("111")
                              .merchant(new Merchant()))
                  .client(new Institution().id("1").name("someone1"))
                  .settlementEntity(new Institution().id("2").name("someone2"))
                  .receiver(new Institution().id("3").name("someone3"))
                  .slipData(new BillSlipData())
                  .basketRef("ref")
                  .tranType(TranType.BALANCE_INQUIRY)
                  .srcAccType(AccountType.CHEQUE)
                  .rrn("12345rrn")
                  .stan("12345stan")
                  .thirdPartyIdentifiers(
                        Arrays.asList(
                              new ThirdPartyIdentifier().institutionId("1234InsId")
                                    .transactionIdentifier("1234transId")));
      objectWithNull =
            new AccountLookupResponse().account(new Account())
                  .customer(new Customer())
                  .amounts(new BillpayAmounts())
                  .id("123456ID")
                  .time(DateTime.parse("07/06/2013 08:11:59.000Z", formatter).toDateTime(DateTimeZone.UTC))
                  .originator(
                        new Originator().institution(new Institution().id("0").name("someone"))
                              .terminalId("111")
                              .merchant(new Merchant()))
                  .client(new Institution().id("1").name("someone1"))
                  .settlementEntity(new Institution().id("2").name("someone2"))
                  .receiver(new Institution().id("3").name("someone3"))
                  .slipData(new BillSlipData())
                  .basketRef("ref")
                  .tranType(TranType.BALANCE_INQUIRY)
                  .srcAccType(AccountType.CHEQUE)
                  .rrn("12345rrn")
                  .stan("12345stan")
                  .thirdPartyIdentifiers(
                        Arrays.asList(
                              new ThirdPartyIdentifier().institutionId("1234InsId")
                                    .transactionIdentifier("1234transId")));
   }

   @Test
   public void testWithPartAndOverPayment() throws IOException {
      AccountLookupResponse deserialisedObject =
            JsonUtil.deserialize(serializedValueFalse, AccountLookupResponse.class);

      Assert.assertEquals(deserialisedObject.getPartPayment(), Optional.of(false));
      Assert.assertFalse(deserialisedObject.getPartPaymentAllowed());
      Assert.assertEquals(deserialisedObject.getOverPayment(), Optional.of(false));
      Assert.assertFalse(deserialisedObject.getOverPaymentAllowed());
   }

   @Test
   public void testPartAndOverPaymentTrue() throws IOException {
      AccountLookupResponse deserialisedObject = JsonUtil.deserialize(serializedValueTrue, AccountLookupResponse.class);

      Assert.assertEquals(deserialisedObject.getPartPayment(), Optional.of(true));
      Assert.assertTrue(deserialisedObject.getPartPaymentAllowed());
      Assert.assertEquals(deserialisedObject.getOverPayment(), Optional.of(true));
      Assert.assertTrue(deserialisedObject.getOverPaymentAllowed());
   }

   @Test
   public void testPartAndOverPaymentMissing() throws IOException {
      AccountLookupResponse deserialisedObject = JsonUtil.deserialize(serializedValueNull, AccountLookupResponse.class);

      Assert.assertEquals(deserialisedObject.getPartPayment(), Optional.empty());
      Assert.assertTrue(deserialisedObject.getPartPaymentAllowed());
      Assert.assertEquals(deserialisedObject.getOverPayment(), Optional.empty());
      Assert.assertTrue(deserialisedObject.getOverPaymentAllowed());
   }

   @Test(description = "Test we can serialise a model to the expected value.", dataProvider = "serialisedObjectDataProvider")
   public void testSerialisedObject(Object objectToSerialise, String expectedValue) throws IOException {
      String serializedValue = JsonUtil.serialize(objectToSerialise);
      Assert.assertEquals(serializedValue, expectedValue);
   }

   @Test(description = "Test we can deserialise a model to the expected value.", dataProvider = "deserialisedObjectDataProvider")
   public void testDeserialisedObject(String stringToDeserialise, Object expectedObject) throws IOException {
      Object deserialisedObject = JsonUtil.deserialize(stringToDeserialise, expectedObject.getClass());
      Assert.assertEquals(deserialisedObject.toString(), expectedObject.toString());
   }

   @Test(description = "Test we can deserialise what we serialised and get back to where we started.", dataProvider = "serialiseDeserialiseObjectDataProvider")
   public void testSerialiseDeserialiseObject(Object testObject) throws IOException {
      Assert.assertEquals(
            JsonUtil.deserialize(JsonUtil.serialize(testObject), testObject.getClass()).toString(),
            testObject.toString());
   }

   @Test(description = "Test we can serialise what we deserialised and get back to where we started.", dataProvider = "deserialiseSerialiseObjectDataProvider")
   public void testDeserialiseSerialiseObject(String testString, Class<?> classOfObject) throws IOException {
      Assert.assertEquals(JsonUtil.serialize(JsonUtil.deserialize(testString, classOfObject)), testString);
   }

   @Test(description = "Test we are set up to recursively validate sub-fields.", dataProvider = "recursiveValidationOnSubFieldsDataProvider")
   public void testRecursiveValidationOnSubFields(Object objectWithInvalidSubField, Object objectWithValidSubField)
         throws IOException {
      Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
      // should fail because a sub-field should fail validation
      Assert.assertFalse(validator.validate(objectWithInvalidSubField).isEmpty());
      // should pass because sub-fields are valid
      Assert.assertTrue(validator.validate(objectWithValidSubField).isEmpty());
   }

   @DataProvider(name = "serialisedObjectDataProvider")
   public Object[][] serialisedObjectDataProvider() {
      return new Object[][] { { objectWithTrue, serializedValueTrue }, { objectWithFalse, serializedValueFalse },
            { objectWithNull, serializedValueNull } };
   }

   @DataProvider(name = "deserialisedObjectDataProvider")
   public Object[][] deserialisedObjectDataProvider() {
      return new Object[][] {
            //@formatter:off
              {serializedValueTrue, objectWithTrue},
              {serializedValueFalse, objectWithFalse},
              {serializedValueNull, objectWithNull}
      };
   }

   @DataProvider(name = "serialiseDeserialiseObjectDataProvider")
   public Object[][] serialiseDeserialiseObjectDataProvider() {
      DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss.SSSZ");
      return new Object[][] {
              {objectWithTrue},
              {objectWithFalse},
              {objectWithNull}
      };
   }

   @DataProvider(name = "deserialiseSerialiseObjectDataProvider")
   public Object[][] deserialiseSerialiseObjectDataProvider() {
      return new Object[][] {
              {serializedValueTrue, AccountLookupResponse.class},
              {serializedValueFalse, AccountLookupResponse.class},
              {serializedValueNull, AccountLookupResponse.class}
      };
   }

   @DataProvider(name = "recursiveValidationOnSubFieldsDataProvider")
   public Object[][] recursiveValidationOnSubFieldsDataProvider() {
      return new Object[][] {
              {  //Validation should fail
                 new AccountLookupResponse().account(new Account().accountRef("12345678"))
                      .customer(new Customer())
                      .amounts(new BillpayAmounts().maxPayableAmount(new LedgerAmount().amount(null).currency("710").ledgerIndicator(LedgerAmount.LedgerIndicator.DEBIT)))
                      .partPaymentAllowed(true)
                      .overPaymentAllowed(true)
                      .id("123456ID")
                      .time(DateTime.now().toDateTime(DateTimeZone.UTC))
                      .originator(
                              new Originator().institution(new Institution().id("0").name("someone"))
                                      .terminalId("12345678")
                                      .merchant(new Merchant().merchantId("123451234512345").merchantName(new MerchantName().name("inst123")).merchantType("1000")))
                      .client(new Institution().id("1").name("someone1"))
                      .settlementEntity(new Institution().id("2").name("someone2"))
                      .receiver(new Institution().id("3").name("someone3"))
                      .slipData(new BillSlipData())
                      .basketRef("ref")
                      .tranType(TranType.BALANCE_INQUIRY)
                      .srcAccType(AccountType.CHEQUE)
                      .rrn("12345rrn")
                      .stan("12345stan")
                      .thirdPartyIdentifiers(
                      Arrays.asList(
                              new ThirdPartyIdentifier().institutionId("1234InsId")
                                      .transactionIdentifier("1234transId"))),
                      //Validation should pass
                      new AccountLookupResponse().account(new Account().accountRef("123456").dueDate(LocalDate.now()))
                      .customer(new Customer().firstName("Jane").lastName("Doe").address("Cape Town").contactNumber("08234567").idNumber("1234567890245"))
                      .amounts(new BillpayAmounts().approvedAmount(new LedgerAmount().amount(10000L).currency("710").ledgerIndicator(LedgerAmount.LedgerIndicator.DEBIT)))
                      .partPaymentAllowed(true)
                      .overPaymentAllowed(true)
                      .id("123456ID")
                      .time(DateTime.now().toDateTime(DateTimeZone.UTC))
                      .originator(
                              new Originator().institution(new Institution().id("0").name("someone"))
                                      .terminalId("12345678")
                                      .merchant(new Merchant().merchantId("123451234512345").merchantName(new MerchantName().name("inst123").country("ZA").region("WC").city("Cape Town")).merchantType("1000")))
                      .client(new Institution().id("1").name("someone1"))
                      .settlementEntity(new Institution().id("2").name("someone2"))
                      .receiver(new Institution().id("3").name("someone3"))
                      .slipData(new BillSlipData().phoneNumber("0823456789").messageLines(new ArrayList<>()).slipWidth(100))
                      .basketRef("ref")
                      .tranType(TranType.BALANCE_INQUIRY)
                      .srcAccType(AccountType.CHEQUE)
                      .destAccType(AccountType.DEFAULT)
                      .rrn("12345rrn")
                      .stan("12345stan")
                      .thirdPartyIdentifiers(
                      Arrays.asList(
                              new ThirdPartyIdentifier().institutionId("1234InsId")
                                      .transactionIdentifier("1234transId")))}
      };
   }
}
