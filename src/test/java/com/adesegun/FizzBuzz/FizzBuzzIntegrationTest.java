package com.adesegun.FizzBuzz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FizzBuzzIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testFizzBuzzSequence() throws Exception {
        mockMvc.perform(get("/next")).andExpect(status().isOk()).andExpect(content().string("1"));
        mockMvc.perform(get("/next")).andExpect(status().isOk()).andExpect(content().string("2"));
        mockMvc.perform(get("/next")).andExpect(status().isOk()).andExpect(content().string("Fizz"));
        mockMvc.perform(get("/next")).andExpect(status().isOk()).andExpect(content().string("4"));
        mockMvc.perform(get("/next")).andExpect(status().isOk()).andExpect(content().string("Buzz"));
        // Continue testing other specific outputs or loop through a sequence to fully validate the behavior.
    }

}
