package com.Platform.Courses.api.dto.request;

import com.Platform.Courses.api.dto.request.update_request.UpdateSubmissionRequest;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
public class SubmissionRequest extends UpdateSubmissionRequest {

    @NotNull(message = "The id of the assignment is required")
    @Min(value = 1, message = "The id of the assignment must be greater than zero")
    private Long idAssignment;
    @NotNull(message = "The id of the student is required")
    @Min(value = 1, message = "The id of the student must be greater than zero")
    private Long idStudent;

}
