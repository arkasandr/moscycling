package ru.arkaleks.moscycling;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.io.IOException;
import java.net.URL;
import java.util.*;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        try {
        ObjectMapper mapper =new ObjectMapper();
        List<CyclePath> path = mapper.readValue(
                new URL("https://apidata.mos.ru/v1/datasets/897/rows?$top=2&api_key=10d4289dc1d35470807639f4a045528b"),
                new TypeReference<List<CyclePath>>() {});
        for(CyclePath c: path) {
            System.out.println(c.getGlobal_id());
            System.out.println(c.getNumber());
            System.out.println(c.getCells().getCell_id());
            System.out.println(c.getCells().getName());
            System.out.println(c.getCells().getObjectOperOrgPhone());
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
