package com.Platform.Courses.api.dto.response.lesson;

import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class LessonBasicResponse {

    private Long idLesson;
    private String lessonTitle;
    private String content;

}
