package com.codegym.rentapartmentbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class RentapartmentbeApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentapartmentbeApplication.class, args);
    }

}
