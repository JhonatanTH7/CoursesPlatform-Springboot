package com.Platform.Courses.api.dto.response.lesson;

import java.util.List;

import com.Platform.Courses.api.dto.response.assignment.AssignmentBasicResponse;
import com.Platform.Courses.api.dto.response.course.CourseBasicResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class LessonResponse extends LessonBasicResponse {

    private CourseBasicResponse course;
    private List<AssignmentBasicResponse> assignments;

}
