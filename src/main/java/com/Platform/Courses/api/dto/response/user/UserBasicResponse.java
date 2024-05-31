package com.Platform.Courses.api.dto.response.user;

import com.Platform.Courses.util.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class UserBasicResponse {

    private Long idUser;
    private String email;
    private String userName;
    private Role role;

}
