package com.finance.application;

import com.finance.application.dto.TxCreateRequestDto;
import com.finance.application.dto.TxResponseDto;
import com.finance.application.spi.TransactionsPort;
import com.finance.domain.exceptions.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TransactionService {

    private final TransactionsPort transactionsPort;

    @Transactional
    public TxResponseDto create(TxCreateRequestDto request){

        return transactionsPort.create(request);

    }

    /*
     * TODO: findAll 서비스 구현
     */
/*
    public List<TxListResponseDto> findAllTx(){
    }
*/

    public TxResponseDto findTxById(String id){
        return this.transactionsPort.findById(id).orElseThrow(
                () -> new BadRequestException("Invalid Transaction Id")
        );
    }

}