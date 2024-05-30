package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FamilyService {
    @Autowired
    private FamilyRepository familyRepository;

    public Family createFamily(Family family) {
        return familyRepository.save(family);
    }

    public Optional<Family> getFamilyById(long id) {
        return familyRepository.findById(id);
    }

    public Family updateFamily(Family family) {
        return familyRepository.save(family);
    }
}
