package ru.arkaleks.moscycling.service.mapper;

import org.mapstruct.Mapper;

import org.mapstruct.factory.Mappers;
import ru.arkaleks.moscycling.model.CyclePath;
import ru.arkaleks.moscycling.service.dto.CyclePathDtoJson;

@Mapper
public interface CyclePathMapperJson {

    CyclePathMapperJson INSTANCE = Mappers.getMapper(CyclePathMapperJson.class);

    CyclePathDtoJson mapToCyclePathDto(CyclePath cyclePathEntity);

    CyclePath mapToCyclePath(CyclePathDtoJson cyclePathDtoJson);

}
