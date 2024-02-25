package com.shahll.money.manager.api.rest.controllers;

import com.shahll.money.manager.DAO.ExpenseManager;
import com.shahll.money.manager.model.Expense;
import com.shahll.money.manager.model.Requests.ExpenseRequest;
import com.shahll.money.manager.model.Requests.IdRequest;
import com.shahll.money.manager.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {

    @SuppressWarnings("unused")
    @Autowired
    private ExpenseManager em;

    @SuppressWarnings("unused")
    @PostMapping("/add")
    public void addExpense(@RequestBody ExpenseRequest input){
        em.addExpense(input.amount(), input.tag().getName(), input.note());
    }

    @SuppressWarnings("unused")
    @GetMapping("/display")
    public List<Expense> displayExpense() {
        return em.getExpenseList();
    }

    @SuppressWarnings("unused")
    @PutMapping("/change")
    public void changeInfo(@RequestBody ExpenseRequest input) {
        double amount = input.amount();
        Tag tag = input.tag();
        String note = input.note();

        if (amount == 0) {
            amount = em.getExpenseById(input.id()).getAmount();
        }
        if (tag == null) {
            tag = em.getExpenseById(input.id()).getTag();
        }
        if (note == null) {
            note = em.getExpenseById(input.id()).getNote();
        }
        em.changeExpenseInformation(input.id(), amount, tag.getName(), note);
    }


    @SuppressWarnings("unused")
    @DeleteMapping("/delete")
    public void deleteExpense(@RequestBody IdRequest input){
        em.deleteExpense(input.id());
    }

}

