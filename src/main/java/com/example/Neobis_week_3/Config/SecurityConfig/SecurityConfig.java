package com.example.Neobis_week_3.Config.SecurityConfig;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtAuthenticationFilter jwtAutoFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtAuthenticationFilter filter) throws Exception {
   //     http.csrf(AbstractHttpConfigurer::disable)

        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/auth/**").permitAll()
                        .anyRequest().authenticated()
                )
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        //        .httpBasic(Customizer.withDefaults())
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAutoFilter, UsernamePasswordAuthenticationFilter.class);


//        AntPathRequestMatcher[] requestMatchers = getAntPathRequestMatchers();
//        http.authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers(requestMatchers).permitAll()
//                        .anyRequest().authenticated())
//                .addFilterBefore(filter, JwtAuthenticationFilter.class).csrf(AbstractHttpConfigurer::disable)
//                .httpBasic(withDefaults());

        return http.build();
    }
}
