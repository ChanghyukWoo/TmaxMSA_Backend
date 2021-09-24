package com.finance.adapter.persistence;

import com.finance.application.dto.SlipCreateRequestDto;
import com.finance.application.dto.SlipResponseDto;
import com.finance.application.dto.TxResponseDto;
import com.finance.application.spi.SlipPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SlipPortImpl implements SlipPort{

    @Override
    public SlipResponseDto create(SlipCreateRequestDto slipCreateRequestDto, TxResponseDto txResponseDto) {
        return null;
    }
}
