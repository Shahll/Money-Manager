package com.shahll.money.manager.service.impl;

import com.shahll.money.manager.dto.IncomeDto;
import com.shahll.money.manager.model.Income;
import com.shahll.money.manager.repository.IncomeRepository;
import com.shahll.money.manager.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class IncomeServiceImpl implements IncomeService {

    private IncomeRepository incomeRepository;

    @Autowired
    public IncomeServiceImpl(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    @Override
    public List<IncomeDto> findAllIncomes() {
        List<Income> incomes = incomeRepository.findAll();
        return incomes.stream().map(this::mapToIncomesDto).collect(Collectors.toList());
    }

    private IncomeDto mapToIncomesDto (Income income) {
        return IncomeDto.builder()
                .id(income.getId())
                .amount(income.getAmount())
                .tagId(income.getTagId())
                .note(income.getNote())
                .createdOn(income.getCreatedOn())
                .build();
    }

    @Override
    public IncomeDto findIncomeById(long id) {
        try {
            return mapToIncomesDto(Objects.requireNonNull(incomeRepository.findById(id)));
        } catch (Exception e) {
            // TODO: Handle properly
            return null;
        }
    }

    @Override
    public Income saveIncome(Income income) {
        return incomeRepository.save(income);
    }

    @Override
    public void updateIncome(IncomeDto incomeDto) {
        Income income = mapToIncome(incomeDto);
        incomeRepository.save(income);
    }

    private Income mapToIncome(IncomeDto income) {
        return Income.builder()
                .id(income.getId())
                .amount(income.getAmount())
                .tagId(income.getTagId())
                .note(income.getNote())
                .createdOn(income.getCreatedOn())
                .build();
    }

    @Override
    public void deleteIncome(long id) {
        incomeRepository.deleteById(id);
    }

}
