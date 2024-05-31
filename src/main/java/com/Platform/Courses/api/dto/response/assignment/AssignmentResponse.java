package com.Platform.Courses.api.dto.response.assignment;

import java.util.List;

import com.Platform.Courses.api.dto.response.lesson.LessonInAssignmentResponse;
import com.Platform.Courses.api.dto.response.submission.SubmissionInAssignmentResponse;

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
public class AssignmentResponse extends AssignmentBasicResponse {

    private LessonInAssignmentResponse lesson;

    private List<SubmissionInAssignmentResponse> submissions;

}
