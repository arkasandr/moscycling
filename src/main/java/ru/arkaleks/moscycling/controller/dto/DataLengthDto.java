package ru.arkaleks.moscycling.controller.dto;

import lombok.Data;
import ru.arkaleks.moscycling.model.Coordinate;

import java.util.List;

@Data
public class DataLengthDto {

    private int id;
    private int pointNumber;
    private List<Coordinate> coors;
}
