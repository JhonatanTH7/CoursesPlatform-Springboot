package com.Platform.Courses.api.dto.request;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentRequest {

    @NotNull(message = "The enrollmentDate is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "The enrollmentDate must be in the present or future")
    private LocalDate enrollmentDate;
    @NotNull(message = "The id of the student is required")
    @Min(value = 1, message = "The id of the student must be greater than zero")
    private Long idStudent;
    @NotNull(message = "The id of the course is required")
    @Min(value = 1, message = "The id of the course must be greater than zero")
    private Long idCourse;

}
