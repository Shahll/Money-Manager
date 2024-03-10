package com.shahll.money.manager.controller;

import com.shahll.money.manager.dto.ExpenseDto;
import com.shahll.money.manager.dto.IncomeDto;
import com.shahll.money.manager.service.impl.ExpenseServiceImpl;
import com.shahll.money.manager.service.impl.IncomeServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/")
public class TotalController {
    private ExpenseServiceImpl expenseService;
    private IncomeServiceImpl incomeService;

    public TotalController(ExpenseServiceImpl expenseService, IncomeServiceImpl incomeService) {
        this.expenseService = expenseService;
        this.incomeService = incomeService;
    }

    @GetMapping("/total")
    public double showTotalMoney() {
        double totalMoney = 0;
        for (IncomeDto i : incomeService.findAllIncomes()) {
            totalMoney += i.getAmount();
        }

        for (ExpenseDto e : expenseService.findAllExpenses()) {
            totalMoney -= e.getAmount();
        }

        return totalMoney;
    }

}
