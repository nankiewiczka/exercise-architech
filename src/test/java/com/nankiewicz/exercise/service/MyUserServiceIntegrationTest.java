package com.nankiewicz.exercise.service;

import com.nankiewicz.exercise.dto.UserDto;
import com.nankiewicz.exercise.exception.UserExistsException;
import com.nankiewicz.exercise.model.User;
import com.nankiewicz.exercise.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static com.nankiewicz.exercise.TestUtils.PASSWORD;
import static com.nankiewicz.exercise.TestUtils.USERNAME;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class MyUserServiceIntegrationTest {
    @MockBean
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @Test
    void shouldRegisterUserWhenNoUsernameAlreadyRegistered() throws UserExistsException {
        //given
        given(userRepository.findByUsername(USERNAME)).willReturn(null);
        given(userRepository.save(any(User.class))).willReturn(new User(USERNAME, PASSWORD));
        final UserDto userDto = mock(UserDto.class);
        when(userDto.getUsername()).thenReturn(USERNAME);

        //when
        final User user = userService.register(userDto);

        //then
        assertThat(user.getUsername()).isEqualTo(userDto.getUsername());
    }

    @Test
    void shouldThrowExceptionWhenUsernameAlreadyRegistered() {
        //given
        given(userRepository.findByUsername(USERNAME)).willReturn(new User(USERNAME, PASSWORD));
        final UserDto userDto = mock(UserDto.class);
        when(userDto.getUsername()).thenReturn(USERNAME);

        //when
        final Exception exception = assertThrows(UserExistsException.class, () -> userService.register(userDto));

        //then
        assertThat(exception.getMessage()).isEqualTo("User exists in database.");
    }

}