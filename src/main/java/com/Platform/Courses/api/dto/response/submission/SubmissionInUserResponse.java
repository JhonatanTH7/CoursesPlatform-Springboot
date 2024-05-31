package com.Platform.Courses.api.dto.response.submission;

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
public class SubmissionInUserResponse extends SubmissionBasicResponse {

    private Long assignmentId;

}
