package com.finance.application.spi;

import com.finance.application.dto.SlipCreateRequestDto;
import com.finance.application.dto.SlipCreateResponseDto;
import com.finance.application.dto.SlipResponseDto;
import com.finance.application.dto.TxResponseDto;

import java.util.Optional;

public interface SlipPort {

    SlipCreateResponseDto create(SlipCreateRequestDto slipCreateRequestDto, Optional<TxResponseDto> txResponseDto);
}
