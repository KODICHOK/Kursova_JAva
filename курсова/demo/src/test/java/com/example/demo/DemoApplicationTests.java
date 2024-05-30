package com.example.demo;

import com.example.demo.model.Family;
import com.example.demo.model.User;
import com.example.demo.model.Expense;
import com.example.demo.model.Income;
import com.example.demo.service.FamilyService;
import com.example.demo.service.UserService;
import com.example.demo.service.ExpenseService;
import com.example.demo.service.IncomeService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private FamilyService familyService;

	@Autowired
	private UserService userService;

	@Autowired
	private ExpenseService expenseService;

	@Autowired
	private IncomeService incomeService;

	@Test
	public void testCreateFamily() {
		Family family = new Family();
		family.setName("Smith");
		family.setNumberOfMembers(4);
		Family savedFamily = familyService.createFamily(family);

		assertThat(savedFamily).isNotNull();
		assertThat(savedFamily.getId()).isGreaterThan(0);
		assertThat(savedFamily.getName()).isEqualTo("Smith");
		assertThat(savedFamily.getNumberOfMembers()).isEqualTo(4);
	}

	@Test
	public void testCreateUser() {
		User user = new User();
		user.setUsername("John Doe");
		user.setEmail("john.doe@example.com");
		User savedUser = userService.createUser(user);

		assertThat(savedUser).isNotNull();
		assertThat(savedUser.getId()).isGreaterThan(0);
		assertThat(savedUser.getUsername()).isEqualTo("John Doe");
		assertThat(savedUser.getEmail()).isEqualTo("john.doe@example.com");
	}

	@Test
	public void testDeleteUser() {
		User user = new User();
		user.setUsername("Jane Doe");
		user.setEmail("jane.doe@example.com");
		User savedUser = userService.createUser(user);

		assertThat(savedUser).isNotNull();
		assertThat(savedUser.getId()).isGreaterThan(0);

		userService.deleteUser(savedUser.getId());

		User deletedUser = userService.getUserById(savedUser.getId());
		assertThat(deletedUser).isNull();
	}

	@Test
	public void testCreateExpense() {
		Expense expense = new Expense();
		expense.setAmount(100.0);
		expense.setDescription("Grocery");
		Expense savedExpense = expenseService.createExpense(expense);

		assertThat(savedExpense).isNotNull();
		assertThat(savedExpense.getId()).isGreaterThan(0);
		assertThat(savedExpense.getAmount()).isEqualTo(100.0);
		assertThat(savedExpense.getDescription()).isEqualTo("Grocery");
	}

	@Test
	public void testCreateIncome() {
		Income income = new Income();
		income.setAmount(2000.0);
		income.setDescription("Salary");
		Income savedIncome = incomeService.createIncome(income);

		assertThat(savedIncome).isNotNull();
		assertThat(savedIncome.getId()).isGreaterThan(0);
		assertThat(savedIncome.getAmount()).isEqualTo(2000.0);
		assertThat(savedIncome.getDescription()).isEqualTo("Salary");
	}
	@Test
	public void testUserLogin() {
		// Спочатку створимо користувача для тесту
		User user = new User();
		user.setUsername("John Doe");
		user.setEmail("john.doe@example.com");
		user.setPassword("password123");
		userService.createUser(user);

		// Тест логіну
		User loggedInUser = userService.login("john.doe@example.com", "password123");

		assertThat(loggedInUser).isNotNull();
		assertThat(loggedInUser.getEmail()).isEqualTo("john.doe@example.com");
	}
}

