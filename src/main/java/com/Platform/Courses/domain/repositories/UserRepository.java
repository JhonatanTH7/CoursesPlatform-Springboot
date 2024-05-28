package com.Platform.Courses.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Platform.Courses.domain.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
