package com.finance.application.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Getter
@NoArgsConstructor
public class SlipCreateRequestDto {

    private String tx_id;
    private List<SlipRequestDto> slipRequestDtoList;

    public SlipCreateRequestDto(String tx_id, List<SlipRequestDto> slipRequestDtoList) {
        this.tx_id = tx_id;
        this.slipRequestDtoList = slipRequestDtoList;
    }
}

