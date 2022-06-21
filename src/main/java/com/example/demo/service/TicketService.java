package com.example.demo.service;

import com.example.demo.exceptions.TicketCalculationException;
import com.example.demo.models.TicketCalculationRequest;
import com.example.demo.models.TicketCalculationResponse;
import com.example.demo.service.interfaces.ITicketService;
import com.example.demo.utils.TicketUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Objects;

@Service
public class TicketService implements ITicketService {

    @Autowired
    private TicketUtils ticketUtils;
    @Autowired
    private Environment environment;

    @Override
    public TicketCalculationResponse calculateTicketPrices(String destination,TicketCalculationRequest input) {

        String destinationPrice = environment.getProperty("destination.".concat(destination.toLowerCase(Locale.ROOT)));

        if(Objects.isNull(input.getPassengerList())|| input.getPassengerList().isEmpty()){
            throw new TicketCalculationException("There are no passengers on the ticket");
        }

        return TicketCalculationResponse.builder()
                .destination(destination)
                .adults(ticketUtils.getPassangerCountByType(input,"adult"))
                .children(ticketUtils.getPassangerCountByType(input,"child"))
                .bags(ticketUtils.getBagCount(input))
                .totalPrice(BigDecimal.valueOf(ticketUtils.calculateTicketPrice(destinationPrice,input)))
                .build();
    }


}
