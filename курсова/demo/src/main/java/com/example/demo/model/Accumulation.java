package com.example.demo.model;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "Accumulation")
public class Accumulation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double amount;
    private double description;
    private double target;
    private String targetDescription;

    @ManyToOne
    @JoinColumn(name = "family_id")
    private Family family;
}
