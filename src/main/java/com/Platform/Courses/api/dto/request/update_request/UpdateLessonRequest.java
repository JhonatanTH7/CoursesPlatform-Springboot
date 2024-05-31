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
public class UpdateLessonRequest {

    @NotBlank(message = "The lessonTitle is required")
    @Size(max = 100, message = "The lessonTitle must have a maximum of 100 characters")
    private String lessonTitle;
    @NotBlank(message = "The content is required")
    private String content;

}
