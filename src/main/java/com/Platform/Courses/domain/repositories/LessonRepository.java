package com.Platform.Courses.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Platform.Courses.domain.entities.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Long> {

}
