package com.kata.katabackend.controllers;

import com.kata.katabackend.exceptions.NumberNotInRangeException;
import com.kata.katabackend.services.INumberTransformService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping()
@Slf4j
public class NumberTransformerController {

    private final INumberTransformService numberTransformerService;


    @Autowired
    public NumberTransformerController(INumberTransformService numberTransformerService) {
        this.numberTransformerService = numberTransformerService;
    }

    /**
     * Transforms a number passed as a path variable.
     *
     * @param number the number to transform
     * @return the transformed string
     * @throws NumberNotInRangeException if the number is not in the range 0-100
     */
    @Operation(
            summary = "Transform a number via GET",
            description = "Transforms a number passed as a path variable according to specific rules.")
    @GetMapping("/{number}")
    public String transformNumber(@PathVariable int number) throws NumberNotInRangeException {
            return numberTransformerService.transformNumber(number);
    }

}