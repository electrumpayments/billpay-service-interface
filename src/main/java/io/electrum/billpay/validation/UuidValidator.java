package io.electrum.billpay.validation;

import java.util.UUID;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UuidValidator implements ConstraintValidator<Uuid, String> {

   @Override
   public void initialize(Uuid constraintAnnotation) {
   }

   @Override
   public boolean isValid(String value, ConstraintValidatorContext context) {
      // null values are valid
      if (value == null) {
         return true;
      }

      try {
         // Checks if value can be converted into a UUID and if the converted value is that same as the initial value.
         return UUID.fromString(value).toString().equals(value);
      } catch (Exception e) {
         context.disableDefaultConstraintViolation();
         context.buildConstraintViolationWithTemplate("{io.electrum.billpay.validation.Uuid.message}")
               .addConstraintViolation();
      }

      return false;
   }
}
