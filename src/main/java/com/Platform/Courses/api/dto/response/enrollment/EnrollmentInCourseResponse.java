package com.Platform.Courses.api.dto.response.enrollment;

import com.Platform.Courses.api.dto.response.user.UserBasicResponse;

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
public class EnrollmentInCourseResponse extends EnrollmentBasicResponse {

    private UserBasicResponse student;

}
