package com.Platform.Courses.api.dto.request;

import com.Platform.Courses.api.dto.request.update_request.UpdateUserRequest;
import com.Platform.Courses.util.enums.Role;

import jakarta.validation.constraints.NotNull;
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
public class UserRequest extends UpdateUserRequest {

    @NotNull(message = "The role is required")
    private Role role;

}
