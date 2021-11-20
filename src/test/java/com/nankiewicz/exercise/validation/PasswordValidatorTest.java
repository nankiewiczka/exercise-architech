package com.nankiewicz.exercise.validation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PasswordValidatorTest {
    private final PasswordValidator validator = new PasswordValidator();

    private static Stream<String> validPasswords() {
        return Stream.of(
                "aB1aaaaa",
                "aB1aaaaaxxx",
                "Ab1xxxxx",
                "Ab1xxxxxx",
                "1aBaaaaa",
                "passworD1!",
                "12345678aA",
                "12345678aaBBB"
        );
    }

    private static Stream<String> invalidPasswords() {
        return Stream.of(
                "",
                "1",
                "a",
                "B",
                "a1",
                "A1",
                "aA",
                "12345aB",
                "password",
                "12345678",
                "PASSWORD",
                "password1",
                "passwordB",
                "PASSWORD1",
                "PASSWORDy",
                null
        );
    }

    @ParameterizedTest
    @MethodSource("validPasswords")
    void shouldReturnTrueWhenPasswordMatchesCriteria(final String password) {
        //given
        //when
        //then
        assertTrue(validator.isValid(password, null));
    }

    @ParameterizedTest
    @MethodSource("invalidPasswords")
    void shouldReturnFalseWhenPasswordNotMatchCriteria(final String password) {
        //given
        //when
        //then
        assertFalse(validator.isValid(password, null));
    }

}