package com.example.Neobis_week_3.Config;

import com.example.Neobis_week_3.Entity.Role;
import com.example.Neobis_week_3.Entity.Users;
import com.example.Neobis_week_3.Repository.UsersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class UsersConfig {
    @Bean
    CommandLineRunner UserscommandLineRunner(UsersRepository repository) {
        return args -> {
            Users Arslan = new Users(
                    "Arslan",
                    "Karabaev",
                    LocalDate.of(2003, 8, 2),
                    "karabaevarslan8@gmail.com",
                    "0552020803",
                    "123",
                    Role.ADMIN
            );

            Users Aktilek = new Users(
                    "Aktilek",
                    "Kamilov",
                    LocalDate.of(2003, 9, 13),
                    "kamilovaktilek@gmail.com",
                    "0123456789",
                    "456",
                    Role.USER);
            repository.saveAll(List.of(Arslan, Aktilek));
        };
    }
}
