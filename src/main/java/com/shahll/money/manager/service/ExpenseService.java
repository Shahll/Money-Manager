package com.shahll.money.manager.service;

import com.shahll.money.manager.dto.ExpenseDto;
import com.shahll.money.manager.model.Expense;

import java.util.List;

public interface ExpenseService {

    List<ExpenseDto>  findAllExpenses();
    ExpenseDto findExpenseById(long id);
    Expense saveExpense(Expense expense);
    void updateExpense(ExpenseDto expense);
    void deleteExpense(long id);

}
