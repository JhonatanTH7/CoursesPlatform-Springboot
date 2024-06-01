package com.Platform.Courses.api.dto.response.submission;

import com.Platform.Courses.api.dto.response.assignment.AssignmentBasicResponse;
import com.Platform.Courses.api.dto.response.user.UserBasicResponse;

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
public class SubmissionResponse extends SubmissionBasicResponse {

    private UserBasicResponse student;
    private AssignmentBasicResponse assignment;

}
