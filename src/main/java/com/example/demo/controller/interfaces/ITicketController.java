package com.example.demo.controller.interfaces;

import org.springframework.http.ResponseEntity;
import com.example.demo.models.TicketCalculationRequest;

public interface ITicketController {
    ResponseEntity calculateTicket(String destination,TicketCalculationRequest input);
}