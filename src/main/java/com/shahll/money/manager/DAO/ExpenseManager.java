package com.shahll.money.manager.DAO;

import com.shahll.money.manager.model.Expense;
import com.shahll.money.manager.model.Tag;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class ExpenseManager {
    private List<Expense> expenseList;
    private int currentId;


    private final TagManager tm;

    public ExpenseManager(TagManager tm) {
        this.tm = tm;
        this.expenseList = new ArrayList<>();
        currentId = 0;
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }

    public void addExpense(double amount, String tagName, String note) {
        if (amount == 0) {
            return;
        }

        Tag tag = tm.findTag(tagName);
        Expense expense = new Expense(amount, tag, note);
        expense.setId(currentId);
        currentId++;
        expenseList.add(expense);
    }

    public void changeExpenseInformation(long id, double amount, String tagName, String note) {
        if (amount == 0 && tagName.isEmpty() && note.isEmpty() ) {
            return;
        }

        Expense expense = getExpenseById(id);
        if (expense == null) {
            return;
        }

        if (amount != 0) {
            expense.setAmount(amount);
        }

        if (!tagName.isEmpty()) {
            Tag tag = tm.findTag(tagName);
            expense.setTag(tag);
        }

        if (!note.isEmpty()) {
            expense.setNote(note);
        }

    }

    public Expense getExpenseById(long id) {
        Expense expenseToChange = null;
        for (Expense e : expenseList) {
            if (e.getId() == id) {
                expenseToChange = e;
            }
        }
        return expenseToChange;
    }

    public void deleteExpense(long id) {
        if (id == -1) {
            expenseList.removeLast();
        } else {
            expenseList.removeIf(e -> e.getId() == id);
        }
    }



}
