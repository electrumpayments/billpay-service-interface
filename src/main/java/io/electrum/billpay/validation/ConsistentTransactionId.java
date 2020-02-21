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

import io.electrum.vas.model.Transaction;

/**
 * Checks that for two parameters (String,? extends Transaction), that the first String parameter is the same ID that is
 * used as the identifier in the Transaction.
 */
@Target({ METHOD, CONSTRUCTOR, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = ConsistentTransactionIdValidator.class)
@Documented
public @interface ConsistentTransactionId {

   String DEFAULT_MESSAGE = "";

   String message() default "has inconsistent transaction identifier";

   Class<?>[] groups() default {};

   Class<? extends Payload>[] payload() default {};
}
