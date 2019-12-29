package ru.arkaleks.moscycling.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.arkaleks.moscycling.model.*;
import ru.arkaleks.moscycling.service.dto.CellsDtoJson;
import ru.arkaleks.moscycling.service.dto.CyclePathDtoJson;
import ru.arkaleks.moscycling.service.dto.GeoDataDtoJson;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Alex Arkashev (arkasandr@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@Service
public class MosApiDataClient {

    @Value("${api.key}")
    private String apiKey;

    public MosApiDataClient(@Value("${api.key}") String apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * Метод осуществляет получение данных по заданному URL путем конвертации JSON в экземпляры класса MosApiDataClient
     *
     * @param
     * @return List<CyclePathConvert>
     * @throws IOException
     */
    public List<CyclePath> getCyclePathDataFromOpenSource() {
       List<CyclePathDtoJson> resultJson = new ArrayList<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            resultJson = mapper.readValue(
                    new URL("https://apidata.mos.ru/v1/datasets/897/rows?api_key=" + apiKey + "&$top=136"),
                    new TypeReference<List<CyclePathDtoJson>>() {
                    });
//
//        List<CyclePath> result = resultJson.stream()
//                .mapToInt(cp -> cp.getGlobalId())
//                .mapToInt(cp -> cp.getNumber())


            for(CyclePathDtoJson cp : resultJson) {
                int id = cp.getGlobalId();
                int number = cp.getNumber();
                List<Coordinate> coordinates = new ArrayList<>();
                coordinates.addAll(Arrays.asList(cp.getCells().getGeoData().getCoordinates()));
                for(cp.getCells().getGeoData().getCoordinates())
                coordinates
                new Cell(cp.getCells().getGlobalId(), List<Type> type = new ArrayList<>(cp.getCells().getType(), cp.getCells().getGeoData());
                String name = cp.getCells().getName();
                String oop = cp.getCells().getObjectOperOrgPhone();
                Double width = cp.getCells().getWidth();
                String location = cp.getCells().getLocation();
                String dep = cp.getCells().getDepartamentalAffiliation();
                String operOrgName = cp.getCells().getOperOrgName();
                String portionName = cp.getCells().getPortionName();
                CyclePath cyclePath = new CyclePath(id, number, cells,)
            }

        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Coordinate> getCoortoList(GeoDataDtoJson geoData) {
        List<Coordinate> result = new ArrayList<>();
        List<double> result1 = new ArrayList<>();
        for (double[][] coor2 : geoData.getCoordinates()){
            for (double[] coor1 : coor2) {
                Coordinate coordinate = new Coordinate();
                coordinate
                    result1.addAll(Arrays.asList(coor1));
            }
        }

        return result;
    }
}

