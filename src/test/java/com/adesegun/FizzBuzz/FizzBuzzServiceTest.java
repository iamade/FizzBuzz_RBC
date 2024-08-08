package com.adesegun.FizzBuzz;

import com.adesegun.FizzBuzz.service.FizzBuzzService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Unit tests for FizzBuzzService.
 */
@SpringBootTest
public class FizzBuzzServiceTest {

    @Autowired
    private FizzBuzzService fizzBuzzService;

    /**
     * Tests the FizzBuzz sequence logic by manually advancing through the sequence
     * and verifying the output of each step matches expected FizzBuzz values.
     */
    @Test
    public void testFizzBuzzSequence() {
        assertEquals("1", fizzBuzzService.next());
        assertEquals("2", fizzBuzzService.next());
        assertEquals("Fizz", fizzBuzzService.next());
        assertEquals("4", fizzBuzzService.next());
        assertEquals("Buzz", fizzBuzzService.next());
        assertEquals("Fizz", fizzBuzzService.next());
        assertEquals("7", fizzBuzzService.next());
        assertEquals("8", fizzBuzzService.next());
        assertEquals("Fizz", fizzBuzzService.next());
        assertEquals("Buzz", fizzBuzzService.next());
        assertEquals("11", fizzBuzzService.next());
        assertEquals("Fizz", fizzBuzzService.next());
        assertEquals("13", fizzBuzzService.next());
        assertEquals("14", fizzBuzzService.next());
        assertEquals("FizzBuzz", fizzBuzzService.next());
    }

    /**
     * Tests the FizzBuzz sequence for incorrect outputs to ensure the service does not
     * mistakenly return incorrect values at any point in the sequence.
     */
    @Test
    public void testFailedFizzBuzzSequence() {
        assertNotEquals("Fizz", fizzBuzzService.next(), "First number should not be 'Fizz'");  // 1
        assertNotEquals("Buzz", fizzBuzzService.next(), "Second number should not be 'Buzz'"); // 2
        assertNotEquals("Buzz", fizzBuzzService.next(), "Third number should not incorrectly be 'Buzz'"); // 3 (Fizz)
        assertNotEquals("FizzBuzz", fizzBuzzService.next(), "Fourth number should not be 'FizzBuzz'"); // 4
        assertNotEquals("Fizz", fizzBuzzService.next(), "Fifth number should not be 'Fizz'"); // 5 (Buzz)
        assertNotEquals("Buzz", fizzBuzzService.next(), "Sixth number should not be 'Buzz'"); // 6 (Fizz)
        assertNotEquals("FizzBuzz", fizzBuzzService.next(), "Seventh number should not be 'FizzBuzz'"); // 7
        assertNotEquals("FizzBuzz", fizzBuzzService.next(), "Eighth number should not be 'FizzBuzz'"); // 8
        assertNotEquals("Buzz", fizzBuzzService.next(), "Ninth number should not incorrectly be 'Buzz'"); // 9 (Fizz)
        assertNotEquals("Fizz", fizzBuzzService.next(), "Tenth number should not be 'Fizz'"); // 10 (Buzz)
        assertNotEquals("Buzz", fizzBuzzService.next(), "Eleventh number should not be 'Buzz'"); // 11
        assertNotEquals("Buzz", fizzBuzzService.next(), "Twelfth number should not be 'Buzz'"); // 12 (Fizz)
        assertNotEquals("FizzBuzz", fizzBuzzService.next(), "Thirteenth number should not be 'FizzBuzz'"); // 13
        assertNotEquals("FizzBuzz", fizzBuzzService.next(), "Fourteenth number should not be 'FizzBuzz'"); // 14
        assertNotEquals("Fizz", fizzBuzzService.next(), "Fifteenth number should not incorrectly be 'Fizz'"); // 15 (FizzBuzz)
    }
}
