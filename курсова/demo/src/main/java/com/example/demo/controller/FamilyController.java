package com.example.demo.controller;

import com.example.demo.model.Family;
import com.example.demo.repository.FamilyRepository;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/families")
public class FamilyController {

    @Autowired
    private FamilyRepository familyRepository;

    @GetMapping
    public List<Family> getAllFamilies() {
        return familyRepository.findAll();
    }

    @PostMapping
    public Family createFamily(@RequestBody Family family) {
        return familyRepository.save(family);
    }

    @GetMapping("/{id}")
    public Family getFamilyById(@PathVariable Long id) {
        return familyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Family not found"));
    }

    @PutMapping("/{id}")
    public Family updateFamily(@PathVariable Long id, @RequestBody Family familyDetails) {
        Family family = familyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Family not found"));
        family.setName(familyDetails.getName());
        family.setNumberOfMembers(familyDetails.getNumberOfMembers());
        return familyRepository.save(family);
    }

    @DeleteMapping("/{id}")
    public void deleteFamily(@PathVariable Long id) {
        Family family = familyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Family not found"));
        familyRepository.delete(family);
    }
}

