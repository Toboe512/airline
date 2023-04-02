package ru.toboe512.airlines.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.toboe512.airlines.entity.Aircraft;
import ru.toboe512.airlines.entity.Dto.AircraftDto;
import ru.toboe512.airlines.repository.AircraftRepository;
import ru.toboe512.airlines.service.AircraftService;
import ru.toboe512.airlines.util.mapper.mapStruct.AircraftMapper;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Сервис для работы с бизнеслогикой Aircraft
 */

@Service
@RequiredArgsConstructor
public class AircraftServiceImpl implements AircraftService {
    private final AircraftRepository aircraftRepository;
    private final AircraftMapper aircraftMapper;

    @Transactional
    @Override
    public List<AircraftDto> getAllAircrafts() {
        return aircraftRepository.findAll()
                .stream()
                .map(aircraftMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public Aircraft saveAircraft(AircraftDto aircraftDto) {
        var aircraft = aircraftMapper.toModel(aircraftDto);
        return aircraftRepository.save(aircraft);
    }

    @Transactional
    @Override
    public void updateAircraft(AircraftDto aircraftDto) {
        var aircraft = aircraftMapper.toModel(aircraftDto);
        aircraftRepository.save(aircraft);
    }

    @Override
    public AircraftDto getAircraftById(Long id) {
        var aircraft = aircraftRepository.findById(id).orElseThrow();
        return aircraftMapper.toDto(aircraft);
    }

    @Override
    public void delete(AircraftDto aircraftDto) {
        var aircraft = aircraftMapper.toModel(aircraftDto);
        aircraftRepository.delete(aircraft);
    }
}
