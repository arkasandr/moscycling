package ru.arkaleks.moscycling.controller.dto;

import lombok.Data;
import ru.arkaleks.moscycling.model.Cell;

import java.util.List;

@Data
public class CyclePathDto {

    private int globalId;
    private int number;
    private List<Cell> cell;
    private String name;
    private String objectOperOrgPhone;
    private double width;
    private String location;
    private String departamentalAffiliation;
    private String operOrgName;
    private String portionName;
}
