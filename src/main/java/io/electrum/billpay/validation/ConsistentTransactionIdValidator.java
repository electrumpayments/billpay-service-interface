package io.electrum.billpay.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import io.electrum.vas.model.Transaction;

public class ConsistentTransactionIdValidator implements ConstraintValidator<ConsistentTransactionId, Object[]> {

   private String parameterName;
   private Class<? extends Transaction> objectClass;

   @Override
   public void initialize(ConsistentTransactionId constraintAnnotation) {
   }

   @Override
   public boolean isValid(Object[] value, ConstraintValidatorContext context) {
      if (value.length != 8) {
         throw new IllegalArgumentException("Illegal method signature.");
      }

      if (value[0] == null || value[1] == null) {
         return true;
      }

      if (!(value[0] instanceof String) || !(value[1] instanceof Transaction)) {
         throw new IllegalArgumentException(
               "First two parameters of method signature must be String, ? extends Transaction.");
      }

      return value[0].equals(((Transaction) value[1]).getId());
   }
}