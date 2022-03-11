package com.example.expensetracker;

import com.example.expensetracker.model.Expense;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/expenses")
public class ExpenseController {
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    // Expense endpoints
    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    @GetMapping("/{id}")
    public Expense getExpense(@PathVariable Long id) {
        return expenseService.getExpense(id);
    }

    @PostMapping
    public Expense addExpense(@Validated @RequestBody Expense expense) {
        return expenseService.addExpense(expense);
    }

    @PutMapping("/{id}")
    public Expense updateExpense(@PathVariable Long id, @Validated @RequestBody Expense updatedExpense) {
        return expenseService.updateExpense(id, updatedExpense);
    }

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
    }

    // User endpoints
    @GetMapping("/users")
    public List<Expense> getExpensesByUser(@RequestParam(name = "username") String userName) {
        return expenseService.getExpensesByUser(userName);
    }

    @DeleteMapping("/users")
    public void deleteExpensesByUser(@RequestParam(name = "username") String userName) {
        expenseService.deleteExpensesByUser(userName);
    }

    @GetMapping("/categories")
    public List<Expense> getExpensesByCategory(
            @RequestParam(name="category") String category,
            @RequestParam(name="username", required = false) String userName) {
        return (userName == null) ?
                expenseService.getExpensesByCategory(category) :
                expenseService.getExpensesByCategory(category, userName);
    }
}
