package ru.arkaleks.moscycling.controller.dto;

import lombok.Data;

/**
 * @author Alex Arkashev (arkasandr@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@Data
public class CyclePathDto {

    private int id;
    private int number;
    private String name;
    private String objectOperOrgPhone;
    private double width;
    private String location;
    private String departamentalAffiliation;
    private String operOrgName;
    private String portionName;
}
