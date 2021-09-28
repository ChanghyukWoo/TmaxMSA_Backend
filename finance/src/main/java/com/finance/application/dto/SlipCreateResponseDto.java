package com.finance.application.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
public class SlipCreateResponseDto {

    private String tx_id;
    private List<SlipResponseDto> slipResponseDtoList;

    public SlipCreateResponseDto(String tx_id, List<SlipResponseDto> slipResponseDtoList) {
        this.tx_id = tx_id;
        this.slipResponseDtoList = slipResponseDtoList;
    }

}
