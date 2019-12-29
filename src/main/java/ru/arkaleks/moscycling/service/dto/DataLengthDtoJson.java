package ru.arkaleks.moscycling.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataLengthDtoJson {

 //   @JsonProperty("global_id")
    private int globalId;
    private int pointNumber;
    private List<CoordinateDtoJson> coors;
}
