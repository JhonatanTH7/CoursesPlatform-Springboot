package com.Platform.Courses.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Platform.Courses.api.dto.request.EnrollmentRequest;
import com.Platform.Courses.api.dto.response.course.CourseBasicResponse;
import com.Platform.Courses.api.dto.response.enrollment.EnrollmentResponse;
import com.Platform.Courses.domain.entities.Enrollment;
import com.Platform.Courses.domain.repositories.CourseRepository;
import com.Platform.Courses.domain.repositories.EnrollmentRepository;
import com.Platform.Courses.domain.repositories.UserRepository;
import com.Platform.Courses.infrastructure.abstract_services.IEnrollmentService;
import com.Platform.Courses.infrastructure.helpers.EntityToEntity;
import com.Platform.Courses.util.exceptions.ResourceNotFound;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EnrollmentService implements IEnrollmentService {

    @Autowired
    private final EnrollmentRepository enrollmentRepository;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final CourseRepository courseRepository;

    @Override
    public EnrollmentResponse getById(Long id) {
        return this.entityToResponse(this.find(id));
    }

    @Override
    public EnrollmentResponse create(EnrollmentRequest request) {
        Enrollment enrollment = EntityToEntity.entityToEntity(request, Enrollment.class);
        enrollment.setStudent(this.userRepository.findById(request.getIdStudent())
                .orElseThrow(() -> new ResourceNotFound("No student found with the id: " + request.getIdStudent())));
        enrollment.setCourse(this.courseRepository.findById(request.getIdCourse())
                .orElseThrow(() -> new ResourceNotFound("No course found with the id: " + request.getIdCourse())));
        return this.entityToResponse(this.enrollmentRepository.save(enrollment));
    }

    @Override
    public void delete(Long id) {
        this.enrollmentRepository.delete(find(id));
    }

    private Enrollment find(Long id) {
        return this.enrollmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("No enrollment found with the id: " + id));
    }

    private EnrollmentResponse entityToResponse(Enrollment entity) {
        EnrollmentResponse enrollmentResponse = EntityToEntity.entityToEntity(entity, EnrollmentResponse.class);
        enrollmentResponse.setStudent(EntityToEntity.userToBasicResponse(entity.getStudent()));
        enrollmentResponse.setCourse(EntityToEntity.entityToEntity(entity.getCourse(), CourseBasicResponse.class));
        enrollmentResponse.getCourse()
                .setInstructor(EntityToEntity.userToBasicResponse(entity.getCourse().getInstructor()));
        return enrollmentResponse;
    }

}
