package com.rost.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {
    @Id
    private long id;
    @NotEmpty
    @Size(min = 2, message = "Name should be greater than 2 characters")
    private String name;
    private String password;
}