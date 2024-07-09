package com.kata.katabackend.services.impl;

import com.kata.katabackend.services.INumberTransformService;
import com.kata.katabackend.utils.NumberTransformer;
import org.springframework.stereotype.Service;

@Service
public class NumberTransformerService implements INumberTransformService {

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