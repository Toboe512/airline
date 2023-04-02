package ru.toboe512.airlines.util.mapper.mapStruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.toboe512.airlines.entity.Aircraft;
import ru.toboe512.airlines.entity.Dto.SeatDto;
import ru.toboe512.airlines.entity.Seat;

/**
 * Interface SeatMapper.
 * Declares mapper between Seat and SeatDto via MapStruct.
 *
 */
@Mapper(componentModel = "spring")
public interface SeatMapper {

    SeatMapper INSTANCE = Mappers.getMapper(SeatMapper.class);

    /**
     * Method maps SeatDto to Seat
     * @param seatDto SeatDto
     * @return Seat
     */
    Seat toModel(SeatDto seatDto);

    /**
     * Method maps Seat to SeatDto
     * @param seat Seat
     * @return SeatDto
     */
    SeatDto toDto(Seat seat);
}
