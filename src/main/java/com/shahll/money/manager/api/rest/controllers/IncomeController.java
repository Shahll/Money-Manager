package com.shahll.money.manager.api.rest.controllers;

import com.shahll.money.manager.DAO.IncomeManager;
import com.shahll.money.manager.model.Requests.ChangeInputRequest;
import com.shahll.money.manager.model.Income;
import com.shahll.money.manager.model.Requests.IdRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/income")
public class IncomeController {

    @SuppressWarnings("unused")
    @Autowired
    private IncomeManager im;

    @SuppressWarnings("unused")
    @PostMapping("/add")
    public void addIncome(@RequestBody Income input) {
        im.addIncome(input.getAmount(), input.getTag().getName(), input.getNote());
    }

    @SuppressWarnings("unused")
    @GetMapping("/display")
    public List<Income> displayIncome() {
        return im.getIncomeList();
    }

    @SuppressWarnings("unused")
    @PutMapping("/change")
    public void changeInfo(@RequestBody ChangeInputRequest input) {
        if (input.tag == null) {
            input.setTag(im.getIncomeById(input.id).getTag());
        }
        if (input.note == null) {
            input.setNote(im.getIncomeById(input.id).getNote());
        }
        if (input.amount == 0) {
            input.setAmount(im.getIncomeById(input.id).getAmount());
        }
        im.changeIncomeInformation(input.id, input.amount, input.tag.getName(), input.note);
    }

    @SuppressWarnings("unused")
    @DeleteMapping("/delete")
    public void deleteIncome(@RequestBody IdRequest input) {
        im.deleteIncome(input.getId());
    }


}

