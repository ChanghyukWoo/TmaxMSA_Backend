package com.finance.application.dto;

import com.finance.adapter.persistence.Transactions;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class TxListResponseDto {
    private String txId;
    private String txBriefs;
    private LocalDateTime txDate;
    private int txAmount;


    private TxListResponseDto(String txId, String txBriefs, LocalDateTime txDate, int txAmount){
        this.txId = txId;
        this.txBriefs = txBriefs;
        this.txDate = txDate;
        this.txAmount = txAmount;
    }

    public static TxListResponseDto from(Transactions transactions){
        return new TxListResponseDto(
                transactions.getId(),
                transactions.getTxBriefs(),
                transactions.getTxDate(),
                transactions.getTxAmount()
        );
    }

}
