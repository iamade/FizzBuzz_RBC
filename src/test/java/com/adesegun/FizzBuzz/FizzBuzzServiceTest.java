package com.adesegun.FizzBuzz;

import com.adesegun.FizzBuzz.service.FizzBuzzService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Unit tests for FizzBuzzService.
 */
@SpringBootTest
public class FizzBuzzServiceTest {

    /**
     * Tests the FizzBuzz sequence logic by manually advancing through the sequence
     * and verifying the output of each step matches expected FizzBuzz values.
     */
    @Autowired
    private FizzBuzzService fizzBuzzService;

    @Test
    public void testFizzBuzzSequence() {
        assertEquals("1", fizzBuzzService.next());
        assertEquals("2", fizzBuzzService.next());
        assertEquals("Fizz", fizzBuzzService.next());
        assertEquals("4", fizzBuzzService.next());
        assertEquals("Buzz", fizzBuzzService.next());
        assertEquals("Fizz", fizzBuzzService.next());
    }
}
