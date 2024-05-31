package com.Platform.Courses.api.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse extends UserBasicResponse {

    private String password;
    private String fullName;
    private List<MessageSenderBasicResponse> sentMessages;
    private List<MessageReceiverBasicResponse> receivedMessages;
    private List<SubmissionInUserResponse> submissions;
    private List<EnrollmentInUserResponse> enrollments;
    private List<CourseBasicResponse> courses;

}
