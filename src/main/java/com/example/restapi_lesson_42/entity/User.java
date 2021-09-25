package com.example.restapi_lesson_42.entity;

import com.example.restapi_lesson_42.Constant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Pattern(regexp = Constant.REGEX_USERNAME, message = "Input data incorrect")
    @NotEmpty(message = "Field must not be empty")
    private String username;

    @Pattern(regexp = Constant.REGEX_FIRSTNAME, message = "Firstname input incorrect")
    @NotEmpty(message = "Field must not be empty")
    private String firstName;

    @Pattern(regexp = Constant.REGEX_LASTNAME, message = "Lastname input incorrect")
    @NotEmpty(message = "Field must not be empty")
    private String lastName;

    @Pattern(regexp = Constant.REGEX_EMAIL, message = "Email input incorrect")
    @NotEmpty(message = "Field must not be empty")
    private String email;

    @Pattern(regexp = Constant.REGEX_PASSWORD, message = "Input data incorrect")
    @NotEmpty(message = "Field must not be empty")
    private String password;

    @NotEmpty(message = "Field must not be empty")
    private String phone;

}
