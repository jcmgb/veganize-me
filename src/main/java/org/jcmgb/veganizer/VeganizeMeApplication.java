package org.jcmgb.veganizer;

import org.jcmgb.veganizer.controller.VeganizerController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("org.jcmgb.veganizer.entity")
@EnableJpaRepositories("org.jcmgb.veganizer.repository")
public class VeganizeMeApplication {
    public static void main(String[] args) {
        SpringApplication.run(VeganizeMeApplication.class, args);
    }
}