package com.Platform.Courses.api.dto.response;

import java.time.LocalDate;

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
    private LocalDate sentDate;

}
