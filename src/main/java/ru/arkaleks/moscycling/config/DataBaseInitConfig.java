package ru.arkaleks.moscycling.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.arkaleks.moscycling.model.CyclePath;
import ru.arkaleks.moscycling.service.CyclePathConvert;
import ru.arkaleks.moscycling.repository.CyclePathRepository;

import java.util.List;

@Configuration
public class DataBaseInitConfig {
    @Bean
    CommandLineRunner initDatabase(CyclePathRepository repository) {
        return args -> {
            List<CyclePath> temp = CyclePathConvert.getInstance().getCyclePathDataFromOpenSource();
            for (CyclePath cp : temp) {
                repository.save(cp);
            }

        };
    }
}
