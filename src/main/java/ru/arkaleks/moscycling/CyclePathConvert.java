package ru.arkaleks.moscycling;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CyclePathConvert {

    private static CyclePathConvert stpc = null;

    public static CyclePathConvert getInstance() {
        if (stpc == null) {
            stpc = new CyclePathConvert();
            return stpc;
        } else {
            return stpc;
        }
    }

    public List<CyclePath> cyclePathConvert() {
        List<CyclePath> result = new ArrayList<>();

        try {
            ObjectMapper mapper = new ObjectMapper();
            result = mapper.readValue(
                    new URL("https://apidata.mos.ru/v1/datasets/897/rows?$top=2&api_key=10d4289dc1d35470807639f4a045528b"),
                    new TypeReference<List<CyclePath>>() {
                    });
//                System.out.println(c.getNumber());
//                System.out.println(c.getCells().getCell_id());
//
//
//                System.out.println(c.getCells().getObjectOperOrgPhone());
//                for (int i = 0; i < c.getCells().getType().length; i++) {
//                    System.out.println(c.getCells().getType()[i]);
//                }
//                System.out.println(c.getCells().getWidth());
//                System.out.println(c.getCells().getLocation());
//
//                for (int i = 0; i < c.getCells().getGeoData().getCoordinates().length; i++) {
//                    for (int k = 0; k < c.getCells().getGeoData().getCoordinates()[i].length; k++) {
//                        for (int l = 0; l < c.getCells().getGeoData().getCoordinates()[i][k].length; l++) {
//                            System.out.println(c.getCells().getGeoData().getCoordinates()[i][k][l]);
//                        }
//                    }
//                }
//
//                System.out.println(c.getCells().getDepartamentalAffiliation());
//                System.out.println(c.getCells().getOperOrgName());
//                System.out.println(c.getCells().getPortionName());

 //           }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public double maxCyclePathWidth(List<CyclePath> list) {
        double result = 0;
        List<Double> coordinates = new ArrayList<>();
        for (CyclePath c : list) {
            for (int i = 0; i < c.getCells().getGeoData().getCoordinates().length; i++) {
                for (int k = 0; k < c.getCells().getGeoData().getCoordinates()[i].length; k++) {
                    for (int l = 0; l < c.getCells().getGeoData().getCoordinates()[i][k].length; l++) {
                    coordinates.add(c.getCells().getGeoData().getCoordinates()[i][k][l]);
                    }
                }
            }
        }
        Double[] coor = new Double [coordinates.size()];
        coordinates.toArray(coor);
        for (int i = 0; i < coor.length; i++) {
            double length;
            length = Math.sqrt((Math.pow((coor[i+2] - coor[i], 2)) + ))
        }
        return result;
        }
    }

