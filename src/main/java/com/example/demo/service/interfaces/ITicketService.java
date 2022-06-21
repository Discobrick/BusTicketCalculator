package com.example.demo.service.interfaces;

import com.example.demo.models.TicketCalculationRequest;
import com.example.demo.models.TicketCalculationResponse;

public interface ITicketService {
    TicketCalculationResponse calculateTicketPrices(String destination,TicketCalculationRequest input);
}