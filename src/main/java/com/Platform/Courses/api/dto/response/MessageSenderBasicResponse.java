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
public class MessageSenderBasicResponse {

    private Long idMessage;
    private String messageContent;
    private LocalDate sentDate;
    private UserBasicResponse receiver;
    private String courseName;

}
