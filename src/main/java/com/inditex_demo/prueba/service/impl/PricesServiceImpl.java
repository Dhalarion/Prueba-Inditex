package com.inditex_demo.prueba.service.impl;

import com.inditex_demo.prueba.dto.PricesDto;
import com.inditex_demo.prueba.entity.Prices;
import com.inditex_demo.prueba.repository.PricesRepository;
import com.inditex_demo.prueba.service.PricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class PricesServiceImpl implements PricesService {

    @Autowired
    PricesRepository pricesRepository;

    public ArrayList<PricesDto> getPrices(LocalDateTime fecha, Integer product, Integer brand) {
        ArrayList<Prices> pricesList = (ArrayList<Prices>) pricesRepository.getPrices(fecha, product, brand);
        ArrayList<PricesDto> pricesListDto = new ArrayList<>();

        for (Prices prices : pricesList){
            pricesListDto.add(new PricesDto(prices));
        }

        return pricesListDto;
    }
}
