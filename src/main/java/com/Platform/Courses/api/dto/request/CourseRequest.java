package com.Platform.Courses.api.dto.request;

import com.Platform.Courses.api.dto.request.update_request.UpdateCourseRequest;

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
public class CourseRequest extends UpdateCourseRequest {

    @NotNull(message = "The id of the instructor is required")
    @Min(value = 1, message = "The id of the instructor must be greater than zero")
    private Long idInstructor;

}
