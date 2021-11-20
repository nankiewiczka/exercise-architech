package com.nankiewicz.exercise.controller;

import com.nankiewicz.exercise.dto.UserDto;
import com.nankiewicz.exercise.exception.UserExistsException;
import com.nankiewicz.exercise.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

import static java.lang.String.format;

@Controller
public class AppController implements WebMvcConfigurer {

    private final UserService userService;

    public AppController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home(UserDto userDto) {
        return "register";
    }

    @GetMapping("/register")
    public String getRegister(UserDto userDto) {
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid final UserDto userDto,
                           final BindingResult bindingResult,
                           final Model model) {
        if (bindingResult.hasErrors()) {
            return "register";
        }

        try {
            userService.register(userDto);
        } catch (UserExistsException e) {
            bindingResult.rejectValue(
                    "username",
                    "userDto.username",
                    format("Invalid username. Username [%s] is already registered.", userDto.getUsername()));
            model.addAttribute("userDto", userDto);
            return "register";
        }

        return "done";
    }
}
