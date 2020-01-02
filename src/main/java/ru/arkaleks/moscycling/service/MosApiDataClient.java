package ru.arkaleks.moscycling.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.arkaleks.moscycling.model.*;
import ru.arkaleks.moscycling.service.dto.CyclePathDtoJson;
import ru.arkaleks.moscycling.service.dto.GeoDataDtoJson;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
     * Метод формирует список объектов List<Coordinate> из JSON объекта
     *
     * @param
     * @return List<Coordinate>
     * @throws
     */
    public List<Coordinate> getCoorToList(CyclePathDtoJson cyclePathDtoJson, GeoDataDtoJson geoData) {
        List<Coordinate> result = new ArrayList<>();
        for (double[][] coor2 : geoData.getCoordinates()) {
            for (double[] coor1 : coor2) {
                Coordinate coordinate = new Coordinate();
                coordinate.setCoorX(coor1[0]);
                coordinate.setCoorY(coor1[1]);
                coordinate.setGlobalId(cyclePathDtoJson.getGlobalId());
                result.add(coordinate);
            }
        }
        return result;
    }

    /**
     * Метод формирует список объектов List<DataLength> из JSON объекта
     *
     * @param
     * @return List<DataLength>
     * @throws
     */
    public List<DataLength> getLengthToList(CyclePathDtoJson cyclePathDtoJson, List<Coordinate> coordinates) {
        List<DataLength> result = new ArrayList<>();
        for (int i = 0; i < coordinates.size(); i++) {
            DataLength dataLength = new DataLength();
            dataLength.setPointNumber(i);
            dataLength.setCoors(coordinates);
            dataLength.setGlobalId(cyclePathDtoJson.getGlobalId());
            result.add(dataLength);
        }
        return result;
    }

    /**
     * Метод формирует список объектов List<Type> из JSON объекта
     *
     * @param
     * @return List<Type>
     * @throws
     */
    public List<Type> getTypeToList(CyclePathDtoJson cyclePathDtoJson) {
        List<Type> result = new ArrayList<>();
        String[] types = cyclePathDtoJson.getCells().getType();
        for (int i = 0; i < types.length; i++) {
            Type type = new Type();
            type.setGlobalId(cyclePathDtoJson.getGlobalId());
            type.setType(types[i]);
            result.add(type);
        }
        return result;
    }

    /**
     * Метод осуществляет получение данных по заданному URL путем конвертации JSON в Entity
     *
     * @param
     * @return List<CyclePath>
     * @throws IOException
     */
    public List<CyclePath> getCyclePathDataFromOpenSource() {
        List<CyclePathDtoJson> resultJson;
        List<CyclePath> result = new ArrayList<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            resultJson = mapper.readValue(
                    new URL("https://apidata.mos.ru/v1/datasets/897/rows?api_key=" + apiKey + "&$top=10"),
                    new TypeReference<List<CyclePathDtoJson>>() {
                    });
            for (CyclePathDtoJson cp : resultJson) {
//                System.out.println(cp);
                int id = cp.getGlobalId();
                int number = cp.getNumber();
                List<Coordinate> coordinates = getCoorToList(cp, cp.getCells().getGeoData());
                List<DataLength> length = getLengthToList(cp, coordinates);
                Cell cell = new Cell(id, getTypeToList(cp), new GeoData(id, length));
                List<Cell> cells = new ArrayList<>();
                cells.add(cell);
                String name = cp.getCells().getName();
                String oop = cp.getCells().getObjectOperOrgPhone();
                double width = cp.getCells().getWidth();
                String location = cp.getCells().getLocation();
                String dep = cp.getCells().getDepartamentalAffiliation();
                String operOrgName = cp.getCells().getOperOrgName();
                String portionName = cp.getCells().getPortionName();
                CyclePath cyclePath = new CyclePath(id, number, cells,
                        name, oop, width, location, dep, operOrgName, portionName);
                System.out.println(cyclePath.toString());
                result.add(cyclePath);
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}

