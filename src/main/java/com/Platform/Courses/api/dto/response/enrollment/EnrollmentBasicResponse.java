package com.Platform.Courses.api.dto.response.enrollment;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentBasicResponse {

    private Long idEnrollment;
    private LocalDate enrollmentDate;

}
