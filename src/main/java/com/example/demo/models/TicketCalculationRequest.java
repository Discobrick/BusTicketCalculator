package com.example.demo.models;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketCalculationRequest {
    private List<PassengerModel> passengerList;
}
