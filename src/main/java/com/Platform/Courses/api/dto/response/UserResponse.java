package com.Platform.Courses.api.dto.response;

import java.util.List;

import com.Platform.Courses.util.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private Long idUser;
    private String userName;
    private String password;
    private String email;
    private String fullName;
    private Role role;
    private List<MessageSenderBasicResponse> sentMessages;
    private List<MessageReceiverBasicResponse> receivedMessages;
    private List<SubmissionInUserResponse> submissions;
    private List<EnrollmentInUserResponse> enrollments;
    private List<CourseInUserResponse> courses;

}
