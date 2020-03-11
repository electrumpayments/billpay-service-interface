package io.electrum.billpay.validation;

import java.text.MessageFormat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;

import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorContextImpl;

import io.electrum.vas.model.Transaction;

@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class ConsistentTransactionIdValidator implements ConstraintValidator<ConsistentTransactionId, Object[]> {

   @Override
   public void initialize(ConsistentTransactionId constraintAnnotation) {
      // initialize is not needed
   }

   @Override
   public boolean isValid(Object[] value, ConstraintValidatorContext context) {
      if (value[0] == null || value[1] == null) {
         return true;
      }

      if (!(value[0] instanceof String) || !(value[1] instanceof Transaction)) {
         throw new IllegalArgumentException(
               "First two parameters of method signature must be String, ? extends Transaction.");
      }

      Transaction transaction = (Transaction) value[1];
      boolean isValid = value[0].equals(transaction.getId());
      if (!isValid && context instanceof ConstraintValidatorContextImpl) {
         ConstraintValidatorContextImpl contextImpl = (ConstraintValidatorContextImpl) context;
         context.disableDefaultConstraintViolation();
         context
               .buildConstraintViolationWithTemplate(
                     MessageFormat.format("{0} must match entity id", contextImpl.getMethodParameterNames().get(0)))
               .addConstraintViolation();
      }

      return isValid;
   }
}
