package ru.toboe512.airlines.service;

import ru.toboe512.airlines.entity.Dto.RouteDto;
import ru.toboe512.airlines.entity.Route;

/**
 * Сервис для работы с Route
 *
 */
public interface RouteService {

    RouteDto getRouteById(Long id);

    void saveRoute(RouteDto routeDto);

    void updateRoute(RouteDto routeDto);

    void deleteRoute(RouteDto routeDto);
}
