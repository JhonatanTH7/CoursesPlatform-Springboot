package com.Platform.Courses.api.dto.response.assignment;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentBasicResponse {

    private Long idAssignment;
    private String assignmentTitle;
    private String description;
    private LocalDate dueDate;

}
