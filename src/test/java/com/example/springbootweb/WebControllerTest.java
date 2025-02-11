package com.example.springbootweb;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(WebController.class)
class WebControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testHomeEndpoint() throws Exception {
        mockMvc.perform(get("/"))
               .andExpect(status().isOk())
               .andExpect(content().string("Hello, Spring Boot!"));
    }

    /**
     * Tests the /hello endpoint
     * Verifies that the endpoint returns "Hello, World!" with a 200 OK status
     */
    @Test
    void testHelloEndpoint() throws Exception {
        mockMvc.perform(get("/hello"))
               .andExpect(status().isOk())
               .andExpect(content().string("Hello, World!"));
    }

    /**
     * Tests accessing a non-existent endpoint
     * Verifies that the endpoint returns a 404 Not Found status
     */
    @Test
    void testNonExistentEndpoint() throws Exception {
        mockMvc.perform(get("/nonexistent"))
               .andExpect(status().isNotFound());
    }

    @Test
    void testHomeEndpointContentType() throws Exception {
        mockMvc.perform(get("/"))
               .andExpect(status().isOk())
               .andExpect(content().contentType("text/plain;charset=UTF-8"));
    }

    @Test
    void testHelloEndpointContentType() throws Exception {
        mockMvc.perform(get("/hello"))
               .andExpect(status().isOk())
               .andExpect(content().contentType("text/plain;charset=UTF-8"));
    }
}
