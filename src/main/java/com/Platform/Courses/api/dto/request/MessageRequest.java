package com.Platform.Courses.api.dto.request;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class MessageRequest {

    @NotBlank(message = "The content is required")
    private String messageContent;
    @NotNull(message = "The id of the sender is required")
    @Min(value = 1, message = "The id of the sender must be greater than zero")
    private Long idSender;
    @NotNull(message = "The id of the receiver is required")
    @Min(value = 1, message = "The id of the receiver must be greater than zero")
    private Long idReceiver;
    @NotNull(message = "The id of the course is required")
    @Min(value = 1, message = "The id of the course must be greater than zero")
    private Long idCourse;

}
