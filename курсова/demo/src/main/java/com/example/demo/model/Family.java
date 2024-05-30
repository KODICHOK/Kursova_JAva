package com.example.demo.model;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "Family")
public class Family {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private int numberOfMembers;
}
