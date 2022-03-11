package com.example.expensetracker;

import com.example.expensetracker.model.Category;
import com.example.expensetracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findAllByUserName(String userName);

    void deleteAllByUserName(String userName);

    List<Expense> findAllByCategory(Category c);

    List<Expense> findAllByCategoryAndUserName(Category c, String userName);
}
