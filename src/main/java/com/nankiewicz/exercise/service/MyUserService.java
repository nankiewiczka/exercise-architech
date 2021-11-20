package com.nankiewicz.exercise.service;

import com.nankiewicz.exercise.dto.UserDto;
import com.nankiewicz.exercise.exception.UserExistsException;
import com.nankiewicz.exercise.model.User;
import com.nankiewicz.exercise.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class MyUserService implements UserService {
    private final UserRepository userRepository;

    public MyUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(final UserDto userDto) throws UserExistsException {
        if (usernameExists(userDto.getUsername())) {
            throw new UserExistsException("User exists in database.");
        }
        final User user = new User(userDto.getUsername(), userDto.getPassword());
        return userRepository.save(user);
    }

    private boolean usernameExists(final String username) {
        return Optional.ofNullable(userRepository.findByUsername(username)).isPresent();
    }

}
