package com.example.demo.models;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketCalculationResponse {
    private String destination;
    private Long adults;
    private Long children;
    private Long bags;
    private BigDecimal totalPrice;
}
