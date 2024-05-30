package com.Platform.Courses.api.dto.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionInUserResponse {

    private Long idSubmission;
    private String content;
    private LocalDate submissionDate;
    private double grade;
    private String assignmentTitle;

}
