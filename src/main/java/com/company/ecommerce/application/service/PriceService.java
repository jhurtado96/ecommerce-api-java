package com.company.ecommerce.application.service;

import com.company.ecommerce.domain.Price;
import com.company.ecommerce.infraestructure.repository.PriceRepository;
import com.company.ecommerce.adapters.rest.dto.PriceResponse;
import com.company.ecommerce.adapters.rest.exception.MissingParameterException;
import com.company.ecommerce.adapters.rest.exception.PriceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
public class PriceService {

    private final PriceRepository priceRepository;

    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public PriceResponse getPrice(LocalDateTime applicationDate, Integer productId, Long brandId) {
 
            List<Price> prices = priceRepository.findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                    brandId, productId, applicationDate, applicationDate
            );

            if (prices.isEmpty()) {
                throw new PriceNotFoundException("No se encontró un precio para los parámetros proporcionados.");
            }

            Price selectedPrice = prices.stream()
                    .max(Comparator.comparingInt(Price::getPriority))
                    .orElseThrow(() -> new PriceNotFoundException("No se encontró un precio válido."));

            return new PriceResponse(
                    selectedPrice.getBrandId(),
                    selectedPrice.getPriceList(),
                    selectedPrice.getStartDate(),
                    selectedPrice.getEndDate(),
                    selectedPrice.getProductId(),
                    selectedPrice.getPriority(),
                    selectedPrice.getPrice(),
                    selectedPrice.getCurrency()
            );
    }
}
