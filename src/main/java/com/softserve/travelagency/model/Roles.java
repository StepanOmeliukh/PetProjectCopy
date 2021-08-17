//package com.softserve.travelagency.model;
//
//import lombok.*;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;
//import java.util.List;
//import java.util.Set;
//@AllArgsConstructor
//
//@Data
//@Builder
//@Getter
//@Setter
//@NoArgsConstructor
//
//@Entity
//@Table(name = "roles")
//public class Roles {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @Column(name = "name")
//    private String name;
//
//    @ManyToMany(mappedBy = "roles")
//    private Set<User> users;
//}