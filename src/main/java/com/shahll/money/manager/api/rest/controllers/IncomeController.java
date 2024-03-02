package com.shahll.money.manager.api.rest.controllers;

import com.shahll.money.manager.DAO.IncomeManager;
import com.shahll.money.manager.model.Income;
import com.shahll.money.manager.model.Requests.IdRequest;
import com.shahll.money.manager.model.Requests.IncomeRequest;
import com.shahll.money.manager.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/income")
public class IncomeController {

    @Autowired
    private IncomeManager im;

    @PostMapping("/add")
    public void addIncome(@RequestBody IncomeRequest input) {
        im.addIncome(input.amount(), input.tag().getName(), input.note());
    }

    @GetMapping("/display")
    public List<Income> displayIncome() {
        return im.getIncomeList();
    }

    @PutMapping("/change")
    public void changeInfo(@RequestBody IncomeRequest input) {
        double amount = input.amount();
        Tag tag = input.tag();
        String note = input.note();

        if (amount == 0) {
            amount = im.getIncomeById(input.id()).getAmount();
        }
        if (tag == null) {
            tag = im.getIncomeById(input.id()).getTag();
        }
        if (note == null) {
            note = im.getIncomeById(input.id()).getNote();
        }
        im.changeIncomeInformation(input.id(), amount, tag.getName(), note);
    }

    @DeleteMapping("/delete")
    public void deleteIncome(@RequestBody IdRequest input) {
        im.deleteIncome(input.id());
    }

}

