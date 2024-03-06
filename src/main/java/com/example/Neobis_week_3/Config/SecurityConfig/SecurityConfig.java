package com.example.Neobis_week_3.Config.SecurityConfig;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static com.example.Neobis_week_3.Enums.Role.ADMIN;
import static com.example.Neobis_week_3.Enums.Role.MANAGER;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtAuthenticationFilter jwtAutoFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth

                        .requestMatchers(
                                "/api/v1/auth/**",
                                "/v3/api-docs",
                                "/v3/api-docs/**",
                                "/swagger-recourses",
                                "/swagger-recourses/**",
                                "/configuration/ui",
                                "/configuration/security",
                                "/swagger-ui/**",
                                "/swagger-ui.html",
                                "/webjars/**"
                                ).permitAll()

                        .requestMatchers("api/v1/CoffeeStore/management/**").hasAnyRole(ADMIN.name(), MANAGER.name())
                        .requestMatchers("api/v1/CoffeeStore/management/**").hasAnyAuthority(ADMIN.name(), MANAGER.name())

                        .requestMatchers("api/v1/CoffeeStore/admin/**").hasAnyRole(ADMIN.name())
                        .requestMatchers("api/v1/CoffeeStore/admin/**").hasAuthority(ADMIN.name())


                        .anyRequest().authenticated()

                )
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAutoFilter, UsernamePasswordAuthenticationFilter.class);


        return http.build();
    }
}
