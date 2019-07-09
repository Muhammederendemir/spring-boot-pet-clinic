package com.springbootpetclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
@EnableConfigurationProperties(value = PetClinicProperties.class)
public class SpringBootPetClinicApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootPetClinicApplication.class, args);
    }

}
