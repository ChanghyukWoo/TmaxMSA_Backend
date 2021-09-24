package com.finance.application.dto;

import com.finance.domain.enums.Account;
import com.finance.domain.enums.DCType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SlipCreateRequestDto {

    private Account account;
    private DCType dcType;
    private int amount;
    private String slipBriefs;
    private String tx_id;
}
