package ru.arkaleks.moscycling;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static java.lang.Math.*;
import static java.lang.Math.PI;

/**
 * @author Alex Arkashev (arkasandr@gmail.com)
 * @version $Id$
 * @since 0.1
 */

@RestController
public class CyclePathController {

    @Autowired
    private CyclePathRepository repository;

    /**
     * Метод находит все велодорожки CyclePath
     * @param
     * @return CyclePath
     * @throws IOException
     */
    @GetMapping("/cyclepath/allpath")
    public List<CyclePath> getAllCyclePath() {
        return repository.findAll();
    }

    /**
     * Метод находит все id велодорожек CyclePath
     * @param
     * @return List<Integer>
     * @throws IOException
     */
    @GetMapping("/cyclepath/allid")
    public List<Integer> getAllCyclePathId() {
        return   repository.findAll()
                .stream()
                .mapToInt(x -> x.getGlobalId())
                .boxed()
                .collect(Collectors.toList());
    }

    /**
     * Метод находит велодорожку по id
     * @param
     * @return CyclePath
     * @throws IOException
     */
    @GetMapping("/cyclepath/{globalId}")
    Optional findOne(@PathVariable Integer globalId) {
        return repository.findById(globalId);
       //         .orElseThrow(() -> new BookNotFoundException(id));
    }

    /**
     * Метод определяет максимальную длину велодорожки CyclePath
     * @param
     * @return Double
     * @throws IOException
     */
    @GetMapping("/cyclepath/maxlength")
    public OptionalDouble getMaxPath() {
        return repository.findAll()
                .stream()
                .mapToDouble(x -> getCycleLength(x))
                .max();
    }

    /**
     * Метод определяет минимальную длину велодорожки CyclePath
     * @param
     * @return Double
     * @throws IOException
     */
    @GetMapping("/cyclepath/minlength")
    public OptionalDouble getMinPath() {
        return repository.findAll()
                .stream()
                .mapToDouble(x -> getCycleLength(x))
                .min();
    }



    /**
     * Метод сохраняет или обновляет велодорожку CyclePath
     * @param
     * @return Double
     * @throws IOException
     */
    @PutMapping("/cyclepath/{id}")
    CyclePath saveOrUpdate(@RequestBody CyclePath newPath, @PathVariable Integer globalId) {

        return repository.findById(globalId)
                .map(x -> {
                    x.setNumber(newPath.getNumber());
                    x.setCells(newPath.getCells());
                    return repository.save(x);
                })
                .orElseGet(() -> {
                    newPath.setGlobalId(globalId);
                    return repository.save(newPath);
                });
    }

    //  save all
    //return 201 instead of 200
//    @ResponseStatus(HttpStatus.CREATED)
//    @PostMapping("/cyclepath/saveall"
//    @PostMapping(value = "/cyclepath/saveall", produces = MediaType.APPLICATION_JSON_VALUE)
//    CyclePath newPath(CyclePath newPath) {
//        return repository.save(newPath);
//    }

    /**
     * Метод определяет длину велодорожки CyclePath
     * @param
     * @return Double
     * @throws IOException
     */
    public double getCycleLength(CyclePath cyclePath) {
        double result = 0;
        List<Double> sum = new ArrayList<>();
            List<Double> coordinates = new ArrayList<>();
            for (int i = 0; i < cyclePath.getCells().getGeoData().getCoordinates().length; i++) {
                List<Double> temp = new ArrayList<>();
                for (int k = 0; k < cyclePath.getCells().getGeoData().getCoordinates()[i].length; k++) {
                    for (int l = 0; l < cyclePath.getCells().getGeoData().getCoordinates()[i][k].length; l++) {
                        coordinates.add(cyclePath.getCells().getGeoData().getCoordinates()[i][k][l]);
                    }
                    double lensum = 0;
                    Double[] coor = new Double[coordinates.size()];
                    coordinates.toArray(coor);
                    for (int m = 0; m < coor.length - 2; m++) {
                        double length;
                        length = 2 * 6371 * asin(sqrt(pow((sin(((coor[m + 3]) * PI / 180
                                - (coor[m + 1] * PI / 180)) / 2)), 2) + cos((coor[m + 1]) * PI / 180)
                                *  cos((coor[m + 3]) * PI / 180) * (pow((sin(((coor[m + 2]) * PI / 180
                                - (coor[m] * PI / 180)) / 2)), 2))));
                        lensum = lensum + length;
                        m = m + 1;
                    }
                    temp.add(lensum);
                    result = temp.get(temp.size() - 1);
                }
            }
        return result;
    }

}
