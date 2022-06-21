package com.example.demo.utils;

import com.example.demo.constants.TicketCalculationConstants;
import com.example.demo.enums.PassengerTypeEnum;
import com.example.demo.exceptions.TicketCalculationException;
import com.example.demo.models.PassengerModel;
import com.example.demo.models.TicketCalculationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class TicketUtils {

    @Autowired
    private Environment environment;


    public Double calculateTicketPrice(String destinationPrice, TicketCalculationRequest input) {
        Double vatTax = Double.parseDouble(Objects.requireNonNull(environment.getProperty("tax.vat.multiplier")));
        try {
            Double finalPrice = 0.0;
            for (PassengerModel passenger : input.getPassengerList()) {
                if (passenger.getType().equalsIgnoreCase(PassengerTypeEnum.ADULT.getCode())) {
                    finalPrice += (Double.parseDouble(destinationPrice) * vatTax);
                } else {
                    finalPrice += (Double.parseDouble(destinationPrice) * TicketCalculationConstants.CHILD_TICKET_PRICE_MULTIPLIER * vatTax);
                }
                finalPrice += (passenger.getLuggageList().size() * Double.parseDouble(destinationPrice) * TicketCalculationConstants.BAG_PRICE_MULTIPLIER * vatTax);

            }
            return finalPrice;
        } catch (Exception e) {
            throw new TicketCalculationException("Error calculating ticket price", e);
        }

    }

    public Long getPassangerCountByType(TicketCalculationRequest input, String type) {
        try {
            return input.getPassengerList().stream().filter(p -> p.getType().equalsIgnoreCase(type)).count();
        } catch (Exception e) {
            throw new TicketCalculationException("Couldn't find PassengerType " + type, e);
        }
    }

    public Long getBagCount(TicketCalculationRequest input) {
        AtomicReference<Long> bags = new AtomicReference<>(0L);
        input.getPassengerList().forEach(p -> bags.updateAndGet(v -> v + (long) p.getLuggageList().size()));
        return bags.get();
    }
}
