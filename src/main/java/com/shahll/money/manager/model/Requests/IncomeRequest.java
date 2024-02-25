package com.shahll.money.manager.model.Requests;

import com.shahll.money.manager.model.Tag;

public record IncomeRequest(long id, double amount, Tag tag, String note) {
}
