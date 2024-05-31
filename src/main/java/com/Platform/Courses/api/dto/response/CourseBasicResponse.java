package com.Platform.Courses.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class CourseBasicResponse {

    private Long idCourse;
    private String courseName;
    private String description;
    private UserBasicResponse instructor;

}
