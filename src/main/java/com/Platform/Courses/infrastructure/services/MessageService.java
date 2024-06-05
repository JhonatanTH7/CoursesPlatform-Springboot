package com.Platform.Courses.infrastructure.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Platform.Courses.api.dto.request.MessageRequest;
import com.Platform.Courses.api.dto.response.course.CourseBasicResponse;
import com.Platform.Courses.api.dto.response.message.MessageResponse;
import com.Platform.Courses.domain.entities.Course;
import com.Platform.Courses.domain.entities.Message;
import com.Platform.Courses.domain.entities.User;
import com.Platform.Courses.domain.repositories.CourseRepository;
import com.Platform.Courses.domain.repositories.MessageRepository;
import com.Platform.Courses.domain.repositories.UserRepository;
import com.Platform.Courses.infrastructure.abstract_services.IMessageService;
import com.Platform.Courses.infrastructure.helpers.EntityToEntity;
import com.Platform.Courses.util.exceptions.ResourceNotFound;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MessageService implements IMessageService {

    @Autowired
    private final MessageRepository messageRepository;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final CourseRepository courseRepository;

    @Override
    public MessageResponse create(MessageRequest request) {
        Message message = EntityToEntity.entityToEntity(request, Message.class);
        message.setCourse(this.courseRepository.findById(request.getIdCourse())
                .orElseThrow(() -> new ResourceNotFound("No course found with the id: " + request.getIdCourse())));
        message.setSender(findUser(request.getIdSender()));
        message.setReceiver(findUser(request.getIdReceiver()));
        return this.entityToResponse(this.messageRepository.save(message));
    }

    @Override
    public List<MessageResponse> findMessagesBetweenTwoUsers(Long userId1, Long userId2) {
        findUser(userId1);
        findUser(userId2);
        return this.messageRepository.findMessagesBetweenTwoUsers(userId1, userId2).stream().map(this::entityToResponse)
                .toList();
    }

    private User findUser(Long id) {
        return this.userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("No user found with the id: " + id));
    }

    private MessageResponse entityToResponse(Message entity) {
        MessageResponse messageResponse = EntityToEntity.entityToEntity(entity, MessageResponse.class);
        messageResponse.setReceiver(EntityToEntity.userToBasicResponse(entity.getReceiver()));
        messageResponse.setSender(EntityToEntity.userToBasicResponse(entity.getSender()));
        Course course = entity.getCourse();
        if (course != null) {
            CourseBasicResponse courseBasicResponse = EntityToEntity.entityToEntity(course,
                    CourseBasicResponse.class);
            courseBasicResponse.setInstructor(EntityToEntity.userToBasicResponse(course.getInstructor()));
            messageResponse.setCourse(courseBasicResponse);
        }
        return messageResponse;
    }
}
