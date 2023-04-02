package ru.toboe512.airlines.service;

import ru.toboe512.airlines.entity.Destination;
import ru.toboe512.airlines.entity.Dto.DestinationDto;

import java.util.List;

public interface DestinationService {
    DestinationDto getById(Long id);

    void update(DestinationDto destination);

    void deleteById(Long id);

    void create(DestinationDto destinationDto);

    List<DestinationDto> getByCity(String city);

    List<DestinationDto> getByCountry(String countryName);
}