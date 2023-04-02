package ru.toboe512.airlines.controller.impl;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.toboe512.airlines.controller.PassengerController;
import ru.toboe512.airlines.entity.Dto.PassengerDto;
import ru.toboe512.airlines.entity.Passenger;
import ru.toboe512.airlines.service.PassengerService;
import ru.toboe512.airlines.util.mapper.mapStruct.PassengerMapper;

import java.util.*;

@Log4j2
@RestController
@AllArgsConstructor
public class PassengerControllerImpl implements PassengerController {
    private final PassengerMapper passengerMapper;
    private final PassengerService passengerService;

    @Override
    public ResponseEntity<List<PassengerDto>> getAllPassengers() {
        log.info("execute getAllPassengers method");
        return new ResponseEntity<>(passengerService.getAllPassengers(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PassengerDto> getPassengerById(Long id) {
        log.info("execute getPassengerById method");
        PassengerDto passengerDto = passengerMapper.toDto(passengerService.getPassengerById(id));
        return new ResponseEntity<>(passengerDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PassengerDto> createPassenger(PassengerDto passengerDto) {
        log.info("execute createPassenger method");
        passengerService.savePassenger(passengerMapper.toModel(passengerDto));
        return new ResponseEntity<>(passengerDto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<PassengerDto> updatePassenger(PassengerDto passengerDto) {
        log.info("execute updatePassenger method");
        passengerService.updatePassenger(passengerMapper.toModel(passengerDto));
        return new ResponseEntity<>(passengerDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deletePassengerById(Long id) {
        log.info("execute deletePassengerById method");
        Passenger passenger = passengerService.getPassengerById(id);
        passengerService.deletePassengerById(passenger.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

