package com.shahll.money.manager.api.rest.controllers;

import com.shahll.money.manager.DAO.ExpenseManager;
import com.shahll.money.manager.model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {

    @Autowired
    private ExpenseManager em;

    @PostMapping("/add")
    public void addIncome(@RequestParam(value = "amount") double amount,
                          @RequestParam(value = "tagName") String tagName,
                          @RequestParam(value = "note", defaultValue = "") String note) {
        em.addExpense(amount, tagName, note);
    }

    @GetMapping("/display")
    public List<Expense> displayIncome() {
        return em.getExpenseList();
    }

    @PutMapping("/change")
    public void changeInfo(@RequestParam(value = "id") int id,
                           @RequestParam(value = "amount", defaultValue = "0") double amount,
                           @RequestParam(value = "tagName", defaultValue = "") String tagName,
                           @RequestParam(value = "note", defaultValue = "") String note) {
        em.changeExpenseInformation(id, amount, tagName, note);
    }

    @DeleteMapping("/delete")
    public void deleteIncome(@RequestParam(value = "id", defaultValue = "-1") int id) {
        em.deleteExpense(id);
    }

}

