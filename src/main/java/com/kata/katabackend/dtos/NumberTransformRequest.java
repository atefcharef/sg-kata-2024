package com.kata.katabackend.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class NumberTransformRequest {
    private int number;
}
