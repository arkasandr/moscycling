package ru.arkaleks.moscycling.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
@Transactional
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
                coordinate.setId(cyclePathDtoJson.getGlobalId());
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
            dataLength.setId(cyclePathDtoJson.getGlobalId());
            result.add(dataLength);
        }
        return result;
    }

    /**
     * Метод формирует список объектов List<PathType> из JSON объекта
     *
     * @param
     * @return List<PathType>
     * @throws
     */
    public List<PathType> getTypeToList(CyclePathDtoJson cyclePathDtoJson) {
        List<PathType> result = new ArrayList<>();
        String[] types = cyclePathDtoJson.getCells().getType();
        for (int i = 0; i < types.length; i++) {
            PathType pathType = new PathType(cyclePathDtoJson.getGlobalId(), types[i]);
            result.add(pathType);
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
                int id = cp.getGlobalId();
                int number = cp.getNumber();
                List<Coordinate> coordinates = getCoorToList(cp, cp.getCells().getGeoData());
                List<DataLength> dataLengths = new ArrayList<>();
                List<PathType> pathTypes = new ArrayList<>();
                String name = cp.getCells().getName();
                String oop = cp.getCells().getObjectPhone();
                double width = cp.getCells().getWidth();
                String location = cp.getCells().getLocation();
                String dep = cp.getCells().getDepartament();
                String orgName = cp.getCells().getOrgName();
                String portionName = cp.getCells().getPortionName();
                CyclePath cyclePath = new CyclePath(id, number,
                        name, oop, width, location, dep, orgName, portionName);
                Cell cell = new Cell(id, cyclePath);
                for (PathType pathType : getTypeToList(cp)) {
                    pathType.setCell(cell);
                    pathTypes.add(pathType);
                }
                for (DataLength dataLength : getLengthToList(cp, coordinates)) {
                    dataLength.setCell(cell);
                    for (Coordinate coordinate : coordinates) {
                        coordinate.setDatalength(dataLength);
                    }
                    dataLengths.add(dataLength);
                }
                cell.setPathType(pathTypes);
                cell.setLength(dataLengths);

                List<Cell> cells = new ArrayList<>();
                cells.add(cell);
                cyclePath.setCell(cells);
                result.add(cyclePath);
                System.out.println(cyclePath);
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}

