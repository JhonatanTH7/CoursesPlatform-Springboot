package com.Platform.Courses.api.dto.request.update_request;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAssignmentRequest {

    @NotBlank(message = "The username is required")
    @Size(max = 100, message = "The assignmentTitle must have a maximum of 100 characters")
    private String assignmentTitle;
    @NotBlank(message = "The description is required")
    private String description;
    @NotNull(message = "The dueDate is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Pattern(regexp = "^(?:\\\\d{4}-(?:0[1-9]|1[0-2])-(?:0[1-9]|[12]\\\\d|3[01]))$", message = "El formato de fecha debe ser yyyy-MM-dd")
    @FutureOrPresent(message = "The dueDate must be in the present or future")
    private LocalDate dueDate;

}
