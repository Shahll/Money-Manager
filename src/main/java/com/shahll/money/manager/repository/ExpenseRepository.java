package com.shahll.money.manager.repository;

import com.shahll.money.manager.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findAll();
    Expense findById(long id);
    Expense save(Expense expense);
    void deleteById(long id);
}
