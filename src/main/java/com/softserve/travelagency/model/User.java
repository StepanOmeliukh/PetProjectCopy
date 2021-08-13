package com.softserve.travelagency.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

//@Data
//@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Table(name = "user")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
//    @Pattern(regexp = "[A-Z][a-z]+(-[A-Z][a-z]+)?")
    @Column(name = "username")
    private String username;

    @NotNull
//    @Pattern(regexp = "[A-Z][a-z]+(-[A-Z][a-z]+)?")
    @Column(name = "password")
    private String password;

    @NotNull
    @Email(message = "Incorrect email")
    @NotBlank(message = "Email cannot be empty")
    @Column(unique = true, name = "email")
    private String email;

//    @OneToMany(cascade = CascadeType.ALL,
//            mappedBy = "hotel")
//    private List<Room> rooms;
//
//    @OneToMany(cascade = CascadeType.ALL,
//            mappedBy = "hotel")
//    private List<Order> orders;

    //тРЕБА СТОВРИТИ ЕНАМИ
}//