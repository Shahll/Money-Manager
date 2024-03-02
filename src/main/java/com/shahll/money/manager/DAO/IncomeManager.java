package com.shahll.money.manager.DAO;

import com.shahll.money.manager.model.Income;
import com.shahll.money.manager.model.Tag;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class IncomeManager {
    private List<Income> incomeList;
    private int currentId;

    private final TagManager tm;

    public IncomeManager(TagManager tm) {
        this.tm = tm;
        this.incomeList = new ArrayList<>();
        currentId = 0;
    }

    public List<Income> getIncomeList() {
        return incomeList;
    }

    public void addIncome(double amount, String tagName, String note) {
        if (amount == 0) {
            return;
        }

        Tag tag = tm.findTag(tagName);
        Income income = new Income(amount, tag, note);
        income.setId(currentId);
        currentId++;
        incomeList.add(income);
    }

    public void changeIncomeInformation(long id, double amount, String tagName, String note) {
        if (amount == 0 && tagName.isEmpty() && note.isEmpty() ) {
            return;
        }

        Income income = getIncomeById(id);
        if (income == null) {
            return;
        }

        if (amount != 0) {
            income.setAmount(amount);
        }

        if (!tagName.isEmpty()) {
            Tag tag = tm.findTag(tagName);
            income.setTag(tag);
        }

        if (!note.isEmpty()) {
            income.setNote(note);
        }

    }

    public Income getIncomeById(long id) {
        Income incomeToChange = null;
        for (Income i : incomeList) {
            if (i.getId() == id) {
                incomeToChange = i;
            }
        }
        return incomeToChange;
    }

    public void deleteIncome(long id) {
        if (id == -1) {
            incomeList.removeLast();
        } else {
            incomeList.removeIf(i -> i.getId() == id);
        }
    }

}
