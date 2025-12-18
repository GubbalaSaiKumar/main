package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ApiController.class)
public class ApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHelloEndpoint() throws Exception {
        mockMvc.perform(get("/api/hello"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Hello from DevOps Demo App!"));
    }

    @Test
    public void testStatusEndpoint() throws Exception {
        mockMvc.perform(get("/api/status"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("UP"))
                .andExpect(jsonPath("$.application").value("DevOps Demo Application"))
                .andExpect(jsonPath("$.version").value("1.0.0"));
    }

    @Test
    public void testGreetEndpoint() throws Exception {
        mockMvc.perform(get("/api/greet/John"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.greeting").value("Hello, John!"));
    }
}
