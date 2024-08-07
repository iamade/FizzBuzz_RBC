package com.adesegun.FizzBuzz;

import com.adesegun.FizzBuzz.service.FizzBuzzService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
public class FizzBuzzServiceTest {

    @Autowired
    private FizzBuzzService fizzBuzzService;

    @Test
    public void contextLoads() {
        assertEquals("1", fizzBuzzService.next());
        assertEquals("2", fizzBuzzService.next());
        assertEquals("Fizz", fizzBuzzService.next());
        assertEquals("4", fizzBuzzService.next());
        assertEquals("Buzz", fizzBuzzService.next());
        assertEquals("Fizz", fizzBuzzService.next());
    }
}
