package ru.toboe512.airlines.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.toboe512.airlines.entity.Dto.FlightDto;
import ru.toboe512.airlines.entity.Flight;
import ru.toboe512.airlines.repository.FlightRepository;
import ru.toboe512.airlines.service.FlightService;
import ru.toboe512.airlines.util.exceptions.FlightNotFoundException;
import ru.toboe512.airlines.util.mapper.mapStruct.FlightMapper;

import java.util.Optional;

/**
 * Сервис для работы с бизнеслогикой рейса
 *
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightMapper flightMapper;

    private final FlightRepository flightRepository;

    @Transactional
    @Override
    public void saveFlight(FlightDto flightDto) {
        var flight = flightMapper.toModel(flightDto);
        flightRepository.save(flight);
    }

    @Transactional
    @Override
    public void updateFlight(FlightDto flightDto) {
        var flight = flightMapper.toModel(flightDto);
        flightRepository.save(flight);
    }

    @Override
    public FlightDto getFlightById(Long id) {
        var flight = flightRepository.findById(id).orElseThrow(FlightNotFoundException::new);
        return flightMapper.toDto(flight);
    }

    @Override
    public void delete(FlightDto flightDto) {
        var flight = flightMapper.toModel(flightDto);
        flightRepository.delete(flight);
    }
}
