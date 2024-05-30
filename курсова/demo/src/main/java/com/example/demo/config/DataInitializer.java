package com.example.demo.config;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class DataInitializer {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FamilyRepository familyRepository;

    @Autowired
    private FamilyMemberRepository familyMemberRepository;

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private IncomeRepository incomeRepository;

    @Autowired
    private AccumulationRepository accumulationRepository;

    @Bean
    public CommandLineRunner initData() {
        return args -> {
            User user1 = new User();
            user1.setUsername("user1");
            user1.setPassword("{noop}password1");
            user1.setRole("ROLE_USER");
            userRepository.save(user1);

            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword("{noop}password2");
            admin.setRole("ROLE_ADMIN");
            userRepository.save(admin);

            Family family1 = new Family();
            family1.setName("Family1");
            family1.setNumberOfMembers(1);
            familyRepository.save(family1);

            Family family2 = new Family();
            family2.setName("Family2");
            family2.setNumberOfMembers(1);
            familyRepository.save(family2);

            // Створення членів сім'ї
            FamilyMember member1 = new FamilyMember();
            member1.setName("Member1");
            member1.setLogin("user1");
            member1.setPassword("password1");
            member1.setFamily(family1);
            familyMemberRepository.save(member1);

            FamilyMember member2 = new FamilyMember();
            member2.setName("Member2");
            member2.setLogin("admin");
            member2.setPassword("password2");
            member2.setFamily(family2);
            familyMemberRepository.save(member2);

            // Створення витрат
            Expense expense1 = new Expense();
            expense1.setAmount(100.00);
            expense1.setDate(new Date());
            expense1.setDescription("Groceries");
            expense1.setFamilyMember(member1);
            expenseRepository.save(expense1);

            Expense expense2 = new Expense();
            expense2.setAmount(200.00);
            expense2.setDate(new Date());
            expense2.setDescription("Rent");
            expense2.setFamilyMember(member2);
            expenseRepository.save(expense2);

            // Створення доходів
            Income income1 = new Income();
            income1.setAmount(500.00);
            income1.setDate(new Date());
            income1.setDescription("Salary");
            income1.setFamilyMember(member1);
            incomeRepository.save(income1);

            Income income2 = new Income();
            income2.setAmount(1000.00);
            income2.setDate(new Date());
            income2.setDescription("Freelance");
            income2.setFamilyMember(member2);
            incomeRepository.save(income2);

            // Створення накопичень
            Accumulation accumulation1 = new Accumulation();
            accumulation1.setTarget(1000.00);
            accumulation1.setTargetDescription("Vacation Fund");
            accumulation1.setFamily(family1);
            accumulationRepository.save(accumulation1);

            Accumulation accumulation2 = new Accumulation();
            accumulation2.setTarget(2000.00);
            accumulation2.setTargetDescription("Emergency Fund");
            accumulation2.setFamily(family2);
            accumulationRepository.save(accumulation2);
        };
    }
}
