package com.company.ecommerce.infraestructure.repository;

import com.company.ecommerce.domain.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
    List<Price> findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
            Long brandId,
            Integer productId,
            LocalDateTime applicationDate,
            LocalDateTime applicationDate2
    );
}
