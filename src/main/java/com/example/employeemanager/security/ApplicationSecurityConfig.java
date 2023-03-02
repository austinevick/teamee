package com.example.employeemanager.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static com.example.employeemanager.security.EmployeeRole.*;

@Configuration
public class ApplicationSecurityConfig {
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.
                authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/api/**").hasRole(STUDENT.name())

                        .anyRequest()

                        .authenticated())
                .httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }

    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails user = User.builder().username("Vicky")
                .password(passwordEncoder.encode("123456"))
                .roles(ADMIN.name()).build();
        UserDetails user1 = User.builder().username("Mike")
                .password(passwordEncoder.encode("123456"))
                .roles(STUDENT.name()).build();
        UserDetails user2 = User.builder().username("John")
                .password(passwordEncoder.encode("123456"))
                .roles(ADMINTRAINEE.name()).build();
        return new InMemoryUserDetailsManager(user, user1);
    }
}
