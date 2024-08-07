package com.adesegun.FizzBuzz.controller;

import com.adesegun.FizzBuzz.service.FizzBuzzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FizzBuzzController {

    @Autowired
    private FizzBuzzService fizzBuzzService;

    @GetMapping("/next")
    public String nextFizzBuzz(){
        return fizzBuzzService.next();
    }
}
