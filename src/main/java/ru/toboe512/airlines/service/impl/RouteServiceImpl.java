package ru.toboe512.airlines.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.toboe512.airlines.entity.Dto.RouteDto;
import ru.toboe512.airlines.entity.Route;
import ru.toboe512.airlines.repository.RouteRepository;
import ru.toboe512.airlines.service.RouteService;
import ru.toboe512.airlines.util.exceptions.RouteNotFoundException;
import ru.toboe512.airlines.util.mapper.mapStruct.RouteMapper;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;

    private final RouteMapper routeMapper;

    @Override
    public RouteDto getRouteById(Long id) {
        var route = routeRepository.findById(id).orElseThrow(RouteNotFoundException::new);
        return routeMapper.toDto(route);
    }

    @Transactional
    @Override
    public void saveRoute(RouteDto routeDto) {
        var route = routeMapper.toModel(routeDto);
        routeRepository.save(route);
    }

    @Transactional
    @Override
    public void updateRoute(RouteDto routeDto) {
        var route =routeMapper.toModel(routeDto);
        routeRepository.save(route);
    }

    @Transactional
    @Override
    public void deleteRoute(RouteDto routeDto) {
        var route = routeMapper.toModel(routeDto);
        routeRepository.delete(route);
    }
}
