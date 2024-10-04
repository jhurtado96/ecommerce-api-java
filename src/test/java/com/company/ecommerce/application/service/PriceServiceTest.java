package com.company.ecommerce.application.service;

import com.company.ecommerce.adapters.rest.dto.PriceResponse;
import com.company.ecommerce.adapters.rest.exception.PriceNotFoundException;
import com.company.ecommerce.domain.Price;
import com.company.ecommerce.infraestructure.repository.PriceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PriceServiceTest {

    @Mock
    private PriceRepository priceRepository;

    @InjectMocks
    private PriceService priceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getPrice_NoPriceFound() {
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 10, 0, 0);
        Integer productId = 99999;
        Long brandId = (long) 1;

        when(priceRepository.findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                brandId, productId, applicationDate, applicationDate))
                .thenReturn(List.of());

        assertThrows(PriceNotFoundException.class, () ->
                priceService.getPrice(applicationDate, productId, brandId));
    }
}
