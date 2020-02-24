package io.electrum.billpay.validation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Checks that for resources which have the transaction identifier and the request transaction identifier as a path
 * parameter (resulting in 9 parameters in total), where the first three parameters are (String tranId, String
 * requestId, (? extends Transaction) entity), that the tranId is the same as the identifier in the BasicAdvice, and
 * that the requestId is the same as the request identifier in the BasicAdvice.
 */
@Constraint(validatedBy = ConsistentAdviceIdsValidator.class)
@Target({ METHOD, CONSTRUCTOR, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Documented
public @interface ConsistentAdviceIds {

   String DEFAULT_MESSAGE =
         "path param transaction identifier must match entity id and path param request transaction identifier must match entity request transaction identifier";

   String message() default DEFAULT_MESSAGE;

   Class<?>[] groups() default {};

   Class<? extends Payload>[] payload() default {};
}
