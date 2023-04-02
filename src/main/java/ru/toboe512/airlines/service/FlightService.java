package ru.toboe512.airlines.service;

import ru.toboe512.airlines.entity.Dto.FlightDto;
import ru.toboe512.airlines.entity.Flight;

/**
 * Сервис для работы с бизнеслогикой рейса
 *
 */
public interface FlightService {

    void saveFlight(FlightDto flightDto);

    void updateFlight(FlightDto flightDto);

    FlightDto getFlightById(Long id);

    void delete(FlightDto flightDto);
}
