package com.shahll.money.manager.model;

public class Expense {
    private double amount;
    private Tag tag;
    private String note;
    private double id;

    public Expense(double amount, Tag tag, String note) {
        this.amount = amount;
        this.tag = tag;
        this.note = note;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }
}
