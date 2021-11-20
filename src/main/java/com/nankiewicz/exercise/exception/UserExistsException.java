package com.nankiewicz.exercise.exception;

public class UserExistsException extends Exception {
    public UserExistsException(final String message) {
        super(message);
    }
}
