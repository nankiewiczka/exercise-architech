package com.nankiewicz.exercise.repository;

import com.nankiewicz.exercise.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static com.nankiewicz.exercise.TestUtils.PASSWORD;
import static com.nankiewicz.exercise.TestUtils.USERNAME;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class UserRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    void shouldFindUser() {
        //given
        final User user = new User(USERNAME, PASSWORD);
        entityManager.persist(user);
        entityManager.flush();

        //when
        final User result = userRepository.findByUsername(USERNAME);

        //then
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getUsername()).isEqualTo(USERNAME);
        assertThat(result.getPassword()).isEqualTo(PASSWORD);
    }

    @Test
    void shouldNotFindUser() {
        //given

        //when
        final User result = userRepository.findByUsername(USERNAME);

        //then
        assertThat(result).isNull();
    }
}
