package ru.arkaleks.moscycling.service.mapper;

import org.mapstruct.Mapper;

import org.mapstruct.factory.Mappers;
import ru.arkaleks.moscycling.model.*;
import ru.arkaleks.moscycling.service.dto.*;

import java.util.List;

@Mapper
public interface CyclePathMapperJson {

    CyclePathMapperJson INSTANCE = Mappers.getMapper(CyclePathMapperJson.class);

    CyclePathDtoJson mapToCyclePathDto(CyclePath cyclePathEntity);

    CyclePath mapToCyclePath(CyclePathDtoJson cyclePathDtoJson);

    List<Cell> mapToCell(List<CellDtoJson> cellDtoJson);

    List<CellDtoJson> mapToCellDtoJson(List<Cell> cell);

    List<Type> mapToType(List<TypeDtoJson> typeDtoJson);
    List<TypeDtoJson> mapToTypeDtoJson(List<Type> type);

    List<Coordinate> mapToCoordinate(List<CoordinateDtoJson> coordinateDtoJson);
    List<CoordinateDtoJson> mapToCoordinateDtoJson(List<Coordinate> coordinate);

    List<DataLength> mapToDataLength(List<DataLengthDtoJson> dataLengthDtoJson);
    List<DataLengthDtoJson> mapToDataLengthDtoJson(List<DataLength> dataLength);


}
