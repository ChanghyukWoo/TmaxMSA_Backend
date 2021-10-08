package com.finance.adapter.persistence;

import com.finance.application.dto.TxResponseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Table(name="TRANSACTIONS")
public class Transactions {

    /*
     * Column Fields
     */
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "id", nullable = false, unique = true)
    private String id;

    @Column(name = "tx_briefs", nullable = false)
    private String txBriefs;

    @Column(name = "tx_date", nullable = false)
    private LocalDateTime txDate;

    @Column(name = "tx_amount", nullable = false)
    private int txAmount;


    /*
     * Mapping Fields
     */

    // TODO: 인사 테이블과 Mapping
    //private String empId;

    /*
     * Constructor
     */
    private Transactions(String id, String txBriefs, LocalDateTime txDate, int txAmount){
        this.id = id; //수정 필요함
        this.txBriefs = txBriefs;
        this.txDate = txDate;
        this.txAmount = txAmount;
    }

    private Transactions(String txBriefs, LocalDateTime txDate, int txAmount){
        this.txBriefs = txBriefs;
        this.txDate = txDate;
        this.txAmount = txAmount;
    }

    public static Transactions of(String txBriefs, LocalDateTime txDate, int txAmount)
    {
        return new Transactions(txBriefs, txDate, txAmount);
    }

    public static Transactions of(String id, String txBriefs, LocalDateTime txDate, int txAmount)
    {
        return new Transactions(id, txBriefs, txDate, txAmount);
    }

    public static Transactions from(TxResponseDto txResponseDto) {
        return new Transactions(
                txResponseDto.getTxId(),
                txResponseDto.getTxBriefs(),
                txResponseDto.getTxDate(),
                txResponseDto.getTxAmount()
        );
    }
}
