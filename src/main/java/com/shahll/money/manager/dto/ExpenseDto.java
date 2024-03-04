package com.shahll.money.manager.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Builder
public class ExpenseDto {
    private long id;
    private double amount;
    private long tagId;
    private String note;
    private LocalDateTime createdOn;

}
