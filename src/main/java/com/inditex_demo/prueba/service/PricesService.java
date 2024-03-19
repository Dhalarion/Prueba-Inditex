package com.inditex_demo.prueba.service;

import com.inditex_demo.prueba.dto.PricesDto;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface PricesService {

    /**
     * Metodo para obtener un listado de articulos atendiendo a un rango de fechas,
     * asi como un codigo de producto y un codigo de rama.
     *
     * @param fecha
     * @param product
     * @param brand
     * @return
     */
    public ArrayList<PricesDto> getPrices(LocalDateTime fecha, Integer product, Integer brand);
}
