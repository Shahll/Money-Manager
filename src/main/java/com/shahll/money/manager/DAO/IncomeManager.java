package com.shahll.money.manager.DAO;

import com.shahll.money.manager.model.Income;
import com.shahll.money.manager.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IncomeManager {
    private List<Income> incomeList;

    public IncomeManager() {
        this.incomeList = new ArrayList<>();
    }


    public void addIncome(double amount, Tag tag, String note) {
        if (note.isEmpty()) {
            note = "";
        }
        if (amount == 0) {
            return;
        }
        Income income = new Income(amount, tag, note);
        incomeList.add(income);
    }

    public void deleteIncome(double amount, Tag tag) {
        if (amount == 0) {
            return;
        }
        incomeList.removeIf(i -> i.getTag().getName().equals(tag.getName()) && i.getAmount() == amount);
    }

    public void deleteIncome() {
        incomeList.removeLast();
    }

    public void addNote(double amount, Tag tag, String note) {
        if (note.isEmpty() || amount == 0) {
            return;
        }
        for (Income i : incomeList) {
            if (i.getTag().getName().equals(tag.getName()) && i.getAmount() == amount) {
                i.setNote(note);
            }
        }
    }

}
