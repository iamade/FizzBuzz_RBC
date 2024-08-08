package com.adesegun.FizzBuzz.service;

import org.springframework.stereotype.Service;

/**
 * Service class to handle the FizzBuzz game logic.
 */
@Service
public class FizzBuzzService {

    // Current number in the sequence
    private int currentNumber = 1;

    /**
     * Retrieves the next value in the FizzBuzz sequence.
     * Resets to 1 after reaching 100.
     *
     * @return the FizzBuzz result as a String
     */
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

    /**
     * Determines the FizzBuzz value for a given number.
     *
     * @param number the current number to evaluate
     * @return "Fizz", "Buzz", "FizzBuzz", or the number itself as a String
     */
    private String getResultForNumber(int number){
        if(number % 15 == 0) return "FizzBuzz";
        if(number % 3 == 0) return "Fizz";
        if(number % 5 == 0) return "Buzz";
        return String.valueOf(number);
    }
}
