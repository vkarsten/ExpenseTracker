package com.example.expensetracker.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "expense")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "amount", nullable = false)
    private Double amount;

    private Category category;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    public Expense() {
    }

    public Expense(Long id, String userName, Double amount) {
        this.id = id;
        this.userName = userName;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", amount=" + amount +
                ", category=" + category +
                ", date=" + date +
                '}';
    }
}
