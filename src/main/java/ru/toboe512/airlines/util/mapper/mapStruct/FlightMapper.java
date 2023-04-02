package ru.toboe512.airlines.util.mapper.mapStruct;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.toboe512.airlines.entity.Dto.FlightDto;
import ru.toboe512.airlines.entity.Flight;

/**
 * Преобразование сущность Flight в DTO и обратно
 *
 */
@Mapper(componentModel = "spring", uses = {FlightMapper.class, DestinationMapper.class})
public interface FlightMapper {

    FlightMapper INSTANCE = Mappers.getMapper(FlightMapper.class);

    Flight toModel(FlightDto flightDto);

    FlightDto toDto(Flight flight);
}