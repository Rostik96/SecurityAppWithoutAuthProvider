package com.rost.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Principal {
    @Id
    private long id;
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, message = "Name should be greater than 2 characters")
    private String username;
    private String password;
}