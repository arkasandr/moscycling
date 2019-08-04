package ru.arkaleks.moscycling;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


import java.io.IOException;
import java.net.URL;
import java.util.*;


@SpringBootApplication(scanBasePackages = {"ru.arkaleks.moscycling"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    CommandLineRunner initDatabase(CyclePathRepository repository) {
        return args -> {
            List<CyclePath> temp = CyclePathConvert.getInstance().getCyclePathDataFromOpenSource();
            for(CyclePath cp : temp) {
                repository.save(cp);
            }

        };
    }
}
