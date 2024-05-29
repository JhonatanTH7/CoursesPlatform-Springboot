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
public class UserBasicResponse {

    private Long idUser;
    private String email;
    private String userName;
    private Role role;

}
