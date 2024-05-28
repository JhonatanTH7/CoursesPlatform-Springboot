package com.Platform.Courses.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Platform.Courses.domain.entities.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

}
