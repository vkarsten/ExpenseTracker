package com.example.expensetracker;

import com.example.expensetracker.model.Category;
import com.example.expensetracker.model.Expense;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Expense getExpense(Long id) {
        return expenseRepository.findById(id)
                .orElseThrow();
    }

    public List<Expense> getExpensesByUser(String userName) {
        return expenseRepository.findAllByUserName(userName);
    }

    public Expense addExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public Expense updateExpense(Long id, Expense updatedExpense) {
        Expense expense = expenseRepository.findById(id)
                .orElseGet(Expense::new);

        expense.setId(updatedExpense.getId());
        expense.setUserName(updatedExpense.getUserName());
        expense.setAmount(updatedExpense.getAmount());
        expense.setCategory(updatedExpense.getCategory());
        expense.setDate(updatedExpense.getDate());

        return expenseRepository.save(expense);
    }

    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    public void deleteExpensesByUser(String userName) {
        expenseRepository.deleteAllByUserName(userName);
    }

    public List<Expense> getExpensesByCategory(String category) {
        Category c = Category.valueOf(category);
        return expenseRepository.findAllByCategory(c);
    }

    public List<Expense> getExpensesByCategory(String category, String userName) {
        Category c = Category.valueOf(category);
        return expenseRepository.findAllByCategoryAndUserName(c, userName);
    }
}
