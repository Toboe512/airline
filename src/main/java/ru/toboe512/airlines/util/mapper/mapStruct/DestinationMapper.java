package ru.toboe512.airlines.util.mapper.mapStruct;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.toboe512.airlines.entity.Destination;
import ru.toboe512.airlines.entity.Dto.DestinationDto;

@Mapper(componentModel = "spring", uses = DestinationMapper.class)
public interface DestinationMapper {

    DestinationMapper INSTANCE = Mappers.getMapper(DestinationMapper.class);

    Destination toModel(DestinationDto destinationDto);

    DestinationDto toDto(Destination destination);
}
