package com.Platform.Courses.api.dto.response.submission;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionBasicResponse {

    private Long idSubmission;
    private String content;
    private LocalDate submissionDate;
    private double grade;

}
