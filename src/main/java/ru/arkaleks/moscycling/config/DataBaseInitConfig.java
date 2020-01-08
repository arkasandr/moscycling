package ru.arkaleks.moscycling.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.arkaleks.moscycling.model.CyclePath;
import ru.arkaleks.moscycling.service.MosApiDataClient;
import ru.arkaleks.moscycling.repository.CyclePathRepository;

import java.util.List;

/**
 * @author Alex Arkashev (arkasandr@gmail.com)
 * @version $Id$
 * @since 0.1
 */

@Configuration
public class DataBaseInitConfig {

    @Bean
    CommandLineRunner initDatabase(CyclePathRepository repository, MosApiDataClient client) {
        return args -> {
            List<CyclePath> temp = client.getCyclePathDataFromOpenSource();
            for (CyclePath cp : temp) {
                repository.save(cp);
            }
        };
    }
}
