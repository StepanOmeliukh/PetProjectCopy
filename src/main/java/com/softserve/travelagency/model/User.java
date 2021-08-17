package com.softserve.travelagency.model;

import com.softserve.travelagency.model.enums.Status;
import com.softserve.travelagency.model.enums.UserEnums;
import lombok.*;
import org.springframework.data.repository.cdi.Eager;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Builder
@Getter
@Setter
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

    @Transient
//    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "password must have minimum eight characters, at least one letter and one number")
    private String password;

    @Column(name = "password")
    private String encryptedPassword;

//    @Pattern(regexp = "[A-Z][a-z]+(-[A-Z][a-z]+)?", message = "Incorrect name!")
    @Column(name = "firstName")
    private String firstName;

//    @Pattern(regexp = "[A-Z][a-z]+(-[A-Z][a-z]+)?", message = "Incorrect last name!")
    @Column(name = "lastName")
    private String lastName;

    //    @NotNull
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserEnums roles;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

}