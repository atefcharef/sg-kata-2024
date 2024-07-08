package com.kata.katabackend.controllers;

import com.kata.katabackend.dtos.NumberTransformRequest;
import com.kata.katabackend.services.NumberTransformerService;
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

    @GetMapping("/{number}")
    public String transformNumber(@PathVariable int number) {
        return numberTransformerService.transformNumber(number);
    }

    @PostMapping
    public String transformNumber(@RequestBody NumberTransformRequest request) {
        return numberTransformerService.transformNumber(request.getNumber());
    }
}