package com.finance.application;

import com.finance.application.dto.SlipCreateRequestDto;
import com.finance.application.dto.SlipResponseDto;
import com.finance.application.dto.TxResponseDto;
import com.finance.application.spi.SlipPort;
import com.finance.application.spi.TransactionsPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SlipService {

    private final SlipPort slipPort;
    private final TransactionsPort transactionsPort;


    @Transactional
    public SlipResponseDto create(SlipCreateRequestDto SlipCreateRequestDto) {

        TxResponseDto TxResponseDto = transactionsPort.findById(SlipCreateRequestDto.getTransaction_id());

        return slipPort.create(SlipCreateRequestDto, TxResponseDto);
    }

}


