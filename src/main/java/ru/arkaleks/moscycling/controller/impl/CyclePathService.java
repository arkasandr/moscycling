package ru.arkaleks.moscycling.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.arkaleks.moscycling.controller.CyclePathNotFoundException;
import ru.arkaleks.moscycling.controller.CyclePathUnSupportedFieldPatchException;
import ru.arkaleks.moscycling.controller.dto.*;
import ru.arkaleks.moscycling.controller.mapper.CyclePathMapper;
import ru.arkaleks.moscycling.model.*;
import ru.arkaleks.moscycling.repository.CyclePathRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.lang.Math.*;
import static java.lang.Math.PI;

/**
 * @author Alex Arkashev (arkasandr@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@RequiredArgsConstructor
@Transactional
@Service
public class CyclePathService {

    @Autowired
    private CyclePathRepository cyclePathRepository;
    private CyclePathMapper mapper = CyclePathMapper.INSTANCE;

    /**
     * Метод находит все CyclePath
     *
     * @param
     * @return List<CyclePathDto>
     * @throws
     */
    public List<CyclePathDto> getAllPath() {
        return mapper.mapToCyclePathDtoList(cyclePathRepository.findAll());
    }

    /**
     * Метод находит CyclePath по id
     *
     * @param
     * @return CyclePathDto
     * @throws
     */
    public CyclePathDto getCyclePathById(Integer id) {
        return mapper.mapToCyclePathDto(cyclePathRepository.findById(id).orElseThrow(() -> new CyclePathNotFoundException(id)));
    }

    /**
     * Метод находит PathType
     *
     * @param
     * @return List<PathTypeDto>
     * @throws
     */
    public List<PathTypeDto> getPathTypeById(Integer id) {
        List<PathType> pathTypes = new ArrayList<>();
        List<Cell> cells = cyclePathRepository.findById(id).get().getCell();
        for (Cell cell : cells) {
            List<PathType> temp = cell.getPathType();
            pathTypes.addAll(temp);
        }
        return mapper.mapToPathTypeDtoList(pathTypes);
    }

    /**
     * Метод находит DataLength
     *
     * @param
     * @return List<DataLengthDto>
     * @throws
     */
    public List<DataLengthDto> getDataLengthById(Integer id) {
        List<DataLength> dataLengths = new ArrayList<>();
        List<Cell> cells = cyclePathRepository.findById(id).get().getCell();
        for (Cell cell : cells) {
            List<DataLength> temp = cell.getLength();
            dataLengths.addAll(temp);
        }
        return mapper.mapToDataLengthDtoList(dataLengths);
    }

    /**
     * Метод находит координаты велодорожки CyclePath
     *
     * @param
     * @return List<CoordinateDto>
     * @throws
     */
    public List<CoordinateDto> getCoordinateById(Integer id) {
        List<Coordinate> coordinates = new ArrayList<>();
        List<DataLength> dataLengths = new ArrayList<>();
        List<Cell> cells = cyclePathRepository.findById(id).get().getCell();
        for (Cell cell : cells) {
            List<DataLength> temp = cell.getLength();
            dataLengths.addAll(temp);
        }
        for (DataLength dataLength : dataLengths) {
            List<Coordinate> temp = dataLength.getCoors();
            coordinates.addAll(temp);
        }
        return mapper.mapToCoordinateDtoList(coordinates);
    }

    /**
     * Метод обновляет данные велодорожки CyclePath
     *
     * @param
     * @return CyclePathDto
     * @throws
     */
    public CyclePathDto updateCyclePathById(CyclePath cyclePath, Integer id) {
        return mapper.mapToCyclePathDto(cyclePathRepository.findById(id)
                .map(x -> {
                    x.setNumber(cyclePath.getNumber());
                    x.setCell(cyclePath.getCell());
                    x.setName(cyclePath.getName());
                    x.setObjectPhone(cyclePath.getObjectPhone());
                    x.setWidth(cyclePath.getWidth());
                    x.setLocation(cyclePath.getLocation());
                    x.setDepartament(cyclePath.getDepartament());
                    x.setOrgName(cyclePath.getOrgName());
                    x.setPortionName(cyclePath.getPortionName());
                    return cyclePathRepository.save(x);
                })
                .orElseGet(() -> {
                    cyclePath.setId(id);
                    return cyclePathRepository.save(cyclePath);
                }));
    }

    /**
     * Метод изменяет поле number велодорожки CyclePath
     *
     * @param
     * @return CyclePathDto
     * @throws new CyclePathUnSupportedFieldPatchException
     */
    public CyclePathDto patchCyclePathNumber(Map<String, Integer> update, Integer id) {
        return mapper.mapToCyclePathDto(cyclePathRepository.findById(id)
                .map(x -> {
                    int upNumber = update.get("number");
                    if (upNumber != 0) {
                        x.setNumber(upNumber);
                        return cyclePathRepository.save(x);
                    } else {
                        throw new CyclePathUnSupportedFieldPatchException(update.keySet());
                    }
                })
                .orElseGet(() -> {
                    throw new CyclePathNotFoundException(id);
                }));
    }

    /**
     * Метод удаляет велодорожку CyclePath
     *
     * @param
     * @return
     * @throws
     */
    public void deleteCyclePath(Integer id) {
        CyclePath cyclePath = cyclePathRepository.getOne(id);
        cyclePathRepository.delete(cyclePath);
    }

    /**
     * Метод определяет длину велодорожки CyclePath
     *
     * @param
     * @return Double
     * @throws
     */
    public double getCycleLength(Integer id) {
        double result;
        List<Double> sum = new ArrayList<>();
        List<Double> coors = new ArrayList<>();
        List<Coordinate> coordinates = new ArrayList<>();
        List<DataLength> dataLengths = new ArrayList<>();
        List<Cell> cells = cyclePathRepository.findById(id).get().getCell();
        for (Cell cell : cells) {
            List<DataLength> temp = cell.getLength();
            dataLengths.addAll(temp);
        }
        for (DataLength dataLength : dataLengths) {
            List<Coordinate> temp = dataLength.getCoors();
            coordinates.addAll(temp);
        }
        for (Coordinate coordinate : coordinates) {
            coors.add(coordinate.getCoorX());
            coors.add(coordinate.getCoorY());
        }
        List<Double> temp = new ArrayList<>();
        double lensum = 0;
        Double[] coor = new Double[coors.size()];
        coors.toArray(coor);
        for (int m = 0; m < coor.length - 2; m++) {
            double length;
            length = 2 * 6371 * asin(sqrt(pow((sin(((coor[m + 3]) * PI / 180
                    - (coor[m + 1] * PI / 180)) / 2)), 2) + cos((coor[m + 1]) * PI / 180)
                    * cos((coor[m + 3]) * PI / 180) * (pow((sin(((coor[m + 2]) * PI / 180
                    - (coor[m] * PI / 180)) / 2)), 2))));
            lensum = lensum + length;
            m = m + 1;
        }
        temp.add(lensum);
        result = temp.get(temp.size() - 1);
        return result;
    }
}
