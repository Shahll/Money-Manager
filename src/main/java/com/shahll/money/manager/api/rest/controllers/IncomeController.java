package com.shahll.money.manager.api.rest.controllers;

import com.shahll.money.manager.DAO.IncomeManager;
import com.shahll.money.manager.model.Income;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/income")
public class IncomeController {

    @Autowired
    private IncomeManager im;

    @PostMapping("/add")
    public void addIncome(@RequestParam(value = "amount") double amount,
                          @RequestParam(value = "tagName") String tagName,
                          @RequestParam(value = "note", defaultValue = "") String note) {
        im.addIncome(amount, tagName, note);
    }

    @GetMapping("/display")
    public List<Income> displayIncome() {
        return im.getIncomeList();
    }

    @PutMapping("/change")
    public void changeInfo(@RequestParam(value = "id") int id,
                           @RequestParam(value = "amount", defaultValue = "0") double amount,
                           @RequestParam(value = "tagName", defaultValue = "") String tagName,
                           @RequestParam(value = "note", defaultValue = "") String note) {
        im.changeIncomeInformation(id, amount, tagName, note);
    }

    @DeleteMapping("/delete")
    public void deleteIncome(@RequestParam(value = "id", defaultValue = "-1") int id) {
        im.deleteIncome(id);
    }

}

