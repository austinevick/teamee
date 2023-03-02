package com.example.employeemanager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
public class Employee implements Serializable {
    @Id
    @GeneratedValue
    @Column(nullable = false,updatable = false)
    private Long id;
    @NotBlank
    private String name;
    @Email(message = "Please enter a valid email")
    private String email;
    @NotBlank
    private String jobTitle;
    @NotBlank
    private String phone;
    private String imageUrl;
    @Column(nullable = false,updatable = false)
    private String employeeCode;
    private String dateCreated;





}
