package com.finance.application;


import com.finance.adapter.persistence.Slip;
import com.finance.adapter.persistence.Transactions;
import com.finance.application.dto.SlipCreateRequestDto;
import com.finance.application.dto.SlipCreateResponseDto;
import com.finance.application.dto.SlipRequestDto;
import com.finance.application.dto.TxResponseDto;
import com.finance.application.spi.SlipPort;
import com.finance.application.spi.TransactionsPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

import static com.finance.domain.enums.Account.test1;
import static com.finance.domain.enums.Account.test2;
import static com.finance.domain.enums.DCType.CREDIT;
import static com.finance.domain.enums.DCType.DEBIT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import javax.persistence.EntityManager;


@ExtendWith(MockitoExtension.class)
public class SlipServiceTest {

    @InjectMocks
    private SlipService slipService;

    @Mock
    private SlipPort slipPort;
    @Mock
    private TransactionsPort transactionsPort;

    private Slip slip;
    private Transactions transactions;
    private SlipRequestDto slipRequestDto;
    private TxResponseDto txResponseDto;
    private SlipCreateResponseDto slipCreateResponseDto;


    @BeforeEach
    public void setup(){
        this.transactions = Transactions.of("testBriefs", LocalDateTime.now(), 10000);
        this.txResponseDto = TxResponseDto.from(this.transactions);
    }


    @Test
    public void CreateTest() throws Exception{
        Mockito.when(transactionsPort.findById(this.transactions.getId())).thenReturn(java.util.Optional.ofNullable(this.txResponseDto));

        SlipCreateRequestDto slipCreateRequestDto = new SlipCreateRequestDto();

        List<SlipRequestDto> slipRequestDtoList = new ArrayList<>();
        SlipRequestDto slipRequestDto1 = new SlipRequestDto(test1, CREDIT, 100, "slipBriefs1");
        SlipRequestDto slipRequestDto2 = new SlipRequestDto(test2, DEBIT, 100, "slipBriefs2");
        slipRequestDtoList.add(slipRequestDto1);
        slipRequestDtoList.add(slipRequestDto2);

        slipCreateRequestDto.setTx_id(this.transactions.getId());
        slipCreateRequestDto.setSlipRequestDtoList(slipRequestDtoList);
        System.out.println("slipCreateRequestDto = " + slipCreateRequestDto);

        this.slipCreateResponseDto = slipService.create(slipCreateRequestDto);

        System.out.println("slipCreateResponseDtofinal = " + this.slipCreateResponseDto);
        assertEquals(this.transactions.getId(), this.slipCreateResponseDto.getTx_id());
    }
}
