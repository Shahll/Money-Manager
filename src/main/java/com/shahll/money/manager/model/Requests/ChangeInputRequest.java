package com.shahll.money.manager.model.Requests;

import com.shahll.money.manager.model.Tag;

public class ChangeInputRequest {
    public double amount;
    public Tag tag;
    public String note;
    public long id;

    public ChangeInputRequest() {
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
