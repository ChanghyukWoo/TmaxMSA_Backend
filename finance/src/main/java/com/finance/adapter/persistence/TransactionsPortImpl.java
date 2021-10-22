package com.finance.adapter.persistence;

import com.finance.application.dto.TxCreateRequestDto;
import com.finance.application.dto.TxListResponseDto;
import com.finance.application.dto.TxResponseDto;
import com.finance.application.spi.TransactionsPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TransactionsPortImpl implements TransactionsPort {

    private final TransactionsRepository transactionsRepository;

    @Override
    public TxResponseDto create(TxCreateRequestDto request) {

        Transactions tx = this.transactionsRepository.save(Transactions.of(
                        request.getTxBriefs(), LocalDateTime.now(), request.getTxAmount()));

        return TxResponseDto.from(tx);
    }
    @Override
    public List<TxListResponseDto> findAll() {

        return this.transactionsRepository.findAll()
                .stream().map(TxListResponseDto::from).collect(Collectors.toList());

    }

    @Override
    public Optional<TxResponseDto> findById(String id) {
        return this.transactionsRepository.findById(id).map(TxResponseDto::from);
    }
}
