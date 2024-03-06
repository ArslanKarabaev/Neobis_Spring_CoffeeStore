package com.example.Neobis_week_3.Config;

import com.example.Neobis_week_3.Controller.Auth.AuthenticationService;
import com.example.Neobis_week_3.Controller.Auth.RegisterRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

import static com.example.Neobis_week_3.Enums.Role.ADMIN;
import static com.example.Neobis_week_3.Enums.Role.MANAGER;

@Configuration
public class UsersConfig {

    public static void main(String[] args) {
        SpringApplication.run(UsersConfig.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(
            AuthenticationService service
    ) {
        return args -> {
            var admin = RegisterRequest.builder()
                    .firstName("Admin")
                    .secondName("Admin")
                    .email("admin@gmail.com")
                    .password("password")
                    .dateOfBirth(LocalDate.of(2000,8,2))
                    .role(ADMIN)
                    .build();
            System.out.println("Admin token: " + service.register(admin).getToken());

            var manager = RegisterRequest.builder()
                    .firstName("Admin")
                    .secondName("Admin")
                    .email("manager@gmail.com")
                    .password("pass")
                    .dateOfBirth(LocalDate.of(2000,8,2))
                    .role(MANAGER)
                    .build();
            System.out.println("Manager token: " + service.register(manager).getToken());

        };
    }
}
