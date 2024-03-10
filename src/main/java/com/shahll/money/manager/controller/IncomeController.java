package com.shahll.money.manager.controller;

import com.shahll.money.manager.dto.IncomeDto;
import com.shahll.money.manager.model.Income;
import com.shahll.money.manager.service.impl.IncomeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/income")
public class IncomeController {

    private IncomeServiceImpl incomeService;

    @Autowired
    public IncomeController(IncomeServiceImpl incomeService) {
        this.incomeService = incomeService;
    }

    @GetMapping("/list")
    public List<IncomeDto> displayIncomes() {
        return incomeService.findAllIncomes();
    }

    @GetMapping("/{id}")
    public IncomeDto displayIncome(@PathVariable long id){
        return incomeService.findIncomeById(id);
    }

    @PostMapping("/new")
    public Income saveIncome(@RequestBody Income income){
        return incomeService.saveIncome(income);
    }

    @PutMapping("/{id}/edit")
    public void editIncome(@PathVariable long id, @RequestBody IncomeDto income) {
        income.setId(id);
        incomeService.updateIncome(income);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteIncome(@PathVariable long id) {
        incomeService.deleteIncome(id);
    }

}

