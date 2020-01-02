package ru.arkaleks.moscycling.controller.dto;

import lombok.Data;
import ru.arkaleks.moscycling.model.DataLength;

import java.util.List;

@Data
public class GeoDataDto {

    private int globalId;
    private List<DataLength> length;
}
