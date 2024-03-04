package com.shahll.money.manager.service.impl;

import com.shahll.money.manager.dto.ExpenseDto;
import com.shahll.money.manager.repository.ExpenseRepository;
import com.shahll.money.manager.model.Expense;
import com.shahll.money.manager.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public List<ExpenseDto> findAllExpenses() {
        List<Expense> expenses = expenseRepository.findAll();
        return expenses.stream().map(this::mapToExpenseDto).collect(Collectors.toList());
    }

    private ExpenseDto mapToExpenseDto (Expense expense) {
        return ExpenseDto.builder()
                .id(expense.getId())
                .amount(expense.getAmount())
                .tagId(expense.getTagId())
                .note(expense.getNote())
                .createdOn(expense.getCreatedOn())
                .build();
    }

    @Override
    public ExpenseDto findExpenseById(long id) {
        return mapToExpenseDto(Objects.requireNonNull(expenseRepository.findById(id)));
    }

    @Override
    public Expense saveExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public void updateExpense(ExpenseDto expenseDto) {
        Expense expense = mapToExpense(expenseDto);
        expenseRepository.save(expense);
    }

    private Expense mapToExpense(ExpenseDto expense) {
        return Expense.builder()
                .id(expense.getId())
                .amount(expense.getAmount())
                .tagId(expense.getTagId())
                .note(expense.getNote())
                .createdOn(expense.getCreatedOn())
                .build();
    }

    @Override
    public void deleteExpense(long id) {
        expenseRepository.deleteById(id);
    }

}
