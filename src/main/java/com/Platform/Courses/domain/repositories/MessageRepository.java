package com.Platform.Courses.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Platform.Courses.domain.entities.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
