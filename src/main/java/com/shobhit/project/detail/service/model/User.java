package com.shobhit.project.detail.service.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

            @NotBlank(message = "User name can't be blank")
            @Column(name = "username", unique = true)
    String username;
    @NotBlank(message = "Password can't be blank")
    String password;
}
