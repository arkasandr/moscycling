package ru.arkaleks.moscycling.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CellDtoJson {

//    @JsonProperty("global_id")
    private int globalId;
    private List<TypeDtoJson> type;
//    @JsonProperty("geoData")
    private GeoDataDtoJson geoData;
}
