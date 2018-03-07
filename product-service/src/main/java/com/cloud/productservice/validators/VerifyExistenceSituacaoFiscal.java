package com.cloud.productservice.validators;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Retention(RUNTIME)
@Target( { METHOD, FIELD, ANNOTATION_TYPE })
@Constraint(validatedBy = SituacaoFiscalValidator.class)
public @interface VerifyExistenceSituacaoFiscal {
    String message() default "Not found";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
