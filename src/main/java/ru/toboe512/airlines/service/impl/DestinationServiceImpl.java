package ru.toboe512.airlines.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.toboe512.airlines.entity.Destination;
import ru.toboe512.airlines.entity.Dto.DestinationDto;
import ru.toboe512.airlines.repository.DestinationRepository;
import ru.toboe512.airlines.service.DestinationService;
import ru.toboe512.airlines.util.mapper.mapStruct.DestinationMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DestinationServiceImpl implements DestinationService {

    private final DestinationMapper destinationMapper;

    private final DestinationRepository destinationRepository;

    @Transactional
    @Override
    public void create(DestinationDto destinationDto) {
        var destination = destinationMapper.toModel(destinationDto);
        destinationRepository.saveAndFlush(destination);
    }

    @Override
    public DestinationDto getById(Long id) {
        var destination = destinationRepository.findById(id).orElseThrow();
        return destinationMapper.toDto(destination);
    }

    @Transactional
    @Override
    public void update(DestinationDto destinationDto) {
        Destination destination = destinationMapper.toModel(destinationDto);
        destinationRepository.saveAndFlush(destination);
    }

    @Override
    public void deleteById(Long id) {
        destinationRepository.deleteById(id);
    }

    @Transactional
    @Override
    public List<DestinationDto> getByCity(String city) {
        return destinationRepository
                .getByCity(city)
                .stream()
                .map(destinationMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public List<DestinationDto> getByCountry(String countryName) {
        return destinationRepository
                .getByCountry(countryName)
                .stream()
                .map(destinationMapper::toDto)
                .collect(Collectors.toList());
    }
}
