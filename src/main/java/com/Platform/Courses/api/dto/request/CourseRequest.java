package com.Platform.Courses.api.dto.request;

import com.Platform.Courses.api.dto.request.update_request.UpdateCourseRequest;

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
    private Long idInstructor;

}
