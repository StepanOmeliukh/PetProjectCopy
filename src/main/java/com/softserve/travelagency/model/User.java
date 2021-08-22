package com.softserve.travelagency.model;

import com.softserve.travelagency.model.util.Role;
import com.softserve.travelagency.model.util.Status;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email(message = "Incorrect email")
    @NotBlank(message = "Email cannot be empty")
    @Column(unique = true, name = "email")
    private String email;

    @NotBlank(message = "incorrect password")
    @Transient
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "password must have minimum eight characters, at least one letter and one number")
    private String password;
    
    @Column(name = "password")
    private String encryptedPassword;

    @Pattern(regexp = "[A-Z][a-z]+(-[A-Z][a-z]+)?", message = "Incorrect name!")
    @Column(name = "first_name")
    private String firstName;

    @Pattern(regexp = "[A-Z][a-z]+(-[A-Z][a-z]+)?", message = "Incorrect last name!")
    @Column(name = "last_name")
    private String lastName;



    //    @NotNull
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;


    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
