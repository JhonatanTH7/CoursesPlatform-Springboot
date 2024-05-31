package com.Platform.Courses.api.dto.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentBasicResponse {

    private Long idAssignment;
    private String assignmentTitle;
    private String description;
    private LocalDate dueDate;

}
