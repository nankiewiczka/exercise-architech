package com.nankiewicz.exercise.validation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UsernameValidatorTest {
    private final UsernameValidator validator = new UsernameValidator();

    private static Stream<String> validUsernames() {
        return Stream.of(
                "user1",
                "USER1",
                "User1",
                "User12",
                "UserNameName",
                "Longname",
                "12345678",
                "LONGNAME",
                "useruser"
        );
    }

    private static Stream<String> invalidUsernames() {
        return Stream.of(
                "",
                "user",
                "user!",
                "user123$#",
                null
        );
    }

    @ParameterizedTest
    @MethodSource("validUsernames")
    void shouldReturnTrueWhenUsernameMatchesCriteria(final String username) {
        assertTrue(validator.isValid(username, null));
    }

    @ParameterizedTest
    @MethodSource("invalidUsernames")
    void shouldReturnFalseWhenUsernameNotMatchCriteria(final String username) {
        assertFalse(validator.isValid(username, null));
    }

}