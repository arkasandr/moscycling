package ru.arkaleks.moscycling.service.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;

/**
 * @author Alex Arkashev (arkasandr@gmail.com)
 * @version $Id$
 * @since 0.1
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CellsDtoJson {

    @JsonProperty("global_id")
    private int globalId;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("ObjectOperOrgPhone")
    private String objectOperOrgPhone;
    @Column(length = 1000000000)
    @JsonProperty("Type")
    private String[] type;
    @JsonProperty("Width")
    private double width;
    @JsonProperty("Location")
    private String location;
    @JsonProperty("geoData")
    private GeoDataDtoJson geoData;
    @JsonProperty("DepartamentalAffiliation")
    private String departamentalAffiliation;
    @JsonProperty("OperOrgName")
    private String operOrgName;
    @JsonProperty("PortionName")
    private String portionName;
}
