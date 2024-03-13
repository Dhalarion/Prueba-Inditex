package com.inditex_demo.prueba.controller;

import com.inditex_demo.prueba.dto.PricesDto;
import com.inditex_demo.prueba.service.PricesService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PricesController.class)
class pricesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PricesService pricesService;

    private PricesDto priceDto;
    private ArrayList<PricesDto> pricesDto;

    @BeforeEach
    void setUp() {
        priceDto = PricesDto.builder()
                .brand_Id(1)
                .start_Date(LocalDateTime.parse("2020-06-14T00:00:00"))
                .end_Date(LocalDateTime.parse("2020-12-31T23:59:59"))
                .price_List(1)
                .product_Id(35455)
                .price(BigDecimal.valueOf(35.50))
                .curr("EUR")
                .build();
        pricesDto = new ArrayList<>();
        pricesDto.add(priceDto);
    }

    @Test
    public void getPrices() throws Exception{
        Mockito.when(pricesService.getPrices(LocalDateTime.parse("2020-06-14T10:00:00"),35455,1)).thenReturn(pricesDto);
        mockMvc.perform(get("/listado/2020-06-14T10:00:00/35455/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].brand_Id").value(priceDto.getBrand_Id()));
    }

}