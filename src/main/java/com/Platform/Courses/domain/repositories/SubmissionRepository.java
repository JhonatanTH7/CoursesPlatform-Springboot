package com.Platform.Courses.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Platform.Courses.domain.entities.Submission;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {

}
