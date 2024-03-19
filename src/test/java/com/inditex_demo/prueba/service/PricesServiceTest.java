package com.inditex_demo.prueba.service;

import com.inditex_demo.prueba.dto.PricesDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PricesServiceTest {

    @Autowired
    private PricesService pricesService;


    @Test
    @DisplayName("En este caso el Price_List deberia ser 1. PRUEBA: http://localhost:8080/listado/2020-06-14T10:00:00/35455/1")
    public void getPricesTest1(){
        ArrayList<PricesDto> pricesDto = pricesService.getPrices(LocalDateTime.parse("2020-06-14T10:00:00"),35455,1);
        assertEquals(pricesDto.get(0).getPrice_List(), 1);
    }

    @Test
    @DisplayName("En este caso deberia devolver dos registros. PRUEBA: http://localhost:8080/listado/2020-06-14T16:00:00/35455/1")
    public void getPricesTest2(){
        ArrayList<PricesDto> pricesDto = pricesService.getPrices(LocalDateTime.parse("2020-06-14T16:00:00"),35455,1);
        assertEquals(pricesDto.size(), 2);
    }

    @Test
    @DisplayName("En este caso la divisa deberia ser EUR. PRUEBA: http://localhost:8080/listado/2020-06-14T21:00:00/35455/1")
    public void getPricesTest3(){
        ArrayList<PricesDto> pricesDto = pricesService.getPrices(LocalDateTime.parse("2020-06-14T21:00:00"),35455,1);
        assertEquals(pricesDto.get(0).getCurr(), "EUR");
    }

    @Test
    @DisplayName("En este caso los precios deberian ser 30,5€ y 35,5€ respectivamente. " +
            "PRUEBA: http://localhost:8080/listado/2020-06-15T10:00:00/35455/1")
    public void getPricesTest4(){
        ArrayList<PricesDto> pricesDto = pricesService.getPrices(LocalDateTime.parse("2020-06-15T10:00:00"),35455,1);
        assertEquals(pricesDto.get(0).getPrice().toString(), "30.50");
        assertEquals(pricesDto.get(1).getPrice().toString(), "35.50");
    }

    @Test
    @DisplayName("En este caso el resultado deberia ser distinto de vacio. PRUEBA: http://localhost:8080/listado/2020-06-16T21:00:00/35455/1")
    public void getPricesTest5(){
        ArrayList<PricesDto> pricesDto = pricesService.getPrices(LocalDateTime.parse("2020-06-16T21:00:00"),35455,1);
        assert(!pricesDto.isEmpty());
    }

}