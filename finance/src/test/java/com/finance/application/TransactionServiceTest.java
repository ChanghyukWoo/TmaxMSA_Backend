package com.finance.application;

import com.finance.adapter.persistence.Transactions;
import com.finance.application.dto.TxResponseDto;
import com.finance.application.spi.TransactionsPort;
import com.finance.domain.exceptions.BadRequestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {

    @InjectMocks
    private TransactionService transactionService;
    @Mock
    private TransactionsPort transactionsPort;

    private Transactions transactions;
    private TxResponseDto response;

    @BeforeEach
    public void setup(){
        this.transactions = Transactions.of("testBriefs", LocalDateTime.now(), 10000);
        this.response = TxResponseDto.from(this.transactions);
    }

    @Test
    public void findTransactions() throws Exception{
        //given
        String id = this.transactions.getId();
        Mockito.when(transactionsPort.findById(this.transactions.getId())).thenReturn(java.util.Optional.ofNullable(this.response));

        //when
        TxResponseDto txById = transactionService.findTxById(id);
        System.out.println("txById = " + txById);

        //then
        assertEquals(txById, this.response);
        assertThrows(BadRequestException.class, () -> {
            transactionService.findTxById("30");
        });
        verify(transactionsPort).findById(id);
    }

}