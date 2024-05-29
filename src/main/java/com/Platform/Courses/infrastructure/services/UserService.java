package com.Platform.Courses.infrastructure.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.Platform.Courses.api.dto.request.UserRequest;
import com.Platform.Courses.api.dto.request.update_request.UpdateUserRequest;
import com.Platform.Courses.api.dto.response.MessageSenderBasicResponse;
import com.Platform.Courses.api.dto.response.UserResponse;
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
        List<MessageSenderBasicResponse> sentMessages = entity.getSentMessages().stream().map(this::).toList();
        return UserResponse
                .builder()
                .idUser(entity.getIdUser())
                .userName(entity.getUserName())
                .password(entity.getPassword())
                .email(entity.getEmail())
                .fullName(entity.getFullName())
                .role(entity.getRole())
                .sentMessages(null)
                .receivedMessages(null)
                .build();
    }

}
