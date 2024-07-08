package com.kata.katabackend.services;

import com.kata.katabackend.utils.NumberTransformer;
import org.springframework.stereotype.Service;

@Service
public class NumberTransformerService {

    /**
     * Service transform number.
     *
     * @param number int
     * @return String
     */
    public String transformNumber(int number) {
        return NumberTransformer.transform(number);
    }
}