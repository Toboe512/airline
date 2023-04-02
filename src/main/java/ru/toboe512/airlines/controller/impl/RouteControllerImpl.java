package ru.toboe512.airlines.controller.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.toboe512.airlines.controller.RouteController;
import ru.toboe512.airlines.entity.Dto.RouteDto;
import ru.toboe512.airlines.service.RouteService;

/**
 * Контроллер для работы с Route
 *
 */
@Log4j2
@RestController
public class RouteControllerImpl implements RouteController {
    private final RouteService routeService;

    public RouteControllerImpl(RouteService routeService) {
        this.routeService = routeService;
    }

    @Override
    public ResponseEntity<RouteDto> getRouteById(Long id) {
        log.info("execute getRouteById method");
        var route = routeService.getRouteById(id);
        return new ResponseEntity<>(route, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> createRoute(RouteDto routeDto) {
        log.info("execute createRoute method");
        routeService.saveRoute(routeDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> updateRoute(RouteDto routeDto) {
        log.info("execute updateRoute method");
        routeService.updateRoute(routeDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> deleteRoute(Long id) {
        log.info("execute deleteRoute method");
        var routeDto = routeService.getRouteById(id);
        routeService.deleteRoute(routeDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
