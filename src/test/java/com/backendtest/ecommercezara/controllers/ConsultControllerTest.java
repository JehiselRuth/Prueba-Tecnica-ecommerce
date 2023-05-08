// package com.backendtest.ecommercezara.controllers;

// import org.junit.jupiter.api.Assertions;
// import org.junit.jupiter.api.Test;

// import java.math.BigDecimal;
// import java.time.LocalDateTime;

// public class ConsultControllerTest {

//     @Test
//     public void test1peticion10AmDeldia14DelProducto35455paraBrand1 () {
//         // Arrange
//         LocalDateTime requestTime = LocalDateTime.of(2023, 5, 14, 10, 0);
//         int productId = 35455;
//         int brandId = 1;
//         BigDecimal expectedPrice = new BigDecimal("35.50");
//         PriceCalculator calculator = new PriceCalculator();

//         // Act
//         BigDecimal actualPrice = calculator.calculatePrice(requestTime, productId, brandId);

//         // Assert
//         Assertions.assertEquals(expectedPrice, actualPrice);
//     }
// }
