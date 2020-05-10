package ru.arkaleks.moscycling.controller;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ru.arkaleks.moscycling.controller.dto.*;
import ru.arkaleks.moscycling.controller.impl.CyclePathService;
import ru.arkaleks.moscycling.model.CyclePath;

/**
 * @author Alex Arkashev (arkasandr@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@RequiredArgsConstructor
@RestController
@Transactional
public class CyclePathController {

    private final CyclePathService cyclePathService;


    /**
     * Метод находит все велодорожки CyclePath
     *
     * @param
     * @return List<CyclePath>
     * @throws
     */
    @GetMapping("/cyclepath/allpath")
    public List<CyclePathDto> getAllCyclePath() {
        return cyclePathService.getAllPath();
    }


    /**
     * Метод находит все id велодорожек CyclePath
     *
     * @param
     * @return List<Integer>
     * @throws
     */
    @GetMapping("/cyclepath/allid")
    public List<Integer> getAllCyclePathId() {
        return cyclePathService.getAllPath()
                .stream()
                .mapToInt(x -> x.getId())
                .boxed()
                .collect(Collectors.toList());
    }

    /**
     * Метод находит велодорожку по id
     *
     * @param
     * @return CyclePath
     * @throws CyclePathNotFoundException
     */
    @GetMapping("/cyclepath/{globalId}")
    CyclePathDto findOne(@PathVariable int globalId) {
        return cyclePathService.getCyclePathById(globalId);
    }

    /**
     * Метод находит PathType велодорожки по id
     *
     * @param
     * @return List<PathType>
     * @throws
     */
    @GetMapping("/cyclepath/{globalId}/pathtype")
    List<PathTypeDto> findPathType(@PathVariable int globalId) {
        return cyclePathService.getPathTypeById(globalId);
    }

    /**
     * Метод находит Datalength велодорожки по id
     *
     * @param
     * @return List<DatalengthDto>
     * @throws
     */
    @GetMapping("/cyclepath/{globalId}/datalength")
    List<DataLengthDto> findOneLength(@PathVariable int globalId) {
        return cyclePathService.getDataLengthById(globalId);
    }

    /**
     * Метод находит Coordinate велодорожки по id
     *
     * @param
     * @return List<CoordinateDto>
     * @throws
     */
    @GetMapping("/cyclepath/{globalId}/coordinates")
    List<CoordinateDto> findOneCoordinates(@PathVariable int globalId) {
        return cyclePathService.getCoordinateById(globalId);
    }

    /**
     * Метод определяет максимальную длину велодорожки CyclePath
     *
     * @param
     * @return Double
     * @throws
     */
    @GetMapping("/cyclepath/maxlength")
    public OptionalDouble getMaxPath() {
        return cyclePathService.getAllPath()
                .stream()
                .mapToInt(x -> x.getId())
                .boxed()
                .collect(Collectors.toList())
                .stream()
                .mapToDouble(x -> getCyclePathLength(x))
                .max();
    }

    /**
     * Метод определяет минимальную длину велодорожки CyclePath
     *
     * @param
     * @return Double
     * @throws IOException
     */
    @GetMapping("/cyclepath/minlength")
    public OptionalDouble getMinPath() {
        return cyclePathService.getAllPath()
                .stream()
                .mapToInt(x -> x.getId())
                .boxed()
                .collect(Collectors.toList())
                .stream()
                .mapToDouble(x -> getCyclePathLength(x))
                .min();
    }


    /**
     * Метод сохраняет или обновляет велодорожку CyclePath
     *
     * @param
     * @return CyclePath
     * @throws
     */
    @PutMapping("/cyclepath/{globalId}")
    CyclePathDto saveOrUpdate(@RequestBody CyclePath newPath, @PathVariable Integer globalId) {
        return cyclePathService.updateCyclePathById(newPath, globalId);
    }

    /**
     * Метод обновляет только поле "Number" велодорожки CyclePath
     *
     * @param
     * @return CyclePath
     * @throws
     */
    @PatchMapping("/cyclepath/{globalId}")
    CyclePathDto patch(@RequestBody Map<String, Integer> update, @PathVariable Integer globalId) {
        return cyclePathService.patchCyclePathNumber(update, globalId);
    }

    /**
     * Метод удаляет велодорожку CyclePath
     *
     * @param
     * @return
     * @throws
     */
    @DeleteMapping("cyclepath/{globalId}")
    void deletePath(@PathVariable int globalId) {
        cyclePathService.deleteCyclePath(globalId);
    }

    /**
     * Метод определяет длину велодорожки CyclePath
     *
     * @param
     * @return Double
     * @throws
     */
    @GetMapping("/cyclepath/{globalId}/length")
    public Double getCyclePathLength(@PathVariable int globalId) {
        return cyclePathService.getCycleLength(globalId);
    }
}
