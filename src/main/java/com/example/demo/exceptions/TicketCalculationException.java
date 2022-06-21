package com.example.demo.exceptions;

import org.springframework.context.MessageSource;

public class TicketCalculationException extends RuntimeException {

    public TicketCalculationException(String errorMessage,Throwable err){
        super(errorMessage,err);
    }

    public TicketCalculationException(String errorMessage){
        super(errorMessage);
    }
}
