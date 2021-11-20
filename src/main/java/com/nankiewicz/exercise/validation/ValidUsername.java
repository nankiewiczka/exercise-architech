package com.nankiewicz.exercise.validation;


import com.nankiewicz.exercise.validation.UsernameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target({ElementType.TYPE, ElementType.FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = UsernameValidator.class)
public @interface ValidUsername {
    String message() default "Invalid username. Username must have a minimum length of 5 characters and contain alpha-numeric value only";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
