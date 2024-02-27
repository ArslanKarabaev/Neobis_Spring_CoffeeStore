package com.example.Neobis_week_3;

import com.example.Neobis_week_3.Controller.Auth.AuthenticationRequest;
import com.example.Neobis_week_3.Controller.Auth.AuthenticationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CoffeeControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    AuthenticationService authenticationService;
    private static String adminToken;
    @BeforeEach
    void setUp() {
        AuthenticationRequest adminCredentials = new AuthenticationRequest("admin@gmail.com", "password");
        adminToken ="Bearer " + authenticationService.authenticate(adminCredentials).getToken();
    }

    @Test
    void getAllCoffee() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/v1/CoffeeStore/Coffee/getAllCoffee")
                .header("Authorization", adminToken))
                .andExpectAll(
                status().isOk()
                //content().string(containsString("")),
                //content().string(containsString(""))
        );
    }

    @Test
    void getCoffeeById() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/v1/CoffeeStore/Coffee/2")
                        .header("Authorization", adminToken))
                .andExpectAll(
                status().isOk()
                //content().string(containsString(""))
        );
    }
}
