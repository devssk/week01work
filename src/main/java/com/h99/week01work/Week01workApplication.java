package com.h99.week01work;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Week01workApplication {

    public static void main(String[] args) {
        SpringApplication.run(Week01workApplication.class, args);
    }

}
