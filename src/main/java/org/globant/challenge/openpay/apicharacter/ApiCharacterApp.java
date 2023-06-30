package org.globant.challenge.openpay.apicharacter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Main class for the Spring-boot application.
 * Enable Feign Clients
 * @author luis.delcampo
 */
@SpringBootApplication
@EnableFeignClients
public class ApiCharacterApp {

    public static void main(String[] args) {
        SpringApplication.run(ApiCharacterApp.class, args);
    }
}
