package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class IncomeService {
    @Autowired
    private IncomeRepository incomeRepository;

    public Income createIncome(Income income) {
        return incomeRepository.save(income);
    }
}