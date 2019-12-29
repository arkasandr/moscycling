package ru.arkaleks.moscycling.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.arkaleks.moscycling.controller.CyclePathNotFoundException;
import ru.arkaleks.moscycling.controller.CyclePathUnSupportedFieldPatchException;
import ru.arkaleks.moscycling.controller.dto.CyclePathDto;
import ru.arkaleks.moscycling.controller.mapper.CyclePathMapper;
import ru.arkaleks.moscycling.model.CyclePath;
import ru.arkaleks.moscycling.repository.CyclePathRepository;

import java.util.List;
import java.util.Map;


@RequiredArgsConstructor

@Service
public class CyclePathService {

    @Autowired
    private CyclePathRepository cyclePathRepository;
//    private CyclePathMapper mapper = CyclePathMapper.INSTANCE;
//
//    public List<CyclePathDto> getAllPath() {
//        return mapper.mapToCyclePathDtoList(cyclePathRepository.findAll());
//    }
//
//    public CyclePathDto getCyclePathById(Integer id) {
//        return mapper.mapToCyclePathDto(cyclePathRepository.findById(id).orElseThrow(() -> new CyclePathNotFoundException(id)));
//    }
//
//    public CyclePathDto updateCyclePathById(CyclePath cyclePath, Integer id) {
//        return mapper.mapToCyclePathDto(cyclePathRepository.findById(id)
//                .map(x -> {
//                    x.setNumber(cyclePath.getNumber());
//                    x.setCells(cyclePath.getCells());
//                    return cyclePathRepository.save(x);
//                })
//                .orElseGet(() -> {
//                    cyclePath.setGlobalId(id);
//                    return cyclePathRepository.save(cyclePath);
//                }));
//    }
//
//    public CyclePathDto patchCyclePathNumber(Map<String, Integer> update, Integer id) {
//        return mapper.mapToCyclePathDto(cyclePathRepository.findById(id)
//                .map(x -> {
//                    int upNumber = update.get("Number");
//                    if (upNumber != 0) {
//                        x.setNumber(upNumber);
//                        return cyclePathRepository.save(x);
//                    } else {
//                        throw new CyclePathUnSupportedFieldPatchException(update.keySet());
//                    }
//                })
//                .orElseGet(() -> {
//                    throw new CyclePathNotFoundException(id);
//                }));
//    }
//
//    public void deleteCyclePath(Integer id) {
//        CyclePath cyclePath = cyclePathRepository.getOne(id);
//        cyclePathRepository.delete(cyclePath);
//    }

}
