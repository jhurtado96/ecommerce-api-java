package com.company.ecommerce.adapters.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/")
public class RootController {
	
	@Operation(summary = "Binvenida a la app")
    @GetMapping
	public String welcome() {
        return "Bienvenido al ecommerce";
    }
}
