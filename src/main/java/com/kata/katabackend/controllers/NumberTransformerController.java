package com.kata.katabackend.controllers;

import com.kata.katabackend.dtos.NumberTransformRequest;
import com.kata.katabackend.exceptions.NumberNotInRangeException;
import com.kata.katabackend.services.INumberTransformService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
     */
    @Operation(
            summary = "Transform a number via GET",
            description = "Transforms a number passed as a path variable according to specific rules.")
    @GetMapping("/{number}")
    public String transformNumber(@PathVariable int number) throws NumberNotInRangeException {
        log.info("GET- Transforming number: {}", number);
        if (number < 0 || number > 100) {
            throw new NumberNotInRangeException("Number must be between 0 and 100.");
        }
        return numberTransformerService.transformNumber(number);
    }


    /**
     * Transforms a number passed in the request body.
     *
     * @param request the request containing the number to transform
     * @return the transformed string
     */
    @Operation(
            summary = "Transform a number via POST",
            description = "Transforms a number passed in the request body according to specific rules.")
    @PostMapping
    public String transformNumber(@RequestBody NumberTransformRequest request) throws NumberNotInRangeException {
        log.info("POST- Transforming number: {}", request.getNumber());
        if (request.getNumber() < 0 || request.getNumber() > 100) {
            throw new NumberNotInRangeException("Number must be between 0 and 100.");
        }
        return numberTransformerService.transformNumber(request.getNumber());
    }
}