package com.example.demo.controller;

import com.example.demo.model.Accumulation;
import com.example.demo.repository.AccumulationRepository;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accumulations")
public class AccumulationController {

    @Autowired
    private AccumulationRepository accumulationRepository;

    @GetMapping
    public List<Accumulation> getAllAccumulations() {
        return accumulationRepository.findAll();
    }

    @PostMapping
    public Accumulation createAccumulation(@RequestBody Accumulation accumulation) {
        return accumulationRepository.save(accumulation);
    }

    @GetMapping("/{id}")
    public Accumulation getAccumulationById(@PathVariable Long id) {
        return accumulationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Accumulation not found"));
    }

    @PutMapping("/{id}")
    public Accumulation updateAccumulation(@PathVariable Long id, @RequestBody Accumulation accumulationDetails) {
        Accumulation accumulation = accumulationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Accumulation not found"));
        accumulation.setAmount(accumulationDetails.getAmount());
        accumulation.setDescription(accumulationDetails.getDescription());
        return accumulationRepository.save(accumulation);
    }

    @DeleteMapping("/{id}")
    public void deleteAccumulation(@PathVariable Long id) {
        Accumulation accumulation = accumulationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Accumulation not found"));
        accumulationRepository.delete(accumulation);
    }
}
