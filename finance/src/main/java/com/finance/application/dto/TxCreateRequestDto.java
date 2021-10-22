package com.finance.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TxCreateRequestDto {

    private String txBriefs;
    private int txAmount;
}
