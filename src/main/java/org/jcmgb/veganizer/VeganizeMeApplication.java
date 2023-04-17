package org.jcmgb.veganizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableJpaRepositories("org.jcmgb.veganizer.repo")
public class VeganizeMeApplication {
    public static void main(String[] args) {
        SpringApplication.run(VeganizeMeApplication.class, args);
    }
}