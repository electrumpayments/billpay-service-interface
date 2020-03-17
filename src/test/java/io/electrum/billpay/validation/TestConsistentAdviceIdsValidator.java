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

import javax.validation.ConstraintValidatorContext;

import io.electrum.vas.model.Transaction;
import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorContextImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.electrum.vas.model.BasicAdvice;

public class TestConsistentAdviceIdsValidator {

   private ConsistentAdviceIdsValidator validator;

   @BeforeMethod
   public void beforeMethod() {
      validator = new ConsistentAdviceIdsValidator();
   }

   @Test
   public void isValid_successful() {
      // Setup
      //// Variables
      String id = UUID.randomUUID().toString();
      String requestId = UUID.randomUUID().toString();
      BasicAdvice mockBasicAdvice = mock(BasicAdvice.class);
      Object[] parameters = { id, requestId, mockBasicAdvice };
      ConstraintValidatorContextImpl mockContext = mock(ConstraintValidatorContextImpl.class);
      //// Interactions
      when(mockBasicAdvice.getId()).thenReturn(id);
      when(mockBasicAdvice.getRequestId()).thenReturn(requestId);

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
      String requestId = UUID.randomUUID().toString();
      BasicAdvice mockBasicAdvice = mock(BasicAdvice.class);
      Object[] parameters = { id, requestId, mockBasicAdvice };
      String idName = "path param id";
      List<String> mockMethodParameterNames = mock(List.class);
      ConstraintValidatorContext.ConstraintViolationBuilder mockViolationBuilder =
            mock(ConstraintValidatorContext.ConstraintViolationBuilder.class);
      ConstraintValidatorContextImpl mockContext = mock(ConstraintValidatorContextImpl.class);
      //// Interactions
      when(mockBasicAdvice.getId()).thenReturn(UUID.randomUUID().toString());
      when(mockBasicAdvice.getRequestId()).thenReturn(requestId);
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
   public void isValid_invalidRequestId() {
      // Setup
      //// Variables
      String id = UUID.randomUUID().toString();
      String requestId = UUID.randomUUID().toString();
      BasicAdvice mockBasicAdvice = mock(BasicAdvice.class);
      Object[] parameters = { id, requestId, mockBasicAdvice };
      String requestIdName = "path param requestId";
      List<String> mockMethodParameterNames = mock(List.class);
      ConstraintValidatorContext.ConstraintViolationBuilder mockViolationBuilder =
            mock(ConstraintValidatorContext.ConstraintViolationBuilder.class);
      ConstraintValidatorContextImpl mockContext = mock(ConstraintValidatorContextImpl.class);
      //// Interactions
      when(mockBasicAdvice.getId()).thenReturn(id);
      when(mockBasicAdvice.getRequestId()).thenReturn(UUID.randomUUID().toString());
      when(mockContext.getMethodParameterNames()).thenReturn(mockMethodParameterNames);
      when(mockMethodParameterNames.get(1)).thenReturn(requestIdName);
      doReturn(mockViolationBuilder).when(mockContext).buildConstraintViolationWithTemplate(anyString());
      doReturn(null).when(mockViolationBuilder).addConstraintViolation();

      // Test
      boolean isValid = validator.isValid(parameters, mockContext);

      // Assert
      assertFalse(isValid);
      verify(mockContext, times(1)).disableDefaultConstraintViolation();
      verify(mockContext, times(1)).buildConstraintViolationWithTemplate(
            MessageFormat.format("{0} must match entity requestId", requestIdName));
   }

   @Test
   public void isValid_invalidIdAndRequestId() {
      // Setup
      //// Variables
      String id = UUID.randomUUID().toString();
      String requestId = UUID.randomUUID().toString();
      BasicAdvice mockBasicAdvice = mock(BasicAdvice.class);
      Object[] parameters = { id, requestId, mockBasicAdvice };
      String idName = "path param id";
      String requestIdName = "path param requestId";
      List<String> mockMethodParameterNames = mock(List.class);
      ConstraintValidatorContext.ConstraintViolationBuilder mockViolationBuilder =
            mock(ConstraintValidatorContext.ConstraintViolationBuilder.class);
      ConstraintValidatorContextImpl mockContext = mock(ConstraintValidatorContextImpl.class);
      //// Interactions
      when(mockBasicAdvice.getId()).thenReturn(UUID.randomUUID().toString());
      when(mockBasicAdvice.getRequestId()).thenReturn(UUID.randomUUID().toString());
      when(mockContext.getMethodParameterNames()).thenReturn(mockMethodParameterNames);
      when(mockMethodParameterNames.get(0)).thenReturn(idName);
      when(mockMethodParameterNames.get(1)).thenReturn(requestIdName);
      doReturn(mockViolationBuilder).when(mockContext).buildConstraintViolationWithTemplate(anyString());
      doReturn(null).when(mockViolationBuilder).addConstraintViolation();

      // Test
      boolean isValid = validator.isValid(parameters, mockContext);

      // Assert
      assertFalse(isValid);
      verify(mockContext, times(1)).disableDefaultConstraintViolation();
      verify(mockContext, times(1))
            .buildConstraintViolationWithTemplate(MessageFormat.format("{0} must match entity id", idName));
      verify(mockContext, times(1)).buildConstraintViolationWithTemplate(
            MessageFormat.format("{0} must match entity requestId", requestIdName));
   }

   @Test
   public void isValid_invalidIdAndRequestId_contextNotConstraintValidatorContextImpl() {
      // Setup
      //// Variables
      String id = UUID.randomUUID().toString();
      String requestId = UUID.randomUUID().toString();
      BasicAdvice mockBasicAdvice = mock(BasicAdvice.class);
      Object[] parameters = { id, requestId, mockBasicAdvice };
      ConstraintValidatorContext.ConstraintViolationBuilder mockViolationBuilder =
            mock(ConstraintValidatorContext.ConstraintViolationBuilder.class);
      ConstraintValidatorContext mockContext = mock(ConstraintValidatorContext.class);
      //// Interactions
      when(mockBasicAdvice.getId()).thenReturn(UUID.randomUUID().toString());
      when(mockBasicAdvice.getRequestId()).thenReturn(UUID.randomUUID().toString());
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
      String requestId = UUID.randomUUID().toString();
      BasicAdvice mockBasicAdvice = mock(BasicAdvice.class);
      Object[] parameters = { null, requestId, mockBasicAdvice };
      ConstraintValidatorContext mockContext = mock(ConstraintValidatorContext.class);

      // Test
      boolean isValid = validator.isValid(parameters, mockContext);

      // Assert
      assertTrue(isValid);
      verify(mockContext, times(0)).disableDefaultConstraintViolation();
   }

   @Test
   public void isValid_requestIdNull() {
      // Setup
      String id = UUID.randomUUID().toString();
      BasicAdvice mockBasicAdvice = mock(BasicAdvice.class);
      Object[] parameters = { id, null, mockBasicAdvice };
      ConstraintValidatorContext mockContext = mock(ConstraintValidatorContext.class);

      // Test
      boolean isValid = validator.isValid(parameters, mockContext);

      // Assert
      assertTrue(isValid);
      verify(mockContext, times(0)).disableDefaultConstraintViolation();
   }

   @Test
   public void isValid_basicAdviceNull() {
      // Setup
      String id = UUID.randomUUID().toString();
      String requestId = UUID.randomUUID().toString();
      Object[] parameters = { id, requestId, null };
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
      String requestId = UUID.randomUUID().toString();
      BasicAdvice mockBasicAdvice = mock(BasicAdvice.class);
      Object[] parameters = { id, requestId, mockBasicAdvice };
      ConstraintValidatorContext mockContext = mock(ConstraintValidatorContext.class);

      // Test
      validator.isValid(parameters, mockContext);
   }

   @Test(expectedExceptions = IllegalArgumentException.class)
   public void isValid_requestIdNotString() {
      // Setup
      String id = UUID.randomUUID().toString();
      Object requestId = new Object();
      BasicAdvice mockBasicAdvice = mock(BasicAdvice.class);
      Object[] parameters = { id, requestId, mockBasicAdvice };
      ConstraintValidatorContext mockContext = mock(ConstraintValidatorContext.class);

      // Test
      validator.isValid(parameters, mockContext);
   }

   @Test(expectedExceptions = IllegalArgumentException.class)
   public void isValid_basicAdviceNotBasicAdvice() {
      // Setup
      String id = UUID.randomUUID().toString();
      String requestId = UUID.randomUUID().toString();
      Object mockBasicAdvice = mock(Object.class);
      Object[] parameters = { id, requestId, mockBasicAdvice };
      ConstraintValidatorContext mockContext = mock(ConstraintValidatorContext.class);

      // Test
      validator.isValid(parameters, mockContext);
   }

}
