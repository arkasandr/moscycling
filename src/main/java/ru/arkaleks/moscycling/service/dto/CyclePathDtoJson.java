package ru.arkaleks.moscycling.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.arkaleks.moscycling.service.deserializer.CellJsonDeserializer;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = CellJsonDeserializer.class)
public class CyclePathDtoJson {

    @JsonProperty("global_id")
    private int globalId;
    @JsonProperty("Number")
    private int number;
    @JsonProperty("Cells")
    private List<CellDtoJson> cells;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("ObjectOperOrgPhone")
    private String objectOperOrgPhone;
    @JsonProperty("Width")
    private double width;
    @JsonProperty("Location")
    private String location;
    @JsonProperty("DepartamentalAffiliation")
    private String departamentalAffiliation;
    @JsonProperty("OperOrgName")
    private String operOrgName;
    @JsonProperty("PortionName")
    private String portionName;
}
