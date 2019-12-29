package ru.arkaleks.moscycling.controller;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.arkaleks.moscycling.controller.dto.CyclePathDto;
import ru.arkaleks.moscycling.controller.impl.CyclePathService;
import ru.arkaleks.moscycling.model.CyclePath;

import static java.lang.Math.*;
import static java.lang.Math.PI;

/**
 * @author Alex Arkashev (arkasandr@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@RequiredArgsConstructor
@RestController
public class CyclePathController {

    @Autowired
    private CyclePathService cyclePathService;


//    /**
//     * Метод находит все велодорожки CyclePath
//     *
//     * @param
//     * @return List<CyclePath>
//     * @throws
//     */
//    @GetMapping("/cyclepath/allpath")
//    public List<CyclePathDto> getAllCyclePath() {
//        return cyclePathService.getAllPath();
//    }
//
//    /**
//     * Метод находит все id велодорожек CyclePath
//     *
//     * @param
//     * @return List<Integer>
//     * @throws
//     */
//    @GetMapping("/cyclepath/allid")
//    public List<Integer> getAllCyclePathId() {
//        return cyclePathService.getAllPath()
//                .stream()
//                .mapToInt(x -> x.getGlobalId())
//                .boxed()
//                .collect(Collectors.toList());
//    }
//
//    /**
//     * Метод находит велодорожку по id
//     *
//     * @param
//     * @return CyclePath
//     * @throws CyclePathNotFoundException
//     */
//    @GetMapping("/cyclepath/{globalId}")
//    CyclePathDto findOne(@PathVariable int globalId) {
//        return cyclePathService.getCyclePathById(globalId);
//    }
//
//    /**
//     * Метод определяет максимальную длину велодорожки CyclePath
//     *
//     * @param
//     * @return Double
//     * @throws
//     */
//    @GetMapping("/cyclepath/maxlength")
//    public OptionalDouble getMaxPath() {
//        return cyclePathService.getAllPath()
//                .stream()
//                .mapToDouble(x -> getCycleLength(x))
//                .max();
//    }
//
//    /**
//     * Метод определяет минимальную длину велодорожки CyclePath
//     *
//     * @param
//     * @return Double
//     * @throws IOException
//     */
//    @GetMapping("/cyclepath/minlength")
//    public OptionalDouble getMinPath() {
//        return cyclePathService.getAllPath()
//                .stream()
//                .mapToDouble(x -> getCycleLength(x))
//                .min();
//    }
//
//
//    /**
//     * Метод сохраняет или обновляет велодорожку CyclePath
//     *
//     * @param
//     * @return CyclePath
//     * @throws
//     */
//    @PutMapping("/cyclepath/{globalId}")
//    CyclePathDto saveOrUpdate(@RequestBody CyclePath newPath, @PathVariable Integer globalId) {
//        return cyclePathService.updateCyclePathById(newPath, globalId);
//    }
//
//    /**
//     * Метод обновляет только поле "Number" велодорожки CyclePath
//     *
//     * @param
//     * @return CyclePath
//     * @throws
//     */
//    @PatchMapping("/cyclepath/{globalId}")
//    CyclePathDto patch(@RequestBody Map<String, Integer> update, @PathVariable Integer globalId) {
//        return cyclePathService.patchCyclePathNumber(update, globalId);
//    }
//
//    /**
//     * Метод удаляет велодорожку CyclePath
//     *
//     * @param
//     * @return Double
//     * @throws
//     */
//
//    @DeleteMapping("cyclepath/{globalId}")
//    void deletePath(@PathVariable int globalId) {
//        cyclePathService.deleteCyclePath(globalId);
//    }
//
//
//    /**
//     * Метод определяет длину велодорожки CyclePath
//     *
//     * @param
//     * @return Double
//     * @throws
//     */
//    public double getCycleLength(CyclePathDto cyclePath) {
//        double result = 0;
//        List<Double> sum = new ArrayList<>();
//        List<Double> coordinates = new ArrayList<>();
//        for (int i = 0; i < cyclePath.getCells().getGeoData().getCoordinates().length; i++) {
//            List<Double> temp = new ArrayList<>();
//            for (int k = 0; k < cyclePath.getCells().getGeoData().getCoordinates()[i].length; k++) {
//                for (int l = 0; l < cyclePath.getCells().getGeoData().getCoordinates()[i][k].length; l++) {
//                    coordinates.add(cyclePath.getCells().getGeoData().getCoordinates()[i][k][l]);
//                }
//                double lensum = 0;
//                Double[] coor = new Double[coordinates.size()];
//                coordinates.toArray(coor);
//                for (int m = 0; m < coor.length - 2; m++) {
//                    double length;
//                    length = 2 * 6371 * asin(sqrt(pow((sin(((coor[m + 3]) * PI / 180
//                            - (coor[m + 1] * PI / 180)) / 2)), 2) + cos((coor[m + 1]) * PI / 180)
//                            * cos((coor[m + 3]) * PI / 180) * (pow((sin(((coor[m + 2]) * PI / 180
//                            - (coor[m] * PI / 180)) / 2)), 2))));
//                    lensum = lensum + length;
//                    m = m + 1;
//                }
//                temp.add(lensum);
//                result = temp.get(temp.size() - 1);
//            }
//        }
//        return result;
//    }

}
