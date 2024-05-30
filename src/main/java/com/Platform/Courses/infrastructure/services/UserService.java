package com.Platform.Courses.infrastructure.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.Platform.Courses.api.dto.request.UserRequest;
import com.Platform.Courses.api.dto.request.update_request.UpdateUserRequest;
import com.Platform.Courses.api.dto.response.CourseInUserResponse;
import com.Platform.Courses.api.dto.response.EnrollmentInUserResponse;
import com.Platform.Courses.api.dto.response.MessageReceiverBasicResponse;
import com.Platform.Courses.api.dto.response.MessageSenderBasicResponse;
import com.Platform.Courses.api.dto.response.SubmissionInUserResponse;
import com.Platform.Courses.api.dto.response.UserBasicResponse;
import com.Platform.Courses.api.dto.response.UserResponse;
import com.Platform.Courses.domain.entities.Course;
import com.Platform.Courses.domain.entities.Enrollment;
import com.Platform.Courses.domain.entities.Message;
import com.Platform.Courses.domain.entities.Submission;
import com.Platform.Courses.domain.entities.User;
import com.Platform.Courses.domain.repositories.UserRepository;
import com.Platform.Courses.infrastructure.abstract_services.IUserService;
import com.Platform.Courses.infrastructure.helpers.EntityToEntity;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    @Autowired
    private final UserRepository userRepository;

    @Override
    public Page<UserResponse> getAll(int page, int size) {
        if (page < 0)
            page = 0;
        PageRequest pagination = PageRequest.of(page, size);
        return this.userRepository.findAll(pagination).map(this::entityToResponse);
    }

    @Override
    public UserResponse getById(Long id) {
        return entityToResponse(find(id));
    }

    @Override
    public UserResponse create(UserRequest request) {
        User user = EntityToEntity.entityToEntity(request, User.class);
        user.setSentMessages(new ArrayList<>());
        user.setReceivedMessages(new ArrayList<>());
        user.setSubmissions(new ArrayList<>());
        user.setEnrollments(new ArrayList<>());
        user.setCourses(new ArrayList<>());
        return this.entityToResponse(this.userRepository.save(user));
    }

    @Override
    public UserResponse update(UpdateUserRequest request, Long id) {
        User oldUser = this.find(id);
        User userInfoUpdated = EntityToEntity.entityToEntity(request, User.class);
        userInfoUpdated.setIdUser(id);
        userInfoUpdated.setRole(oldUser.getRole());
        userInfoUpdated.setSentMessages(oldUser.getSentMessages());
        userInfoUpdated.setReceivedMessages(oldUser.getReceivedMessages());
        userInfoUpdated.setSubmissions(oldUser.getSubmissions());
        userInfoUpdated.setEnrollments(oldUser.getEnrollments());
        userInfoUpdated.setCourses(oldUser.getCourses());
        return this.entityToResponse(this.userRepository.save(userInfoUpdated));
    }

    @Override
    public void delete(Long id) {
        this.userRepository.delete(this.find(id));
    }

    private User find(Long id) {
        return this.userRepository.findById(id).orElseThrow();
    }

    private UserResponse entityToResponse(User entity) {
        List<MessageSenderBasicResponse> sentMessages = entity.getSentMessages().stream().map(this::senderToResponse)
                .toList();
        List<MessageReceiverBasicResponse> receivedMessages = entity.getReceivedMessages().stream()
                .map(this::receiverToResponse)
                .toList();
        List<SubmissionInUserResponse> submissions = entity.getSubmissions().stream().map(this::submissionToResponse)
                .toList();
        List<EnrollmentInUserResponse> enrollments = entity.getEnrollments().stream().map(this::enrollmentToResponse)
                .toList();
        List<CourseInUserResponse> courses = entity.getCourses().stream().map(this::courseToResponse).toList();
        return UserResponse
                .builder()
                .idUser(entity.getIdUser())
                .userName(entity.getUserName())
                .password(entity.getPassword())
                .email(entity.getEmail())
                .fullName(entity.getFullName())
                .role(entity.getRole())
                .sentMessages(sentMessages)
                .receivedMessages(receivedMessages)
                .submissions(submissions)
                .enrollments(enrollments)
                .courses(courses)
                .build();
    }

    private MessageSenderBasicResponse senderToResponse(Message entity) {
        return MessageSenderBasicResponse
                .builder()
                .idMessage(entity.getIdMessage())
                .messageContent(entity.getMessageContent())
                .sentDate(entity.getSentDate())
                .receiver(EntityToEntity.entityToEntity(entity.getReceiver(), UserBasicResponse.class))
                .courseName(entity.getCourse().getCourseName())
                .build();
    }

    private MessageReceiverBasicResponse receiverToResponse(Message entity) {
        return MessageReceiverBasicResponse
                .builder()
                .idMessage(entity.getIdMessage())
                .messageContent(entity.getMessageContent())
                .sentDate(entity.getSentDate())
                .sender(EntityToEntity.entityToEntity(entity.getSender(), UserBasicResponse.class))
                .courseName(entity.getCourse().getCourseName())
                .build();
    }

    private SubmissionInUserResponse submissionToResponse(Submission entity) {
        SubmissionInUserResponse submissionInUserResponse = EntityToEntity.entityToEntity(entity,
                SubmissionInUserResponse.class);
        submissionInUserResponse.setAssignmentTitle(entity.getAssignment().getAssignmentTitle());
        return submissionInUserResponse;
    }

    private EnrollmentInUserResponse enrollmentToResponse(Enrollment entity) {
        EnrollmentInUserResponse enrollmentInUserResponse = EntityToEntity.entityToEntity(entity,
                EnrollmentInUserResponse.class);
        enrollmentInUserResponse
                .setCourse(courseToResponse(entity.getCourse()));
        return enrollmentInUserResponse;
    }

    private CourseInUserResponse courseToResponse(Course entity) {
        CourseInUserResponse courseInUserResponse = EntityToEntity.entityToEntity(entity,
                CourseInUserResponse.class);
        courseInUserResponse
                .setInstructor(EntityToEntity.entityToEntity(entity.getInstructor(), UserBasicResponse.class));
        return courseInUserResponse;
    }
}
