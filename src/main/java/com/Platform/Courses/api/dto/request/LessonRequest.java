package com.Platform.Courses.api.dto.request;

import com.Platform.Courses.api.dto.request.update_request.UpdateLessonRequest;

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
public class LessonRequest extends UpdateLessonRequest {

    @NotNull(message = "The id of the course is required")
    private Long idCourse;

}
