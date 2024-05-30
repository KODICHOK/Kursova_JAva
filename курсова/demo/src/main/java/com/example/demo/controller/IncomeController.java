package com.example.demo.controller;

import com.example.demo.model.Income;
import com.example.demo.repository.IncomeRepository;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incomes")
public class IncomeController {

    @Autowired
    private IncomeRepository incomeRepository;

    @GetMapping
    public List<Income> getAllIncomes() {
        return incomeRepository.findAll();
    }

    @PostMapping
    public Income createIncome(@RequestBody Income income) {
        return incomeRepository.save(income);
    }

    @GetMapping("/{id}")
    public Income getIncomeById(@PathVariable Long id) {
        return incomeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Income not found"));
    }

    @PutMapping("/{id}")
    public Income updateIncome(@PathVariable Long id, @RequestBody Income incomeDetails) {
        Income income = incomeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Income not found"));
        income.setAmount(incomeDetails.getAmount());
        income.setDescription(incomeDetails.getDescription());
        return incomeRepository.save(income);
    }

    @DeleteMapping("/{id}")
    public void deleteIncome(@PathVariable Long id) {
        Income income = incomeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Income not found"));
        incomeRepository.delete(income);
    }
}
