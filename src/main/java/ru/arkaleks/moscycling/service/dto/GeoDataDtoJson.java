package ru.arkaleks.moscycling.service.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoDataDtoJson {

    private int globalId;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("coordinates")
    private double[][][] coordinates;
}