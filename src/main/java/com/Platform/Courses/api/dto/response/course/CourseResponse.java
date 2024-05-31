package com.Platform.Courses.api.dto.response.course;

import java.util.List;

import com.Platform.Courses.api.dto.response.enrollment.EnrollmentInCourseResponse;
import com.Platform.Courses.api.dto.response.lesson.LessonBasicResponse;
import com.Platform.Courses.api.dto.response.message.MessageInCourseResponse;

import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponse extends CourseBasicResponse {

    private List<EnrollmentInCourseResponse> enrollments;
    private List<MessageInCourseResponse> messages;
    private List<LessonBasicResponse> lessons;

}
