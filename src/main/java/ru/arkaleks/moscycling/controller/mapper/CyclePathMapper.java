package ru.arkaleks.moscycling.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.arkaleks.moscycling.controller.dto.*;
import ru.arkaleks.moscycling.model.*;

import java.util.List;

/**
 * @author Alex Arkashev (arkasandr@gmail.com)
 * @version $Id$
 * @since 0.1
 */

@Mapper
public interface CyclePathMapper {

    CyclePathMapper INSTANCE = Mappers.getMapper(CyclePathMapper.class);

    List<CyclePathDto> mapToCyclePathDtoList(List<CyclePath> cyclePathEntityList);

    CyclePathDto mapToCyclePathDto(CyclePath cyclePathEntity);

    List<PathTypeDto> mapToPathTypeDtoList(List<PathType> pathTypeEntityList);

    List<DataLengthDto> mapToDataLengthDtoList(List<DataLength> dataLengthEntityList);

    List<CoordinateDto> mapToCoordinateDtoList(List<Coordinate> coordinateEntityList);

}
