package com.Platform.Courses.api.dto.response.submission;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
    private LocalDateTime submissionDate;
    private BigDecimal grade;

}
