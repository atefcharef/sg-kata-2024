package com.kata.katabackend.services;

import com.kata.katabackend.utils.NumberTransformer;
import org.springframework.stereotype.Service;

@Service
public class NumberTransformerService {

    public String transformNumber(int number) {
        return NumberTransformer.transform(number);
    }
}