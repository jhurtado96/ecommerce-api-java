package com.company.ecommerce.adapters.rest.controller;

import com.company.ecommerce.adapters.rest.dto.PriceResponse;
import com.company.ecommerce.application.service.PriceService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/prices")
public class PriceController {

    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @Operation(summary = "Consultar precio de un producto")
    @GetMapping
    public ResponseEntity<PriceResponse> getPrice(
            @RequestParam("applicationDate")
            @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss") LocalDateTime applicationDate,

            @RequestParam("productId") Integer productId,
            @RequestParam("brandId") Long brandId
    ) {
        PriceResponse response = priceService.getPrice(applicationDate, productId, brandId);
        return ResponseEntity.ok(response);
    }
}
