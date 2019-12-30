package ru.arkaleks.moscycling.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.arkaleks.moscycling.model.CyclePath;
import ru.arkaleks.moscycling.service.MosApiDataClient;
import ru.arkaleks.moscycling.repository.CyclePathRepository;
import ru.arkaleks.moscycling.service.dto.CyclePathDtoJson;
import ru.arkaleks.moscycling.service.impl.CyclePathServiceJson;

import java.util.List;

@Configuration
public class DataBaseInitConfig {
//    @Bean
//    CommandLineRunner initDatabase(CyclePathRepository repository, MosApiDataClient client, CyclePathServiceJson cyclePathServiceJson) {
//        return args -> {
//            List<CyclePathDtoJson> temp = client.getCyclePathDataFromOpenSource();
//            for (CyclePathDtoJson cp : temp) {
//                repository.save(cyclePathServiceJson.saveCyclePathDtoToCyclePath(cp));
//            }
//        };
//    }

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
