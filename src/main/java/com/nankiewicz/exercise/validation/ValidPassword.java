package com.nankiewicz.exercise.validation;


import com.nankiewicz.exercise.validation.PasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target({ElementType.TYPE, ElementType.FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
public @interface ValidPassword {
    String message() default "Invalid password. Password must have a minimum length of 8 characters and contains at least 1 number, 1\n" +
            "uppercase, and 1 lowercase character.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
