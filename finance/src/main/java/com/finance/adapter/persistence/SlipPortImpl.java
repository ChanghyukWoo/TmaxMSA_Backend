package com.finance.adapter.persistence;

import com.finance.application.dto.*;
import com.finance.application.spi.SlipPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class SlipPortImpl implements SlipPort{

    private final SlipRepository slipRepository;

    @Override
    public SlipCreateResponseDto create(SlipCreateRequestDto slipCreateRequestDto, Optional<TxResponseDto> txResponseDto) {
        Transactions transactions = txResponseDto.map(Transactions::from).orElse(null);

        List<SlipResponseDto> slipResponseDtoList = slipCreateRequestDto.getSlipRequestDtoList().stream().map(slipRequestDto ->
            SlipResponseDto.from(this.slipRepository.save(Slip.of(
                    slipRequestDto.getAccount(),
                    slipRequestDto.getDcType(),
                    slipRequestDto.getAmount(),
                    slipRequestDto.getSlipBriefs(),
                    transactions)))
        ).collect(Collectors.toList());

        return new SlipCreateResponseDto(transactions.getId(), slipResponseDtoList);
    }
}
