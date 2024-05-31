package com.Platform.Courses.infrastructure.abstract_services;

import org.springframework.stereotype.Service;

import com.Platform.Courses.api.dto.request.CourseRequest;
import com.Platform.Courses.api.dto.request.update_request.UpdateCourseRequest;
import com.Platform.Courses.api.dto.response.CourseResponse;

@Service
public interface ICourseService extends CrudService<CourseRequest, UpdateCourseRequest, CourseResponse, Long> {

}
