package ru.arkaleks.moscycling.controller.dto;

import lombok.Data;
import ru.arkaleks.moscycling.model.DataLength;
import ru.arkaleks.moscycling.model.PathType;

import java.util.List;

@Data
public class CellDto {

    private int id;
    private List<PathType> pathType;
    private List<DataLength> length;
}
