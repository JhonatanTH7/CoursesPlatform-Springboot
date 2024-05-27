package com.Platform.Courses.domain.entities;

import com.Platform.Courses.util.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;
    @Column(name = "username", length = 50)
    private String userName;
    private String password;
    @Email
    @Column(length = 100)
    private String email;
    @Column(name = "full_name", length = 100)
    private String fullName;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

}
