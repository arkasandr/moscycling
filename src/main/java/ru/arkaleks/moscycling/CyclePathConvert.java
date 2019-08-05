package ru.arkaleks.moscycling;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.*;
/**
 * @author Alex Arkashev (arkasandr@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class CyclePathConvert {


    private static CyclePathConvert stpc = null;
  //  private String openSourceURL = "https://apidata.mos.ru/v1/datasets/897/rows?api_key=10d4289dc1d35470807639f4a045528b&$skip=12&$top=1";
    private String openSourceURL = "https://apidata.mos.ru/v1/datasets/897/rows?api_key=10d4289dc1d35470807639f4a045528b&$top=136";


    /**
     * Метод позволяет получить объект классаж
     * @param
     * @return CyclePathConvert
     * @throws
     */
    public static CyclePathConvert getInstance() {
        if (stpc == null) {
            stpc = new CyclePathConvert();
            return stpc;
        } else {
            return stpc;
        }
    }

    /**
     * Метод осуществляет получение данных по заданному URL путем конвертации JSON в экземпляры класса CyclePathConvert
     * @param
     * @return List<CyclePathConvert>
     * @throws IOException
     */
    public List<CyclePath> getCyclePathDataFromOpenSource() {
        List<CyclePath> result = new ArrayList<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            result = mapper.readValue(
                    new URL(openSourceURL),
                    new TypeReference<List<CyclePath>>() {
                    });
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return result;
    }

//    /**
//     * Метод определяет максимальную длину CyclePath
//     * @param
//     * @return Double
//     * @throws IOException
//     */
//    public double maxCyclePathLength(List<CyclePath> list) {
//        double result;
//        List<Double> sum = new ArrayList<>();
//        for (CyclePath c : list) {
//            List<Double> coordinates = new ArrayList<>();
//            double cyclePathSum = 0;
//            for (int i = 0; i < c.getCells().getGeoData().getCoordinates().length; i++) {
//                List<Double> temp = new ArrayList<>();
//                for (int k = 0; k < c.getCells().getGeoData().getCoordinates()[i].length; k++) {
//                    for (int l = 0; l < c.getCells().getGeoData().getCoordinates()[i][k].length; l++) {
//                        coordinates.add(c.getCells().getGeoData().getCoordinates()[i][k][l]);
//                    }
//                    double lensum = 0;
//                    Double[] coor = new Double[coordinates.size()];
//                    coordinates.toArray(coor);
//                    for (int m = 0; m < coor.length - 2; m++) {
//                        double length;
//                        length = 2 * 6371 * asin(Math.sqrt(Math.pow((sin(((coor[m + 3]) * PI / 180
//                                - (coor[m + 1] * PI / 180)) / 2)), 2) + cos((coor[m + 1]) * PI / 180)
//                                *  cos((coor[m + 3]) * PI / 180) * (Math.pow((sin(((coor[m + 2]) * PI / 180
//                                - (coor[m] * PI / 180)) / 2)), 2))));
//                        lensum = lensum + length;
//                        m = m + 1;
//                    }
//                    temp.add(lensum);
//                    cyclePathSum = temp.get(temp.size() - 1);
//                }
//            }
//            sum.add(cyclePathSum);
//        }
//        result = Collections.max(sum);
//        return result;
//    }
}

