package com.nankiewicz.exercise.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsernameValidator implements ConstraintValidator<ValidUsername, String> {
    private static final int MIN_LENGTH = 5;
    private static final String regex = String.format("^[a-zA-Z0-9]{%s,}$", MIN_LENGTH);
    private static final Pattern pattern = Pattern.compile(regex);


    @Override
    public void initialize(final ValidUsername constraintAnnotation) {

    }

    @Override
    public boolean isValid(final String username, final ConstraintValidatorContext constraintValidatorContext) {
        return username != null && isUsernameValid(username);
    }

    private boolean isUsernameValid(final String username) {
        final Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }
}

