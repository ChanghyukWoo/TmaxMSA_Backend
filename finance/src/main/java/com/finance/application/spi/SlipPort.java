package com.finance.application.spi;

import com.finance.application.dto.SlipCreateRequestDto;
import com.finance.application.dto.SlipResponseDto;
import com.finance.application.dto.TxResponseDto;

public interface SlipPort {

    SlipResponseDto create(SlipCreateRequestDto slipCreateRequestDto, TxResponseDto txResponseDto);
}
