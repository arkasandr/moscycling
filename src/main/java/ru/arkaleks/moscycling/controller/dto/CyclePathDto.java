package ru.arkaleks.moscycling.controller.dto;

import lombok.Data;

@Data

public class CyclePathDto {

    private int globalId;
    private int number;
    private CellsDto cells;
}
