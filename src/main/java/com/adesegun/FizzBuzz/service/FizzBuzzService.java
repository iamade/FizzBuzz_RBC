package com.adesegun.FizzBuzz.service;

import org.springframework.stereotype.Service;

@Service
public class FizzBuzzService {
    private int currentNumber = 1;

    public String next(){
        if(currentNumber > 100){
            currentNumber = 1; //Reset for reusability
            return "Sequence complete";
        }

        String result = getResultForNumber(currentNumber);
        System.out.println(result); //output to console
        currentNumber++;
        return result;
    }

    private String getResultForNumber(int number){
        if(number % 15 == 0) return "FizzBuzz";
        if(number % 3 == 0) return "Fizz";
        if(number % 5 == 0) return "Buzz";
        return String.valueOf(number);
    }
}
