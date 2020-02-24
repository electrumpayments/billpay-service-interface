package io.electrum.billpay.validation;

import java.text.MessageFormat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;

import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorContextImpl;

import io.electrum.vas.model.BasicAdvice;

@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class ConsistentAdviceIdsValidator implements ConstraintValidator<ConsistentAdviceIds, Object[]> {

   @Override
   public void initialize(ConsistentAdviceIds constraintAnnotation) {
      // initialize is not needed
   }

   @Override
   public boolean isValid(Object[] value, ConstraintValidatorContext context) {
      if (value.length != 9) {
         throw new IllegalArgumentException("Illegal method signature.");
      }

      if (value[0] == null || value[1] == null || value[2] == null) {
         return true;
      }

      if (!(value[0] instanceof String) || !(value[1] instanceof String) || !(value[2] instanceof BasicAdvice)) {
         throw new IllegalArgumentException(
               "First three parameters of method signature must be String, String, ? extends BasicAdvice.");
      }

      BasicAdvice basicAdvice = (BasicAdvice) value[2];
      boolean isValidAdvice = value[0].equals(basicAdvice.getId());
      boolean isValidRequest = value[1].equals(basicAdvice.getRequestId());
      if (!(isValidAdvice && isValidRequest) && context instanceof ConstraintValidatorContextImpl) {
         ConstraintValidatorContextImpl contextImpl = (ConstraintValidatorContextImpl) context;
         context.disableDefaultConstraintViolation();
         if (!isValidAdvice) {
            context
                  .buildConstraintViolationWithTemplate(
                        MessageFormat.format("{0} must match entity id", contextImpl.getMethodParameterNames().get(0)))
                  .addConstraintViolation();
         }
         if (!isValidRequest) {
            context.buildConstraintViolationWithTemplate(
                  MessageFormat.format("{0} must match entity requestId", contextImpl.getMethodParameterNames().get(1)))
                  .addConstraintViolation();
         }
      }

      return isValidAdvice;
   }
}
