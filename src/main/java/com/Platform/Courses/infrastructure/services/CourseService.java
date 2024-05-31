package com.Platform.Courses.infrastructure.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.Platform.Courses.api.dto.request.CourseRequest;
import com.Platform.Courses.api.dto.request.update_request.UpdateCourseRequest;
import com.Platform.Courses.api.dto.response.CourseResponse;
import com.Platform.Courses.api.dto.response.EnrollmentInCourseResponse;
import com.Platform.Courses.api.dto.response.LessonBasicResponse;
import com.Platform.Courses.api.dto.response.MessageInCourseResponse;
import com.Platform.Courses.domain.entities.Course;
import com.Platform.Courses.domain.entities.Enrollment;
import com.Platform.Courses.domain.entities.Lesson;
import com.Platform.Courses.domain.entities.Message;
import com.Platform.Courses.domain.repositories.CourseRepository;
import com.Platform.Courses.domain.repositories.UserRepository;
import com.Platform.Courses.infrastructure.abstract_services.ICourseService;
import com.Platform.Courses.infrastructure.helpers.EntityToEntity;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CourseService implements ICourseService {

    @Autowired
    private final CourseRepository courseRepository;

    @Autowired
    private final UserRepository userRepository;

    @Override
    public Page<CourseResponse> getAll(int page, int size) {
        if (page < 0)
            page = 0;
        PageRequest pagination = PageRequest.of(page, size);
        return this.courseRepository.findAll(pagination).map(this::entityToResponse);
    }

    @Override
    public CourseResponse getById(Long id) {
        return entityToResponse(find(id));
    }

    @Override
    public CourseResponse create(CourseRequest request) {
        Course course = EntityToEntity.entityToEntity(request, Course.class);
        course.setInstructor(userRepository.findById(request.getIdInstructor()).orElseThrow());
        course.setEnrollments(new ArrayList<>());
        course.setMessages(new ArrayList<>());
        course.setLessons(new ArrayList<>());
        return this.entityToResponse(this.courseRepository.save(course));
    }

    @Override
    public CourseResponse update(UpdateCourseRequest request, Long id) {
        Course oldCourse = this.find(id);
        Course courseInfoUpdated = EntityToEntity.entityToEntity(request, Course.class);
        courseInfoUpdated.setIdCourse(id);
        courseInfoUpdated.setInstructor(oldCourse.getInstructor());
        courseInfoUpdated.setEnrollments(oldCourse.getEnrollments());
        courseInfoUpdated.setMessages(oldCourse.getMessages());
        courseInfoUpdated.setLessons(oldCourse.getLessons());
        return this.entityToResponse(this.courseRepository.save(courseInfoUpdated));
    }

    @Override
    public void delete(Long id) {
        this.courseRepository.delete(this.find(id));
    }

    private Course find(Long id) {
        return this.courseRepository.findById(id).orElseThrow();
    }

    private CourseResponse entityToResponse(Course entity) {
        List<EnrollmentInCourseResponse> enrollments = entity.getEnrollments().stream().map(this::enrollmentToResponse)
                .toList();
        List<MessageInCourseResponse> messages = entity.getMessages().stream().map(this::messageToResponse)
                .toList();
        List<LessonBasicResponse> lessons = entity.getLessons().stream().map(this::lessonToResponse)
                .toList();
        return CourseResponse
                .builder()
                .idCourse(entity.getIdCourse())
                .courseName(entity.getCourseName())
                .description(entity.getDescription())
                .instructor(EntityToEntity.userToBasicResponse(entity.getInstructor()))
                .enrollments(enrollments)
                .messages(messages)
                .lessons(lessons)
                .build();
    }

    private EnrollmentInCourseResponse enrollmentToResponse(Enrollment entity) {
        return EnrollmentInCourseResponse
                .builder()
                .idEnrollment(entity.getIdEnrollment())
                .enrollmentDate(entity.getEnrollmentDate())
                .student(EntityToEntity.userToBasicResponse(entity.getStudent()))
                .build();
    }

    private MessageInCourseResponse messageToResponse(Message entity) {
        MessageInCourseResponse messageInCourseResponse = EntityToEntity.entityToEntity(entity,
                MessageInCourseResponse.class);
        messageInCourseResponse.setSender(EntityToEntity.userToBasicResponse(entity.getSender()));
        messageInCourseResponse.setReceiver(EntityToEntity.userToBasicResponse(entity.getReceiver()));
        return messageInCourseResponse;
    }

    private LessonBasicResponse lessonToResponse(Lesson entity) {
        return EntityToEntity.entityToEntity(entity, LessonBasicResponse.class);
    }
}
