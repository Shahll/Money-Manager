package com.shahll.money.manager.repository;

import com.shahll.money.manager.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncomeRepository extends JpaRepository<Income, Long> {
    List<Income> findAll();
    Income findById(long id);
    Income save(Income income);
    void deleteById(long id);
}
