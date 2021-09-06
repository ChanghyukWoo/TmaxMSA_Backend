package com.finance.application.dto;

import com.finance.adapter.persistence.Slip;
import com.finance.domain.enums.Account;
import com.finance.domain.enums.DCType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SlipResponseDto {

    private String id;
    private Account account;
    private DCType dcType;
    private int amount;
    private String slipBriefs;


    public SlipResponseDto(String id, Account account, DCType dcType, int amount, String slipBriefs) {
        this.id = id;
        this.account = account;
        this.dcType = dcType;
        this.amount = amount;
        this.slipBriefs = slipBriefs;
    }

    public static SlipResponseDto from(Slip slip) {
        return new SlipResponseDto(
                slip.getId(),
                slip.getAccount(),
                slip.getDcType(),
                slip.getAmount(),
                slip.getSlipBriefs()
        );
    }
}
