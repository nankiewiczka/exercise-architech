package com.nankiewicz.exercise.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {
    private static final int MIN_LENGTH = 8;
    private static final String regex = String.format("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{%s,}$", MIN_LENGTH);
    private static final Pattern pattern = Pattern.compile(regex);

    @Override
    public void initialize(final ValidPassword constraintAnnotation) {

    }

    @Override
    public boolean isValid(final String password, final ConstraintValidatorContext constraintValidatorContext) {
        return password != null && isPasswordValid(password);
    }

    private boolean isPasswordValid(final String password) {
        final Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

}

