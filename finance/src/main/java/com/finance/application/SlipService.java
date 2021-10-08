package com.finance.application;

import com.finance.application.dto.*;
import com.finance.application.spi.SlipPort;
import com.finance.application.spi.TransactionsPort;
import com.finance.domain.exceptions.BadRequestException;
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
    public SlipCreateResponseDto create(SlipCreateRequestDto SlipCreateRequestDto) {

        Optional<TxResponseDto> TxResponseDto = this.transactionsPort.findById(SlipCreateRequestDto.getTx_id());

        return slipPort.create(SlipCreateRequestDto, TxResponseDto);
    }

    public SlipSingleResponseDto findSlipById(String id) {
        return this.slipPort.findById(id).orElseThrow(
                () -> new BadRequestException("Invalid Slip Id")
        );

    }

}


