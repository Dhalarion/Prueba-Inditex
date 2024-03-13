package com.inditex_demo.prueba.repository;

import com.inditex_demo.prueba.entity.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PricesRepository extends JpaRepository<Prices, Integer> {

    @Query("select p from Prices p " +
            "where p.start_Date <= ?1 and p.end_Date >= ?1 " +
            "and p.product_Id = ?2 " +
            "and p.brand_Id = ?3 " +
            "order by p.priority desc")
    List<Prices> getPrices(LocalDateTime fecha, Integer product, Integer brand);

}

