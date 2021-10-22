package com.finance.application.spi;

import com.finance.application.dto.TxCreateRequestDto;
import com.finance.application.dto.TxListResponseDto;
import com.finance.application.dto.TxResponseDto;

import java.util.List;
import java.util.Optional;

public interface TransactionsPort {

    TxResponseDto create(TxCreateRequestDto request);
    List<TxListResponseDto> findAll();
    Optional<TxResponseDto> findById(String id);
}
