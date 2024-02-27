package com.example.Neobis_week_3;

import com.example.Neobis_week_3.Controller.Auth.AuthenticationRequest;
import com.example.Neobis_week_3.Dto.CreateUserDto;
import com.example.Neobis_week_3.Enums.Role;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void registerCustomer() throws Exception {
        CreateUserDto dto = new CreateUserDto(
                "Ars",
                "Karabaev",
                LocalDate.parse("2003-08-02"),
                "arslan@gmail.com",
                "123456789",
                "pass",
                Role.ADMIN);
        String json = objectMapper.writeValueAsString(dto);
        mockMvc.perform(post("/api/v1/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                )
                .andExpect(status().isOk());
        //.andExpect(content().string(containsString("arslan@gmail.com")));
    }

    @Test
    void login() throws Exception {
        AuthenticationRequest credentials = new AuthenticationRequest("admin@gmail.com", "password");
        String json = objectMapper.writeValueAsString(credentials);
        mockMvc.perform(post("/api/v1/auth/authentication")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                )
                .andExpect(status().isOk()
                );
    }


}
