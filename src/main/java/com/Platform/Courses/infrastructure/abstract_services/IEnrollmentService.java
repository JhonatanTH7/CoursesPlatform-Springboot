package com.Platform.Courses.infrastructure.abstract_services;

import org.springframework.stereotype.Service;

import com.Platform.Courses.api.dto.request.EnrollmentRequest;
import com.Platform.Courses.api.dto.response.enrollment.EnrollmentResponse;

@Service
public interface IEnrollmentService {

    EnrollmentResponse getById(Long id);

    EnrollmentResponse create(EnrollmentRequest request);

    void delete(Long id);

}
