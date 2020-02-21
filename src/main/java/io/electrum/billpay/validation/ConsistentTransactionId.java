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
 * Checks that for resources which have the transaction identifier as a path parameter (resulting in 8 parameters in
 * total), where the first two parameters are (String tranId, (? extends Transaction) entity), that the tranId is the
 * same as the identifier in the Transaction.
 */
@Constraint(validatedBy = ConsistentTransactionIdValidator.class)
@Target({ METHOD, CONSTRUCTOR, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Documented
public @interface ConsistentTransactionId {

   String DEFAULT_MESSAGE = "path param transaction identifier must match payload transaction identifier";

   String message() default DEFAULT_MESSAGE;

   Class<?>[] groups() default {};

   Class<? extends Payload>[] payload() default {};
}
