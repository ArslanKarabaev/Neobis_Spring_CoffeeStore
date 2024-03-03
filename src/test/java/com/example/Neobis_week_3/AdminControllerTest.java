package com.example.Neobis_week_3;

import com.example.Neobis_week_3.Controller.Auth.AuthenticationRequest;
import com.example.Neobis_week_3.Controller.Auth.AuthenticationService;
import com.example.Neobis_week_3.Dto.CoffeeDto;
import com.example.Neobis_week_3.Dto.UsersDto;
import com.example.Neobis_week_3.Enums.Role;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static com.example.Neobis_week_3.Enums.Role.ADMIN;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AdminControllerTest {
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
        adminToken = "Bearer " + authenticationService.authenticate(adminCredentials).getToken();
    }


    @Test
    void getAllUsers() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/v1/CoffeeStore/admin/getAllUsers")
                        .header("Authorization", adminToken))
                .andExpectAll(
                        status().isOk()
                        //content().string(containsString("")),
                        //content().string(containsString(""))
                );
    }

    @Test
    void getUserById() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/v1/CoffeeStore/admin/getUserById/1")
                        .header("Authorization", adminToken))
                .andExpectAll(
                        status().isOk()
                        //content().string(containsString(""))
                );
    }

    @Test
    void updateUser() throws Exception {
        UsersDto dto = new UsersDto(
                "Rus",
                "Kasymov",
                LocalDate.parse("2003-03-21"),
                "rus@gmail.com",
                "987654321",
                "pass",
                Role.USER
        );
        String json = objectMapper.writeValueAsString(dto);

        mockMvc.perform(put("http://localhost:8080/api/v1/CoffeeStore/admin/updateUser/1")
                        .header("Authorization", adminToken)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpectAll(
                        status().isOk()
                );
    }

    @Test
    void addNewCoffee() throws Exception {
        CoffeeDto dto = new CoffeeDto(
                "Mocha",
                250,
                300
        );
        String json = objectMapper.writeValueAsString(dto);

        mockMvc.perform(post("http://localhost:8080/api/v1/CoffeeStore/admin/addNewCoffee")
                        .header("Authorization", adminToken)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpectAll(
                        status().isOk()
                        // content().string(containsString(""))
                );
    }
}