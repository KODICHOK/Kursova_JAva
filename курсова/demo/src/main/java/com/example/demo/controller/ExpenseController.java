package com.example.demo.controller;

import com.example.demo.model.Expense;
import com.example.demo.repository.ExpenseRepository;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseRepository expenseRepository;

    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    @PostMapping
    public Expense createExpense(@RequestBody Expense expense) {
        return expenseRepository.save(expense);
    }

    @GetMapping("/{id}")
    public Expense getExpenseById(@PathVariable Long id) {
        return expenseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Expense not found"));
    }

    @PutMapping("/{id}")
    public Expense updateExpense(@PathVariable Long id, @RequestBody Expense expenseDetails) {
        Expense expense = expenseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Expense not found"));
        expense.setAmount(expenseDetails.getAmount());
        expense.setDescription(expenseDetails.getDescription());
        return expenseRepository.save(expense);
    }

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id) {
        Expense expense = expenseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Expense not found"));
        expenseRepository.delete(expense);
    }
}

