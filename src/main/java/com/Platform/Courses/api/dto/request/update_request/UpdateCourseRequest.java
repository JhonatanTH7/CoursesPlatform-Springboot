package com.Platform.Courses.api.dto.request.update_request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCourseRequest {

    @NotBlank(message = "The courseName is required")
    @Size(max = 100, message = "The courseName must have a maximum of 100 characters")
    private String courseName;
    @NotBlank(message = "The description is required")
    private String description;

}
