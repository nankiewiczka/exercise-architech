package com.nankiewicz.exercise;

import com.nankiewicz.exercise.controller.AppController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ExerciseApplicationSmokeTest {
    @Autowired
    private AppController controller;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

}
