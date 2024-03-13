package com.inditex_demo.prueba.dto;

import com.inditex_demo.prueba.entity.Prices;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PricesDto implements Serializable {

    private Integer brand_Id;
    private LocalDateTime start_Date;
    private LocalDateTime end_Date;
    private Integer price_List;
    private Integer product_Id;
    private BigDecimal price;
    private String curr;

    public PricesDto(Prices prices) {
        super();
        this.brand_Id = prices.getBrand_Id();
        this.start_Date = prices.getStart_Date();
        this.end_Date = prices.getEnd_Date();
        this.price_List = prices.getPrice_List();
        this.product_Id = prices.getProduct_Id();
        this.price = prices.getPrice();
        this.curr = prices.getCurr();
    }


}
