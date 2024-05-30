package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FamilyMemberService {
    @Autowired
    private FamilyMemberRepository familyMemberRepository;

    public FamilyMember createFamilyMember(FamilyMember familyMember) {
        return familyMemberRepository.save(familyMember);
    }

    public Optional<FamilyMember> getFamilyMemberById(long id) {
        return familyMemberRepository.findById(id);
    }

}