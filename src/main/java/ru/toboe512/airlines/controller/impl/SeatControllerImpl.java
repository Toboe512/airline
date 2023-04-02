package ru.toboe512.airlines.controller.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.toboe512.airlines.controller.SeatController;
import ru.toboe512.airlines.entity.Dto.SeatDto;
import ru.toboe512.airlines.entity.Seat;
import ru.toboe512.airlines.entity.SeatCategory;
import ru.toboe512.airlines.service.SeatService;
import ru.toboe512.airlines.util.mapper.mapStruct.SeatMapper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller for processing requests for add, change and get seat data.
 * Implements interface SeatController
 *
 */
@Log4j2
@RestController
@RequiredArgsConstructor
public class SeatControllerImpl implements SeatController {
    private final SeatService seatService;
    private final SeatMapper seatMapper;

    @Override
    public ResponseEntity<HttpStatus> createSeat(SeatDto seatDTO) {
        log.info("execute createSeat method");
        seatService.saveSeat(seatMapper.toModel(seatDTO));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> updateSeat(SeatDto seatDTO) {
        log.info("execute updateSeat method");
        seatService.updateSeat(seatMapper.toModel(seatDTO));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> deleteSeat(Long id) {
        log.info("execute deleteSeat method");
        var seat = seatService.getSeatById(id);
        seatService.deleteSeat(seat);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<SeatDto>> getAllSeatsOnFlight(Long flightId) {
        log.info("execute getAllSeatsOnFlight method");
        var seatsDto = seatService.getSeatByFlightId(flightId);
        return new ResponseEntity<>(seatsDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<SeatDto>> getSeatsOnFlightByCategory(Long flightId, SeatCategory seatCategory) {
        log.info("execute getSeatsOnFlightByCategory method");
        var seatsDto = seatService.getSeatByFlightIdAndCategory(flightId, seatCategory);
        return new ResponseEntity<>(seatsDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Integer> getNumberOfSoldSeats(Long flightId) {
        log.info("execute getNumberOfSoldSeats method");
        int numberOfSoldSeats = seatService.getNumberOfSoldSeats(flightId);
        return new ResponseEntity<>(numberOfSoldSeats, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Integer> getNumberOfUnsoldSeats(Long flightId) {
        log.info("execute getNumberOfUnsoldSeats method");
        int numberOfUnsoldSeats = seatService.getNumberOfUnsoldSeats(flightId);
        return new ResponseEntity<>(numberOfUnsoldSeats, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Integer> getNumberOfRegisteredPassengersOnFlight(Long flightId) {
        log.info("execute getNumberOfRegisteredPassengersOnFlight method");
        int numberOfRegisteredPassengers = seatService.getNumberOfRegisteredPassengers(flightId);
        return new ResponseEntity<>(numberOfRegisteredPassengers, HttpStatus.OK);
    }
}