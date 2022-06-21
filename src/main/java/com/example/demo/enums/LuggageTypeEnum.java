package com.example.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum LuggageTypeEnum {
    LARGE("LARGE"),
    SMALL("SMALL");

    private final String code;

    private static LuggageTypeEnum findByCode(String code){
        for (LuggageTypeEnum value : values()){
            if(code.equalsIgnoreCase(value.getCode())){
                return value;
            }
        }
        return null;
    }
}
