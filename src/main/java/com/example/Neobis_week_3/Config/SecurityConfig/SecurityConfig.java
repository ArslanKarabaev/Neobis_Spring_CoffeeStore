package com.example.Neobis_week_3.Config.SecurityConfig;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static com.example.Neobis_week_3.Enums.Permission.*;
import static com.example.Neobis_week_3.Enums.Role.ADMIN;
import static com.example.Neobis_week_3.Enums.Role.MANAGER;
import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtAuthenticationFilter jwtAutoFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth

                        .requestMatchers("/api/v1/auth/**").permitAll()
                        .requestMatchers("api/v1/CoffeeStore/management/**").hasAnyRole(ADMIN.name(), MANAGER.name())
                        .requestMatchers("api/v1/CoffeeStore/management/**").hasAnyAuthority(ADMIN.name(), MANAGER.name())

//                        .requestMatchers(GET, "api/v1/CoffeeStore/management/**").hasAnyAuthority(ADMIN_READ.name(), MANAGER_READ.name())
//                        .requestMatchers(POST, "api/v1/CoffeeStore/management/**").hasAnyAuthority(ADMIN_CREATE.name(), MANAGER_CREATE.name())
//                        .requestMatchers(PUT, "api/v1/CoffeeStore/management/**").hasAnyAuthority(ADMIN_UPDATE.name(), MANAGER_UPDATE.name())
//                        .requestMatchers(DELETE, "api/v1/CoffeeStore/management/**").hasAnyAuthority(ADMIN_DELETE.name(), MANAGER_DELETE.name())

                        .requestMatchers("api/v1/CoffeeStore/admin/**").hasAnyRole(ADMIN.name())
                        .requestMatchers("api/v1/CoffeeStore/admin/**").hasAuthority(ADMIN.name())

//                        .requestMatchers(GET, "api/v1/CoffeeStore/admin/**").hasAnyAuthority(ADMIN_READ.name())
//                        .requestMatchers(POST, "api/v1/CoffeeStore/admin/**").hasAnyAuthority(ADMIN_CREATE.name())
//                        .requestMatchers(PUT, "api/v1/CoffeeStore/admin/**").hasAnyAuthority(ADMIN_UPDATE.name())
//                        .requestMatchers(DELETE, "api/v1/CoffeeStore/admin/**").hasAnyAuthority(ADMIN_DELETE.name())


                        .anyRequest().authenticated()

                )//.httpBasic(Customizer.withDefaults())
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAutoFilter, UsernamePasswordAuthenticationFilter.class);


        return http.build();
    }
}
