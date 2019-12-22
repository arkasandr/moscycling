package ru.arkaleks.moscycling.controller.dto;

import lombok.Data;

@Data
public class CellsDto {

    private int globalId;
    private String name;
    private String objectOperOrgPhone;
    private String[] type;
    private double width;
    private String location;
    private GeoDataDto geoData;
    private String departamentalAffiliation;
    private String operOrgName;
    private String portionName;
}
