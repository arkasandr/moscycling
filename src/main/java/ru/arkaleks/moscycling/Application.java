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
            ObjectMapper mapper = new ObjectMapper();
            List<CyclePath> path = mapper.readValue(
                    new URL("https://apidata.mos.ru/v1/datasets/897/rows?$top=2&api_key=10d4289dc1d35470807639f4a045528b"),
                    new TypeReference<List<CyclePath>>() {
                    });
            for (CyclePath c : path) {
                System.out.println(c.getGlobal_id());
                System.out.println(c.getNumber());
                System.out.println(c.getCells().getCell_id());


                System.out.println(c.getCells().getObjectOperOrgPhone());
                for (int i = 0; i < c.getCells().getType().length; i++) {
                    System.out.println(c.getCells().getType()[i]);
                }
                System.out.println(c.getCells().getWidth());
                System.out.println(c.getCells().getLocation());

                for (int i = 0; i < c.getCells().getGeoData().getCoordinates().length; i++) {
                    for (int k = 0; k < c.getCells().getGeoData().getCoordinates()[i].length; k++) {
                        for (int l = 0; l < c.getCells().getGeoData().getCoordinates()[i][k].length; l++) {
                            System.out.println(c.getCells().getGeoData().getCoordinates()[i][k][l]);
                        }
                    }
                }

                System.out.println(c.getCells().getDepartamentalAffiliation());
                System.out.println(c.getCells().getOperOrgName());
                System.out.println(c.getCells().getPortionName());


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public double maxCyclePathWidth(List<CyclePath> list) {
//        double result = 0;
//        for (CyclePath c : list) {
//            for (int i = 0; i < c.getCells().getGeoData().getCoordinates().length; i++) {
//                for (int k = 0; k < c.getCells().getGeoData().getCoordinates()[i].length; k++) {
//                    for (int l = 0; l < c.getCells().getGeoData().getCoordinates()[i][k].length; l++) {
//                        if{(c.getCells().getGeoData().getCoordinates()[i][k][l])%2=0) {
//
//                        }
//                    }
//                }
//            }
//        }
//        return result;
//    }
}
