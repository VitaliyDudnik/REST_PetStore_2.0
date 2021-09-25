package com.example.restapi_lesson_42.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "Field must not be empty")
    @NotBlank(message = "Field must not be empty")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Category category;
}
