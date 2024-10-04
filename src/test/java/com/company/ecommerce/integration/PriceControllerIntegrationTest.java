package com.company.ecommerce.integration;

import com.company.ecommerce.domain.Price;
import com.company.ecommerce.infraestructure.repository.PriceRepository;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class PriceControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private PriceRepository priceRepository;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
        priceRepository.deleteAll();

        Price p1 = new Price((long) 1, 1, LocalDateTime.of(2020, 6, 14, 0, 0, 0),
                LocalDateTime.of(2020, 12, 31, 23, 59, 59), 35455, 1,
                new BigDecimal("35.50"), "EUR");
        Price p2 =new Price((long) 1, 1, LocalDateTime.of(2020, 6, 14, 0, 0, 0),
                LocalDateTime.of(2021, 12, 31, 23, 49, 59), 35455, 1,
                new BigDecimal("25.45"), "EUR");
        Price p3 = new Price((long) 1, 1, LocalDateTime.of(2020, 6, 14, 0, 0, 0),
                LocalDateTime.of(2022, 12, 31, 23, 39, 59), 35455, 1,
                new BigDecimal("30.50"), "EUR");
        Price p4 = new Price((long) 1, 1, LocalDateTime.of(2020, 6, 14, 0, 0, 0),
                LocalDateTime.of(2023, 12, 31, 23, 29, 59), 35455, 1,
                new BigDecimal("38.95"), "EUR");

        priceRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
    }

    @Test
    void testPrice_14th_10am() {
        given()
                .contentType(ContentType.JSON)
                .queryParam("applicationDate", "2020-06-14-00.00.00")
                .queryParam("productId", 35455)
                .queryParam("brandId", 1)
                .when()
                .get("/prices")
                .then()
                .statusCode(200);
    }

    @Test
    void testPrice_14th_16pm() {
        given()
                .contentType(ContentType.JSON)
                .queryParam("applicationDate", "2020-06-14-15.00.00")
                .queryParam("productId", 3)
                .queryParam("brandId", 1)
                .when()
                .get("/prices")
                .then()
                .statusCode(404);
    }

    @Test
    void testPrice_14th_21pm() {
        given()
                .contentType(ContentType.JSON)
                .queryParam("applicationDate", "2020-06-14-21.00.00")
                .queryParam("productId", 35455)
                .queryParam("brandId", 1)
                .when()
                .get("/prices")
                .then()
                .statusCode(200)
                .body("priceList", equalTo(1))
                .body("price", equalTo(35.50f));
    }

    @Test
    void testPrice_15th_10am() {
        given()
                .contentType(ContentType.JSON)
                .queryParam("applicationDate", "2020-06-15-10.00.00")
                .queryParam("productId", 35455)
                .when()
                .get("/prices")
                .then()
                .statusCode(400)
                .body(equalTo("Missing required parameter"));
    }
}
