package com.Platform.Courses.api.dto.request;

import com.Platform.Courses.util.enums.Role;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    @NotBlank(message = "The username is required")
    @Size(max = 50, message = "The userName must have a maximum of 50 characters")
    private String userName;
    @NotBlank(message = "The password is required")
    private String password;
    @NotBlank(message = "The email is required")
    @Size(max = 100, message = "The email must have a maximum of 100 characters")
    private String email;
    @NotBlank(message = "The fullName is required")
    @Size(max = 100, message = "The fullName must have a maximum of 100 characters")
    private String fullName;
    @NotNull(message = "The role is required")
    private Role role;

}
