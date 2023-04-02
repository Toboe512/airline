package ru.toboe512.airlines.util.mapper.mapStruct;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.toboe512.airlines.entity.Aircraft;
import ru.toboe512.airlines.entity.Dto.AircraftDto;

/**
 * Interface AircraftMapper.
 * Declares mapper between Aircraft and AircraftDto via MapStruct.
 *
 */
@Mapper(componentModel = "spring", uses = SeatMapper.class )
public interface AircraftMapper {

    AircraftMapper INSTANCE = Mappers.getMapper(AircraftMapper.class);
    /**
     * Method maps AircraftDto to Aircraft
     * @param aircraftDto AircraftDto to map from.
     * @return Aircraft
     */
    Aircraft toModel(AircraftDto aircraftDto);

    /**
     * Method maps Aircraft to AircraftDto
     * @param aircraft Aircraft to map from.
     * @return AircraftDto
     */
    AircraftDto toDto(Aircraft aircraft);
}
