package com.Platform.Courses.infrastructure.abstract_services;

import java.util.List;

import com.Platform.Courses.api.dto.request.MessageRequest;
import com.Platform.Courses.api.dto.response.message.MessageResponse;

public interface IMessageService {

    MessageResponse create(MessageRequest request);

    List<MessageResponse> findMessagesBetweenTwoUsers(Long userId1, Long userId2);

}
