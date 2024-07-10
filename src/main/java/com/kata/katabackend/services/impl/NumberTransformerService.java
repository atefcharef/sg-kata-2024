package com.kata.katabackend.services.impl;

import com.kata.katabackend.exceptions.NumberNotInRangeException;
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
     * @throws NumberNotInRangeException when number is out of range
     */
    @Override
    public String transformNumber(int number) throws NumberNotInRangeException {
            return NumberTransformer.transform(number);
    }


}