package com.Platform.Courses.api.dto.response.message;

import com.Platform.Courses.api.dto.response.course.CourseBasicResponse;
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
public class MessageResponse extends MessageBasicResponse {

    private UserBasicResponse sender;
    private UserBasicResponse receiver;
    private CourseBasicResponse course;

}
