package com.example.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PassengerTypeEnum {
    ADULT("ADULT"),
    CHILD("CHILD");

    private final String code;

    public static PassengerTypeEnum findByCode(String code){
        for(PassengerTypeEnum value : values()){
            if(code.equalsIgnoreCase(value.getCode())){
                return value;
            }
        }
        return null;
    }
}
