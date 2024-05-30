package com.example.demo.model;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
@Table(name = "AppUser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    private String role;
}
