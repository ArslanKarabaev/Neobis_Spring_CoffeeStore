package com.example.Neobis_week_3.Config;

import com.example.Neobis_week_3.Entity.Coffee;
import com.example.Neobis_week_3.Repository.CoffeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CoffeeConfig {
    @Bean
    CommandLineRunner CoffeecommandLineRunner(CoffeeRepository repository) {
        return args -> {
            Coffee Latte = new Coffee(
                    "Latte",
                    250,
                    220);
            Coffee Cappuccino = new Coffee(
                    "Cappuccino",
                    180,
                    200);
            repository.saveAll(List.of(Latte, Cappuccino));
        };
    }
}
