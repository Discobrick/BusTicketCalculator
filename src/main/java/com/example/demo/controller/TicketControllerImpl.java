package com.example.demo.controller;

import com.example.demo.controller.interfaces.ITicketController;
import com.example.demo.models.TicketCalculationRequest;
import com.example.demo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ticket")
public class TicketControllerImpl implements ITicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping(value = "/calculate/{destination}")
    public ResponseEntity calculateTicket(@PathVariable("destination") String destination, @RequestBody TicketCalculationRequest input) {
        try {
            return ResponseEntity.ok(ticketService.calculateTicketPrices(destination,input));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
