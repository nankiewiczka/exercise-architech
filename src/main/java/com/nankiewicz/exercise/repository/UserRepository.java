package com.nankiewicz.exercise.repository;

import com.nankiewicz.exercise.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(final String userName);
}

