package com.finance.adapter.web;

import com.finance.application.SlipService;
import com.finance.application.dto.SlipCreateRequestDto;
import com.finance.application.dto.SlipCreateResponseDto;
import com.finance.application.dto.SlipResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import java.security.PrivateKey;

@RestController
@RequiredArgsConstructor
public class SlipController {

    private final SlipService slipService;

    @PostMapping("/api/v0/slips")
    public SlipCreateResponseDto create(@RequestBody SlipCreateRequestDto slipCreateRequestDto){
        return slipService.create(slipCreateRequestDto);
    }
}
