package com.devmountain.noteApp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Config {
    @Bean //Spring keeps track of a new Bean called “passwordEncoder”
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}