package com.inditex_demo.prueba.service;

import com.inditex_demo.prueba.entity.Prices;
import com.inditex_demo.prueba.repository.PricesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;

@SpringBootTest
class PricesServiceTest {

    @Autowired
    private PricesService pricesService;

    @MockBean
    private PricesRepository pricesRepository;

    private Prices price;
    private ArrayList<Prices> prices;

    @BeforeEach
    void setUp() {
        price = Prices.builder()
                .price_Id(1)
                .brand_Id(1)
                .start_Date(LocalDateTime.parse("2020-06-14T00:00:00"))
                .end_Date(LocalDateTime.parse("2020-12-31T23:59:59"))
                .price_List(1)
                .product_Id(35455)
                .priority(0)
                .price(BigDecimal.valueOf(35.50))
                .curr("EUR")
                .build();
        prices = new ArrayList<>();
        prices.add(price);
        Mockito.when(pricesRepository.getPrices(any(LocalDateTime.class), anyInt(), anyInt())).thenReturn(prices);
    }

    @Test
    @DisplayName("Comprueba que el metodo getPrices funciona. No devuelve nulo")
    public void getPricesTest1(){
        assertNotNull(pricesService.getPrices(LocalDateTime.parse("2020-06-14T10:00:00"),35455,1));
    }

    @Test
    @DisplayName("Comprueba que el metodo getPrices funciona. No devuelve nulo")
    public void getPricesTest2(){
        assertNotNull(pricesService.getPrices(LocalDateTime.parse("2020-06-14T16:00:00"),35455,1));
    }

    @Test
    @DisplayName("Comprueba que el metodo getPrices funciona. No devuelve nulo")
    public void getPricesTest3(){
        assertNotNull(pricesService.getPrices(LocalDateTime.parse("2020-06-14T21:00:00"),35455,1));
    }

    @Test
    @DisplayName("Comprueba que el metodo getPrices funciona. No devuelve nulo")
    public void getPricesTest4(){
        assertNotNull(pricesService.getPrices(LocalDateTime.parse("2020-06-15T10:00:00"),35455,1));
    }

    @Test
    @DisplayName("Comprueba que el metodo getPrices funciona. No devuelve nulo")
    public void getPricesTest5(){
        assertNotNull(pricesService.getPrices(LocalDateTime.parse("2020-06-16T21:00:00"),35455,1));
    }

}