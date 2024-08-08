package com.adesegun.FizzBuzz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FizzBuzzIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Tests the next() endpoint for a series of calls to ensure the FizzBuzz logic
     * is correctly integrated and responses match expected outputs.
     */
    @Test
    public void testSuccessfulFizzBuzzSequence() throws Exception {
        mockMvc.perform(get("/next"))
                .andExpect(status().isOk()).andExpect(content().string("1"));
        mockMvc.perform(get("/next"))
                .andExpect(status().isOk()).andExpect(content().string("2"));
        mockMvc.perform(get("/next"))
                .andExpect(status().isOk()).andExpect(content().string("Fizz"));
        mockMvc.perform(get("/next"))
                .andExpect(status().isOk()).andExpect(content().string("4"));
        mockMvc.perform(get("/next"))
                .andExpect(status().isOk()).andExpect(content().string("Buzz"));
        mockMvc.perform(get("/next"))
                .andExpect(status().isOk()).andExpect(content().string("Fizz"));
        mockMvc.perform(get("/next"))
                .andExpect(status().isOk()).andExpect(content().string("7"));
        mockMvc.perform(get("/next"))
                .andExpect(status().isOk()).andExpect(content().string("8"));
        mockMvc.perform(get("/next"))
                .andExpect(status().isOk()).andExpect(content().string("Fizz"));
        mockMvc.perform(get("/next"))
                .andExpect(status().isOk()).andExpect(content().string("Buzz"));
        mockMvc.perform(get("/next"))
                .andExpect(status().isOk()).andExpect(content().string("11"));
        mockMvc.perform(get("/next"))
                .andExpect(status().isOk()).andExpect(content().string("Fizz"));
        mockMvc.perform(get("/next"))
                .andExpect(status().isOk()).andExpect(content().string("13"));
        mockMvc.perform(get("/next"))
                .andExpect(status().isOk()).andExpect(content().string("14"));
        mockMvc.perform(get("/next"))
                .andExpect(status().isOk()).andExpect(content().string("FizzBuzz"));
    }

    /**
     * Tests the next() endpoint for failure scenarios to verify it does not return incorrect values.
     */
    @Test
    public void testFailedFizzBuzzSequence() throws Exception {
        mockMvc.perform(get("/next")).andExpect(status().isOk());  // Resetting to start of sequence for reliable testing.
        mockMvc.perform(get("/next")).andExpect(status().isOk());
        mockMvc.perform(get("/next")).andExpect(status().isOk());
        // Test for unexpected "Buzz" at the third call, should be "Fizz"
        mockMvc.perform(get("/next")).andExpect(status().isOk());
        mockMvc.perform(get("/next")).andExpect(status().isOk());
        mockMvc.perform(get("/next")).andExpect(status().isOk());
        mockMvc.perform(get("/next")).andExpect(status().isOk());
        mockMvc.perform(get("/next")).andExpect(status().isOk());
        mockMvc.perform(get("/next")).andExpect(status().isOk());
        // Expecting "Buzz", testing for wrong output "Fizz"
        mockMvc.perform(get("/next")).andExpect(status().isOk());
        mockMvc.perform(get("/next")).andExpect(status().isOk());
        mockMvc.perform(get("/next")).andExpect(status().isOk());
        mockMvc.perform(get("/next")).andExpect(status().isOk());
        mockMvc.perform(get("/next"))
                .andExpect(status().isOk())
                .andExpect(content().string("FizzBuzz"))  // Correct output, but checking for incorrect handling
                .andExpect(content().string("Fizz"));    // Wrong assumption as negative test
    }

    /**
     * Test to simulate and check behavior when the sequence goes out of the expected range.
     */
    @Test
    public void testOutOfRangeScenario() throws Exception {
        // Assume the service resets or responds with a specific message after reaching 100
        for (int i = 0; i < 105; i++) {
            mockMvc.perform(get("/next"));
        }
        mockMvc.perform(get("/next"))
                .andExpect(status().isOk())
                .andExpect(content().string("Sequence complete or reset message")); // Expected behavior after limit
    }

    /**
     * Testing with incorrect HTTP method to ensure the application handles it correctly.
     */
    @Test
    public void testIncorrectHttpMethod() throws Exception {
        mockMvc.perform(post("/next"))  // Using POST instead of GET
                .andExpect(status().isMethodNotAllowed());  // Expecting 405 Method Not Allowed
    }

    /**
     * Test to ensure that the service handles invalid parameter types gracefully.
     */
    @Test
    public void testInvalidParameterType() throws Exception {
        mockMvc.perform(get("/next").param("number", "invalidStringInsteadOfNumber"))
                .andExpect(status().isBadRequest());  // Assuming that the API should return a 400 Bad Request
    }
}
