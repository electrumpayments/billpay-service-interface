package io.electrum.billpay.validation;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.text.MessageFormat;
import java.util.List;
import java.util.UUID;

import io.electrum.vas.model.Transaction;
import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorContextImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.electrum.vas.model.BasicAdvice;

import javax.validation.ConstraintValidatorContext;

public class TestConsistentTransactionIdValidator {

   private ConsistentTransactionIdValidator validator;

   @BeforeMethod
   public void beforeMethod() {
      validator = new ConsistentTransactionIdValidator();
   }

   @Test
   public void isValid_successful() {
      // Setup
      //// Variables
      String id = UUID.randomUUID().toString();
      Transaction mockTransaction = mock(Transaction.class);
      Object[] parameters = { id, mockTransaction };
      ConstraintValidatorContextImpl mockContext = mock(ConstraintValidatorContextImpl.class);
      //// Interactions
      when(mockTransaction.getId()).thenReturn(id);

      // Test
      boolean isValid = validator.isValid(parameters, mockContext);

      // Assert
      assertTrue(isValid);
      verify(mockContext, times(0)).disableDefaultConstraintViolation();
   }

   @Test
   public void isValid_invalidId() {
      // Setup
      //// Variables
      String id = UUID.randomUUID().toString();
      Transaction mockTransaction = mock(Transaction.class);
      Object[] parameters = { id, mockTransaction };
      String idName = "path param id";
      List<String> mockMethodParameterNames = mock(List.class);
      ConstraintValidatorContext.ConstraintViolationBuilder mockViolationBuilder =
              mock(ConstraintValidatorContext.ConstraintViolationBuilder.class);
      ConstraintValidatorContextImpl mockContext = mock(ConstraintValidatorContextImpl.class);
      //// Interactions
      when(mockTransaction.getId()).thenReturn(UUID.randomUUID().toString());
      when(mockContext.getMethodParameterNames()).thenReturn(mockMethodParameterNames);
      when(mockMethodParameterNames.get(0)).thenReturn(idName);
      doReturn(mockViolationBuilder).when(mockContext).buildConstraintViolationWithTemplate(anyString());
      doReturn(null).when(mockViolationBuilder).addConstraintViolation();

      // Test
      boolean isValid = validator.isValid(parameters, mockContext);

      // Assert
      assertFalse(isValid);
      verify(mockContext, times(1)).disableDefaultConstraintViolation();
      verify(mockContext, times(1))
              .buildConstraintViolationWithTemplate(MessageFormat.format("{0} must match entity id", idName));
   }

   @Test
   public void isValid_invalidIdAndRequestId_contextNotConstraintValidatorContextImpl() {
      // Setup
      //// Variables
      String id = UUID.randomUUID().toString();
      Transaction mockTransaction = mock(Transaction.class);
      Object[] parameters = { id, mockTransaction };
      ConstraintValidatorContext.ConstraintViolationBuilder mockViolationBuilder =
              mock(ConstraintValidatorContext.ConstraintViolationBuilder.class);
      ConstraintValidatorContext mockContext = mock(ConstraintValidatorContext.class);
      //// Interactions
      when(mockTransaction.getId()).thenReturn(UUID.randomUUID().toString());
      doReturn(mockViolationBuilder).when(mockContext).buildConstraintViolationWithTemplate(anyString());
      doReturn(null).when(mockViolationBuilder).addConstraintViolation();

      // Test
      boolean isValid = validator.isValid(parameters, mockContext);

      // Assert
      assertFalse(isValid);
      verify(mockContext, times(0)).disableDefaultConstraintViolation();
   }

   @Test
   public void isValid_idNull() {
      // Setup
      Transaction mockTransaction = mock(Transaction.class);
      Object[] parameters = { null, mockTransaction };
      ConstraintValidatorContext mockContext = mock(ConstraintValidatorContext.class);

      // Test
      boolean isValid = validator.isValid(parameters, mockContext);

      // Assert
      assertTrue(isValid);
      verify(mockContext, times(0)).disableDefaultConstraintViolation();
   }

   @Test
   public void isValid_transactionNull() {
      // Setup
      String id = UUID.randomUUID().toString();
      Object[] parameters = { id, null };
      ConstraintValidatorContext mockContext = mock(ConstraintValidatorContext.class);

      // Test
      boolean isValid = validator.isValid(parameters, mockContext);

      // Assert
      assertTrue(isValid);
      verify(mockContext, times(0)).disableDefaultConstraintViolation();
   }

   @Test(expectedExceptions = IllegalArgumentException.class)
   public void isValid_idNotString() {
      // Setup
      Object id = new Object();
      Transaction mockTransaction = mock(Transaction.class);
      Object[] parameters = { id, mockTransaction };
      ConstraintValidatorContext mockContext = mock(ConstraintValidatorContext.class);

      // Test
      validator.isValid(parameters, mockContext);
   }

   @Test(expectedExceptions = IllegalArgumentException.class)
   public void isValid_transactionNotTransaction() {
      // Setup
      String id = UUID.randomUUID().toString();
      Object mockTransaction = mock(Object.class);
      Object[] parameters = { id, mockTransaction };
      ConstraintValidatorContext mockContext = mock(ConstraintValidatorContext.class);

      // Test
      validator.isValid(parameters, mockContext);
   }

}
