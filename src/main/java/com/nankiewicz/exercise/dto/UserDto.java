package com.nankiewicz.exercise.dto;

import com.nankiewicz.exercise.validation.ValidPassword;
import com.nankiewicz.exercise.validation.ValidUsername;

public class UserDto {
    @ValidUsername
    private String username;
    @ValidPassword
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }
}
