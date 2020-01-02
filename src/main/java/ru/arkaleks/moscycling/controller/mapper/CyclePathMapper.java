package ru.arkaleks.moscycling.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import ru.arkaleks.moscycling.controller.dto.CyclePathDto;
import ru.arkaleks.moscycling.model.CyclePath;

import java.util.List;

@Mapper
public interface CyclePathMapper {

    CyclePathMapper INSTANCE = Mappers.getMapper(CyclePathMapper.class);
 //   @Mapping(target = "number", ignore = true)
    List<CyclePathDto> mapToCyclePathDtoList(List<CyclePath> cyclePathEntityList);

    CyclePathDto mapToCyclePathDto(CyclePath cyclePathEntity);

}
