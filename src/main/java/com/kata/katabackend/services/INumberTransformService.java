package com.kata.katabackend.services;

import com.kata.katabackend.exceptions.NumberNotInRangeException;

public interface INumberTransformService {
    String transformNumber(int number) throws NumberNotInRangeException;
}
