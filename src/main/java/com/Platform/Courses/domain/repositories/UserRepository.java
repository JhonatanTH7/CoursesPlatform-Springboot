package com.Platform.Courses.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Platform.Courses.domain.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
