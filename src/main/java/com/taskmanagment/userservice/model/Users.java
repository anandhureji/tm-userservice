package com.taskmanagment.userservice.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class Users {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String password;
    private String email;
    private String fullName;
    private String role;

}
