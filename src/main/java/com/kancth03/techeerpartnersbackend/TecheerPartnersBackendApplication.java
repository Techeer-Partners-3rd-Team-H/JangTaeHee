package com.kancth03.techeerpartnersbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TecheerPartnersBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(TecheerPartnersBackendApplication.class, args);
    }

}
