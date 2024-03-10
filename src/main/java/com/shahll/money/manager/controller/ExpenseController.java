package com.shahll.money.manager.controller;

import com.shahll.money.manager.dto.ExpenseDto;
import com.shahll.money.manager.model.Expense;
import com.shahll.money.manager.service.impl.ExpenseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {

    private ExpenseServiceImpl expenseService;

    @Autowired
    public ExpenseController(ExpenseServiceImpl expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/list")
    public List<ExpenseDto> displayExpenses() {
        return expenseService.findAllExpenses();
    }

    @GetMapping("/{id}")
    public ExpenseDto displayExpense(@PathVariable long id){
        return expenseService.findExpenseById(id);
    }

    @PostMapping("/new")
    public Expense saveExpense(@RequestBody Expense expense){
        return expenseService.saveExpense(expense);
    }

    @PutMapping("/{id}/edit")
    public void editExpense(@PathVariable long id, @RequestBody ExpenseDto expense) {
        expense.setId(id);
        expenseService.updateExpense(expense);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteExpense(@PathVariable long id) {
        expenseService.deleteExpense(id);
    }

}

