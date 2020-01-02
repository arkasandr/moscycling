package ru.arkaleks.moscycling.controller.dto;

import lombok.Data;
import ru.arkaleks.moscycling.model.GeoData;
import ru.arkaleks.moscycling.model.Type;

import java.util.List;

@Data
public class CellDto {

    private int globalId;
    private List<Type> type;
    private GeoData geoData;
}
