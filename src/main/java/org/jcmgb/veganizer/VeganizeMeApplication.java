package org.jcmgb.veganizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("org.jcmgb.veganizer.repo")
public class VeganizeMeApplication {
    public static void main(String[] args) {
        SpringApplication.run(VeganizeMeApplication.class, args);
    }
}