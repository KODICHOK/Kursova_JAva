package com.example.demo.model;

import lombok.Data;
import jakarta.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "Expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double amount;
    private Date date;
    private String description;

    @ManyToOne
    @JoinColumn(name = "family_member_id")
    private FamilyMember familyMember;
}
