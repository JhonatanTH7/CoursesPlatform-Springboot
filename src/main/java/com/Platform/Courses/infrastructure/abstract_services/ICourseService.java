package com.Platform.Courses.infrastructure.abstract_services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.Platform.Courses.api.dto.request.CourseRequest;
import com.Platform.Courses.api.dto.request.update_request.UpdateCourseRequest;
import com.Platform.Courses.api.dto.response.CourseResponse;
import com.Platform.Courses.api.dto.response.LessonBasicResponse;
import com.Platform.Courses.api.dto.response.MessageInCourseResponse;
import com.Platform.Courses.api.dto.response.UserBasicResponse;

@Service
public interface ICourseService extends CrudService<CourseRequest, UpdateCourseRequest, CourseResponse, Long> {

    Page<CourseResponse> getAll(int page, int size);

    List<LessonBasicResponse> getAllLessonsByCourseId(Long id);

    List<MessageInCourseResponse> getAllMessagesByCourseId(Long id);

    List<UserBasicResponse> getAllUsersByCourseId(Long id);

}
