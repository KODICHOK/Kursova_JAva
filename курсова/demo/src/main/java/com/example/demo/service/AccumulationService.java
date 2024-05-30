package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccumulationService {
    @Autowired
    private AccumulationRepository accumulationRepository;

    public Accumulation createAccumulation(Accumulation accumulation) {
        return accumulationRepository.save(accumulation);
    }
}