package com.example.demo.model;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "Family_Member")
public class FamilyMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String login;
    private String password;

    @ManyToOne
    @JoinColumn(name = "family_id")
    private Family family;
}
