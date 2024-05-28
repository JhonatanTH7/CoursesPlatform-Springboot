package com.Platform.Courses.api.dto.response;

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

}
