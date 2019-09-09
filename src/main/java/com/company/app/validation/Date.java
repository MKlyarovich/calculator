package com.company.app.validation;

import com.company.app.validation.impl.DateValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD, PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = DateValidator.class)
public @interface Date {
    String message() default "The date must match the format DD MM YYYY, the year must be between 1900 and 2010";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}