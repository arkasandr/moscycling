package ru.arkaleks.moscycling.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CoordinateDtoJson {

 //   @JsonProperty("global_id")
    private int globalId;
    private Double coorX;
    private Double coorY;
}
