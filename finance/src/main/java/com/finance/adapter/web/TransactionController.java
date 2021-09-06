package com.finance.adapter.web;

import com.finance.application.TransactionService;
import com.finance.application.dto.TxCreateRequestDto;
import com.finance.application.dto.TxResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/api/v0/tx-info")
    public TxResponseDto create(@RequestBody TxCreateRequestDto request){

        return transactionService.create(request);

    }

    /*
     * TODO : findAll 서비스 구현
     */
//    @GetMapping("/api/v0/tx-info")
//    public List<TxListResponseDto> findAllTx(){
//
//    }

    @GetMapping("/api/v0/tx-info/{id}")
    public TxResponseDto findTxById(@PathVariable String id){

        return transactionService.findTxById(id);
    }
}
