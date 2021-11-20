package com.nankiewicz.exercise.service;

import com.nankiewicz.exercise.model.User;
import com.nankiewicz.exercise.dto.UserDto;
import com.nankiewicz.exercise.exception.UserExistsException;

public interface UserService {
    User register(final UserDto userDto) throws UserExistsException;
}
