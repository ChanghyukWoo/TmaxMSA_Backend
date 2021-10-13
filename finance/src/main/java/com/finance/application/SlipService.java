package com.finance.application;

import com.finance.application.dto.*;
import com.finance.application.spi.SlipPort;
import com.finance.application.spi.TransactionsPort;
import com.finance.domain.enums.DCType;
import com.finance.domain.exceptions.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
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

        Integer sum_credit = SlipCreateRequestDto.getSlipRequestDtoList().stream().filter(s -> s.getDcType() == DCType.CREDIT).map(s -> s.getAmount()).reduce(0, Integer::sum);
        Integer sum_debit = SlipCreateRequestDto.getSlipRequestDtoList().stream().filter(s -> s.getDcType() == DCType.DEBIT).map(s -> s.getAmount()).reduce(0, Integer::sum);

        if (sum_credit == sum_debit) {
            return slipPort.create(SlipCreateRequestDto, TxResponseDto);
        }
        else {
            throw new com.finance.domain.exceptions.BadRequestException("Invalid Credit Debit Matching");
        }
    }

    public SlipSingleResponseDto findSlipById(String id) {
        return this.slipPort.findById(id).orElseThrow(
                () -> new BadRequestException("Invalid Slip Id")
        );

    }

    public List<SlipSingleResponseDto> findSlipByTxId(String id) {

        Optional<TxResponseDto> TxResponseDto = this.transactionsPort.findById(id);

        return this.slipPort.findByTxId(TxResponseDto);
    }
}


