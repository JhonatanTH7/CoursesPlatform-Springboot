package com.Platform.Courses.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseInUserResponse {

    private Long idCourse;
    private String courseName;
    private String description;
    private UserBasicResponse instructor;

}
