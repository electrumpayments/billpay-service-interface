package io.electrum.billpay.validation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Checks that for resources which have the transaction identifier and the request transaction identifier as a path
 * parameter , where the first three parameters are (String tranId, String requestId, (? extends BasicAdvice) entity),
 * that the tranId is the same as the identifier in the BasicAdvice, and that the requestId is the same as the request
 * identifier in the BasicAdvice.
 */
@Constraint(validatedBy = ConsistentAdviceIdsValidator.class)
@Target({ METHOD })
@Retention(RUNTIME)
@Documented
public @interface ConsistentAdviceIds {

   String DEFAULT_MESSAGE =
         "path param adviceId must match entity id and path param request requestId/paymentId/refundId must match entity requestId";

   String message() default DEFAULT_MESSAGE;

   Class<?>[] groups() default {};

   Class<? extends Payload>[] payload() default {};
}