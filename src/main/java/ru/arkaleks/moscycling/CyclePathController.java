package ru.arkaleks.moscycling;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
/**
 * @author Alex Arkashev (arkasandr@gmail.com)
 * @version $Id$
 * @since 0.1
 */

@RestController
public class CyclePathController {

    @Autowired
    private CyclePathRepository repository;

    @RequestMapping(method = RequestMethod.GET, value = "/cyclepath/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CyclePath> getAllCyclePath() {
        //return CyclePathConvert.getInstance().getCyclePathDataFromOpenSource();
        return repository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cyclepath/id", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Integer> getAllCyclePathId() {
        List<Integer> result = new ArrayList<>();
        List<CyclePath> temp = CyclePathConvert.getInstance().getCyclePathDataFromOpenSource();
        for (CyclePath cp : temp) {
            result.add(cp.getGlobalId());
        }
        return result;
    }

//    @RequestMapping(method = RequestMethod.GET, value = "/cyclepath/maxlength", produces = MediaType.APPLICATION_JSON_VALUE)
//    public double getMaxCyclePathLength() {
//        double result;
//        List<CyclePath> temp = CyclePathConvert.getInstance().getCyclePathDataFromOpenSource();
//        result = CyclePathConvert.getInstance().maxCyclePathLength(temp);
//        return result;
//    }


//    // Save or update
//    @PutMapping("/cyclepath/{id}")
//    CyclePath saveOrUpdate(@RequestBody CyclePath newPath, @PathVariable Integer globalId) {
//
//        return repository.findById(id)
//                .map(x -> {
//                    x.setName(newBook.getName());
//                    x.setAuthor(newBook.getAuthor());
//                    x.setPrice(newBook.getPrice());
//                    return repository.save(x);
//                })
//                .orElseGet(() -> {
//                    newBook.setId(id);
//                    return repository.save(newBook);
//                });
//    }

    //  save all
    //return 201 instead of 200
//    @ResponseStatus(HttpStatus.CREATED)
//    @PostMapping("/cyclepath/saveall"
    @PostMapping(value = "/cyclepath/saveall", produces = MediaType.APPLICATION_JSON_VALUE)
    CyclePath newPath(CyclePath newPath) {
        return repository.save(newPath);
    }


    // Find
    @GetMapping("/cyclepath/{globalId}")
    Optional findOne(@PathVariable Integer globalId) {
        return repository.findById(globalId);
       //         .orElseThrow(() -> new BookNotFoundException(id));
    }

    // Find
    @GetMapping("/cyclepath/all")
    List<CyclePath> findAll() {
        return repository.findAll();
    }

//    @RequestMapping(method = RequestMethod.GET, value = "/cyclepath/maxlength", produces = MediaType.APPLICATION_JSON_VALUE)
//    public double getMaxCyclePathLength() {
//        double result;
//        List<CyclePath> temp = CyclePathConvert.getInstance().getCyclePathDataFromOpenSource();
//        result = CyclePathConvert.getInstance().maxCyclePathLength(temp);
//        return result;
//    }




}
