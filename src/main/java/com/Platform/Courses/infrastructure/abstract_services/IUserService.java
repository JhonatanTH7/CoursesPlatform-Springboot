package com.Platform.Courses.infrastructure.abstract_services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.Platform.Courses.api.dto.request.UserRequest;
import com.Platform.Courses.api.dto.request.update_request.UpdateUserRequest;
import com.Platform.Courses.api.dto.response.course.CourseBasicResponse;
import com.Platform.Courses.api.dto.response.user.UserResponse;

@Service
public interface IUserService extends CrudService<UserRequest, UpdateUserRequest, UserResponse, Long> {

    Page<UserResponse> getAll(int page, int size);

    List<CourseBasicResponse> getAllCoursesByUserId(Long id);

}
