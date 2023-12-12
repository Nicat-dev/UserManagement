package com.example.usermanagement.model;

import com.example.usermanagement.validations.MatchPassword;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "surname",nullable = false)
    private String surname;
    @Column(name = "username",nullable = false,unique = true)
    @Min(value = 8,message = "username cannot be under the 8 symbol")
    @Max(value = 16,message = "username cannot be over the 16 symbol")
    private String username;
    @Column(name = "password",nullable = false)
    @MatchPassword
    private String password;
    @Column(name = "profilePicture")
    private byte[] profilePicture;
    @Column(name = "email",nullable = false,unique = true)
    @Email(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")
    private String email;
}
