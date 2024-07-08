package com.kata.katabackend.controllers;

import com.kata.katabackend.dtos.NumberTransformRequest;
import com.kata.katabackend.services.NumberTransformerService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/transform")
@RequiredArgsConstructor
public class NumberTransformerController {

    private final NumberTransformerService numberTransformerService;


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
    public String transformNumber(@PathVariable int number) {
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
    public String transformNumber(@RequestBody NumberTransformRequest request) {
        return numberTransformerService.transformNumber(request.getNumber());
    }
}