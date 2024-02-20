package com.shahll.money.manager.api.rest.controllers;

import com.shahll.money.manager.DAO.IncomeManager;
import com.shahll.money.manager.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/income")
public class IncomeController {

    @Autowired
    private IncomeManager im;

    @PostMapping("/add")
    public void addIncome(@RequestParam(value = "amount") double amount,
                          @RequestParam(value = "tag") Tag tag,
                          @RequestParam(value = "note", defaultValue = "") String note) {
        im.addIncome(amount, tag, note);
    }
}
