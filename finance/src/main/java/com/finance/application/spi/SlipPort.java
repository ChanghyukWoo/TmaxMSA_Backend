package com.finance.application.spi;

import com.finance.application.dto.SlipCreateRequestDto;
import com.finance.application.dto.SlipCreateResponseDto;
import com.finance.application.dto.SlipSingleResponseDto;
import com.finance.application.dto.TxResponseDto;

import java.util.List;
import java.util.Optional;

public interface SlipPort {
    SlipCreateResponseDto create(SlipCreateRequestDto slipCreateRequestDto, Optional<TxResponseDto> txResponseDto);
    Optional<SlipSingleResponseDto> findById(String id);
    List<SlipSingleResponseDto> findByTxId(Optional<TxResponseDto> txResponseDto);

}
