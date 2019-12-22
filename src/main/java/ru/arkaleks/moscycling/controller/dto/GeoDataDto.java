package ru.arkaleks.moscycling.controller.dto;

import lombok.Data;

@Data

public class GeoDataDto {

    private int globalId;
    private String type;
    private double[][][] coordinates;
}
