package ru.toboe512.airlines.controller.impl;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.toboe512.airlines.controller.FlightController;
import ru.toboe512.airlines.entity.Dto.FlightDto;
import ru.toboe512.airlines.entity.Seat;
import ru.toboe512.airlines.service.FlightService;

/**
 * Контроллер для обработки запросов по добавлению, изменению и получению данных рейса
 *
 */
@Log4j2
@RestController
@RequiredArgsConstructor
public class FlightControllerImpl implements FlightController {

    private final FlightService flightService;

    @Override
    public ResponseEntity<FlightDto> getFlightById(Long id) {
        log.info("execute getFlightById method");
        var flight = flightService.getFlightById(id);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> createFlight(FlightDto flight) {
        log.info("execute createFlight method");
        flightService.saveFlight(flight);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> updateFlight(FlightDto flight) {
        log.info("execute updateFlight method");
        flightService.updateFlight(flight);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> deleteFlightById(Long id) {
        log.info("execute deleteFlightById method");
        var flightDto = flightService.getFlightById(id);
        flightService.delete(flightDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }


    @Override
    public ResponseEntity<Seat> getFreeSeatsOnFlight(FlightDto flight) {
        log.info("execute getFreeSeatsOnFlight method");
        return null;//TODO после добавления Seat доработать
    }
}
