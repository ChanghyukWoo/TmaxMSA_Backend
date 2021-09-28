package com.finance.application.dto;

import com.finance.domain.enums.Account;
import com.finance.domain.enums.DCType;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Data
@Getter
@NoArgsConstructor
public class SlipRequestDto {

    private Account account;
    private DCType dcType;
    private int amount;
    private String slipBriefs;
}
