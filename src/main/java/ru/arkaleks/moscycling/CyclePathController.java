package ru.arkaleks.moscycling;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class CyclePathController {

   @RequestMapping(method = RequestMethod.GET, value ="/cyclepath/all", produces = MediaType.APPLICATION_JSON_VALUE)
   public List<CyclePath> getAllCyclePath(){
       return CyclePathConvert.getInstance().cyclePathConvert();
   }

    @RequestMapping(method = RequestMethod.GET, value ="/cyclepath/id", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Integer> getAllCyclePathId() {
        List<Integer> result = new ArrayList<>();
        List<CyclePath> temp = CyclePathConvert.getInstance().cyclePathConvert();
        for (CyclePath cp : temp) {
            result.add(cp.getGlobal_id());
        }
        return result;
    }

        @RequestMapping(method = RequestMethod.GET, value ="/cyclepath/length", produces = MediaType.APPLICATION_JSON_VALUE)
        public List<Integer> getAllCyclePathLength() {
            List<Double> result = new ArrayList<>();
            List<Double> coordinates = new ArrayList<>();
            List<CyclePath> temp = CyclePathConvert.getInstance().cyclePathConvert();
            for (CyclePath cp : temp) {
                coordinates.add(cp.getCells());
            }
            return result;
        }

}
