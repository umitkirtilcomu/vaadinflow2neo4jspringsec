package com.umitkirtil.demos.vaadinflow2neo4jspringsec;

import com.umitkirtil.demos.vaadinflow2neo4jspringsec.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;

@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class)
public class Vaadinflow2neo4jspringsecApplication {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(Vaadinflow2neo4jspringsecApplication.class, args);
    }

    @PostConstruct
    public void init() {
    }
}