package io.electrum.billpay.validation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = UuidValidator.class)
@Documented
public @interface Uuid {

   String message() default "{io.electrum.billpay.validation.Uuid.message}";

   Class<?>[] groups() default {};

   Class<? extends Payload>[] payload() default {};

   /**
    * Defines several {@link Uuid} annotations on the same element.
    *
    * @see io.electrum.billpay.validation.Uuid
    */
   @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
   @Retention(RUNTIME)
   @Documented
   @interface List {

      Uuid[] value();
   }
}
