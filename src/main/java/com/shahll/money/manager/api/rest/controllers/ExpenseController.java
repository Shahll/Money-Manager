package com.shahll.money.manager.api.rest.controllers;

import com.shahll.money.manager.DAO.ExpenseManager;
import com.shahll.money.manager.model.Expense;
import com.shahll.money.manager.model.Requests.ChangeExpenseRequest;
import com.shahll.money.manager.model.Requests.IdRequest;
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
    public void addExpense(@RequestBody Expense input){
        em.addExpense(input.getAmount(), input.getTag().getName(), input.getNote());
    }

    @SuppressWarnings("unused")
    @GetMapping("/display")
    public List<Expense> displayExpense() {
        return em.getExpenseList();
    }

    @SuppressWarnings("unused")
    @PutMapping("/change")
    public void changeInfo(@RequestBody ChangeExpenseRequest input) {
        if (input.tag == null) {
            input.setTag(em.getExpenseById(input.id).getTag());
        }
        if (input.note == null) {
            input.setNote(em.getExpenseById(input.id).getNote());
        }
        if (input.amount == 0) {
            input.setAmount(em.getExpenseById(input.id).getAmount());
        }
        em.changeExpenseInformation(input.id, input.amount, input.tag.getName(), input.note);
    }


    @SuppressWarnings("unused")
    @DeleteMapping("/delete")
    public void deleteExpense(@RequestBody IdRequest input){
        em.deleteExpense(input.getId());
    }

}

