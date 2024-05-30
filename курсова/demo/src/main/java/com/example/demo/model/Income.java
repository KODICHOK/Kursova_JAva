package com.example.demo.model;

import lombok.Data;
import jakarta.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "Income")
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double Amount;
    private Date date;
    private String description;

    @ManyToOne
    @JoinColumn(name = "family_member_id")
    private FamilyMember familyMember;
}
