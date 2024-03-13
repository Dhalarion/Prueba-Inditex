package com.inditex_demo.prueba.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "Prices")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Prices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer price_Id;

    private Integer brand_Id;
    private LocalDateTime start_Date;
    private LocalDateTime end_Date;
    private Integer price_List;
    private Integer product_Id;
    private Integer priority;
    private BigDecimal price;
    private String curr;
}
