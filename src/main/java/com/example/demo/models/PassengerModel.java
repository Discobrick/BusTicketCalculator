package com.example.demo.models;

import com.example.demo.enums.PassengerTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PassengerModel {
    private String name;
    private String surname;
    private String type;
    private List<LuggageModel> luggageList;
}
