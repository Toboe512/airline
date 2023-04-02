package ru.toboe512.airlines.util.mapper.mapStruct;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.toboe512.airlines.entity.Dto.RouteDto;
import ru.toboe512.airlines.entity.Route;

@Mapper(componentModel = "spring", uses = {RouteMapper.class, DestinationMapper.class})
public interface RouteMapper {

    RouteMapper INSTANCE = Mappers.getMapper(RouteMapper.class);

    Route toModel(RouteDto routeDto);

    RouteDto toDto(Route route);
}
