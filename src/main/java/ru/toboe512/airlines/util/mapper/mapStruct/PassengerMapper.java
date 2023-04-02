package ru.toboe512.airlines.util.mapper.mapStruct;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.toboe512.airlines.entity.Dto.PassengerDto;
import ru.toboe512.airlines.entity.Passenger;

@Mapper(componentModel = "spring", uses = {PassengerMapper.class, DocumentMapper.class})
public interface PassengerMapper {

    PassengerMapper INSTANCE = Mappers.getMapper(PassengerMapper.class);
    /**
     * Maps Passenger to PassengerDto
     * @param passenger Passenger
     * @return PessengerDto
     */
    PassengerDto toDto(Passenger passenger);

    /**
     * Maps PassengerDto to Passenger
     * @param passengerDto PassengerDto
     * @return Passenger
     */
    Passenger toModel(PassengerDto passengerDto);
}
