package com.shahll.money.manager.service;

import com.shahll.money.manager.dto.IncomeDto;
import com.shahll.money.manager.model.Income;

import java.util.List;

public interface IncomeService {

    List<IncomeDto> findAllIncomes();
    IncomeDto findIncomeById(long id);
    Income saveIncome(Income income);
    void updateIncome(IncomeDto incomeDto);
    void deleteIncome(long id);

}
