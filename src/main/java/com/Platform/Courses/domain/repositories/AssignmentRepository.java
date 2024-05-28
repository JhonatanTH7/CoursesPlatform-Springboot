package com.Platform.Courses.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Platform.Courses.domain.entities.Assignment;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

}