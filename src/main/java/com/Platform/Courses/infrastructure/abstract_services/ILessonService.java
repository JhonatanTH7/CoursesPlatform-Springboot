package com.Platform.Courses.infrastructure.abstract_services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Platform.Courses.api.dto.request.LessonRequest;
import com.Platform.Courses.api.dto.request.update_request.UpdateLessonRequest;
import com.Platform.Courses.api.dto.response.assignment.AssignmentBasicResponse;
import com.Platform.Courses.api.dto.response.lesson.LessonResponse;

@Service
public interface ILessonService extends CrudService<LessonRequest, UpdateLessonRequest, LessonResponse, Long> {

    List<AssignmentBasicResponse> getAllAssignmentsByLessonId(Long id);

}
