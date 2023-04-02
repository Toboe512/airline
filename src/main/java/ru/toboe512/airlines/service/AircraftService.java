package ru.toboe512.airlines.service;

import ru.toboe512.airlines.entity.Aircraft;
import ru.toboe512.airlines.entity.Dto.AircraftDto;
import java.util.List;

/**
 * Сервис для работы с бизнеслогикой Aircraft
 */

public interface AircraftService {
    List<AircraftDto> getAllAircrafts();

    AircraftDto getAircraftById(Long id);

    void updateAircraft(AircraftDto aircraftDto);

    Aircraft saveAircraft(AircraftDto aircraftDto);

    void delete(AircraftDto aircraftDto);
}
