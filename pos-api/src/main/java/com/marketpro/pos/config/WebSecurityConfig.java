package com.marketpro.pos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    @Bean
    public UserDetailsService users(PasswordEncoder encoder) {
        UserDetails admin = User.builder()
                .username("admin")
                .password(encoder.encode("admin123"))
                .roles("ADMIN")
                .build();

        UserDetails cashier = User.builder()
                .username("caja")
                .password(encoder.encode("caja123"))
                .roles("CASHIER")
                .build();

        UserDetails stocker = User.builder()
                .username("bodega")
                .password(encoder.encode("bodega123"))
                .roles("STOCKER")
                .build();

        return new InMemoryUserDetailsManager(admin, cashier, stocker);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/swagger-ui/**",
                    "/swagger-ui.html",
                    "/v3/api-docs/**",
                    "/api/status"
                ).permitAll()
                .requestMatchers("/api/productos/**").hasAnyRole("ADMIN","STOCKER")
                .requestMatchers("/api/ventas/**").hasAnyRole("ADMIN","CASHIER")
                .requestMatchers("/api/pagos/**").hasAnyRole("ADMIN","CASHIER")
                .requestMatchers("/api/carrito/**").hasAnyRole("ADMIN","CASHIER")
                .anyRequest().authenticated()
            )
            .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}