package com.finance.application;

import com.finance.application.dto.TxCreateRequestDto;
import com.finance.application.dto.TxListResponseDto;
import com.finance.application.dto.TxResponseDto;
import com.finance.application.spi.TransactionsPort;
import com.finance.domain.exceptions.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TransactionService {

    private final TransactionsPort transactionsPort;

    @Transactional
    public TxResponseDto create(TxCreateRequestDto request){

        return this.transactionsPort.create(request);

    }


    public List<TxListResponseDto> findAllTx(){
        return this.transactionsPort.findAll();
    }


    public TxResponseDto findTxById(String id){
        return this.transactionsPort.findById(id).orElseThrow(
                () -> new BadRequestException("Invalid Transaction Id")
        );
    }

}