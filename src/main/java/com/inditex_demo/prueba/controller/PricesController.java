package com.inditex_demo.prueba.controller;

import com.inditex_demo.prueba.dto.PricesDto;
import com.inditex_demo.prueba.error.LocalNotFoundException;
import com.inditex_demo.prueba.service.PricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "/listado")
public class PricesController {
    @Autowired
    PricesService pricesService;

    @GetMapping("/{fecha}/{productId}/{brandId}")
    public ArrayList<PricesDto> getPrices(@PathVariable LocalDateTime fecha, @PathVariable Integer productId, @PathVariable Integer brandId) throws LocalNotFoundException {
        return pricesService.getPrices(fecha, productId, brandId);
    }


}
