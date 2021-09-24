package com.finance.adapter.persistence;

import com.finance.domain.enums.Account;
import com.finance.domain.enums.DCType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "SLIP")
public class Slip {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "id", nullable = false, unique = true)
    private String id;

    @Column(name = "slip_account", nullable = false)
    private Account account;

    @Column(name = "slip_dctype", nullable = false)
    private DCType dcType;

    @Column(name = "slip_amount", nullable = false)
    private int amount;

    @Column(name = "slip_briefs", nullable = false)
    private String slipBriefs;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "id")
    private Transactions transactions;


    public Slip(Account account, DCType dcType, int amount, String slipBriefs, Transactions transactions) {
        this.account = account;
        this.dcType = dcType;
        this.amount = amount;
        this.slipBriefs = slipBriefs;
        this.transactions = transactions;
    }

    public static Slip of(Account account, DCType dcType, int amount, String slipBriefs, Transactions transactions)
    {
        return new Slip(account, dcType, amount, slipBriefs, transactions);
    }
}
