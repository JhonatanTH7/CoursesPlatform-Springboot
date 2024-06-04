package com.Platform.Courses.api.dto.response.message;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class MessageBasicResponse {

    private Long idMessage;
    private String messageContent;
    private LocalDateTime sentDate;

}
