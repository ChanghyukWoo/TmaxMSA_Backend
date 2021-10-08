package com.finance.application.dto;

import com.finance.adapter.persistence.Slip;
import com.finance.domain.enums.Account;
import com.finance.domain.enums.DCType;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class SlipSingleResponseDto {

    private String id;
    private Account account;
    private DCType dcType;
    private int amount;
    private String slipBriefs;
    private String tx_id;


    public SlipSingleResponseDto(String id, Account account, DCType dcType, int amount, String slipBriefs, String tx_id) {
        this.id = id;
        this.account = account;
        this.dcType = dcType;
        this.amount = amount;
        this.slipBriefs = slipBriefs;
        this.tx_id = tx_id;
    }

    public static SlipSingleResponseDto from(Slip slip) {
        return new SlipSingleResponseDto(
                slip.getId(),
                slip.getAccount(),
                slip.getDcType(),
                slip.getAmount(),
                slip.getSlipBriefs(),
                slip.getTransactions().getId()
        );
    }
}
