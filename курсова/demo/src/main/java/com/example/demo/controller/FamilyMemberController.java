package com.example.demo.controller;

import com.example.demo.model.FamilyMember;
import com.example.demo.repository.FamilyMemberRepository;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/family-members")
public class FamilyMemberController {

    @Autowired
    private FamilyMemberRepository familyMemberRepository;

    @GetMapping
    public List<FamilyMember> getAllFamilyMembers() {
        return familyMemberRepository.findAll();
    }

    @PostMapping
    public FamilyMember createFamilyMember(@RequestBody FamilyMember familyMember) {
        return familyMemberRepository.save(familyMember);
    }

    @GetMapping("/{id}")
    public FamilyMember getFamilyMemberById(@PathVariable Long id) {
        return familyMemberRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("FamilyMember not found"));
    }

    @PutMapping("/{id}")
    public FamilyMember updateFamilyMember(@PathVariable Long id, @RequestBody FamilyMember familyMemberDetails) {
        FamilyMember familyMember = familyMemberRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("FamilyMember not found"));
        familyMember.setName(familyMemberDetails.getName());
        familyMember.setLogin(familyMemberDetails.getLogin());
        familyMember.setPassword(familyMemberDetails.getPassword());
        return familyMemberRepository.save(familyMember);
    }

    @DeleteMapping("/{id}")
    public void deleteFamilyMember(@PathVariable Long id) {
        FamilyMember familyMember = familyMemberRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("FamilyMember not found"));
        familyMemberRepository.delete(familyMember);
    }
}
