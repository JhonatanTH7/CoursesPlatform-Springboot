package com.Platform.Courses.infrastructure.abstract_services;

import org.springframework.stereotype.Service;

import com.Platform.Courses.api.dto.request.UserRequest;
import com.Platform.Courses.api.dto.request.update_request.UpdateUserRequest;
import com.Platform.Courses.api.dto.response.UserResponse;

@Service
public interface IUserService extends CrudService<UserRequest, UpdateUserRequest, UserResponse, Long> {

}
