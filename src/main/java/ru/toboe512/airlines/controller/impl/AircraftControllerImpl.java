package ru.toboe512.airlines.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.toboe512.airlines.controller.AircraftController;
import ru.toboe512.airlines.entity.Aircraft;
import ru.toboe512.airlines.entity.Dto.AircraftDto;
import ru.toboe512.airlines.service.AircraftService;
import ru.toboe512.airlines.util.mapper.mapStruct.AircraftMapper;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AircraftControllerImpl implements AircraftController {
    private final AircraftService aircraftService;

    private final AircraftMapper aircraftMapper;

    @Override
    public ResponseEntity<List<AircraftDto>> getAllAircrafts() {
        return new ResponseEntity<>(aircraftService.getAllAircrafts(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AircraftDto> getAircraftById(Long id) {
        var aircraftDto = aircraftService.getAircraftById(id);
        return new ResponseEntity<>(aircraftDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> createAircraft(AircraftDto aircraftDto) {
        aircraftService.saveAircraft(aircraftDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> updateAircraft(AircraftDto aircraftDto) {
        aircraftService.updateAircraft(aircraftDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> deleteAircraftById(Long id) {
        var aircraft = aircraftService.getAircraftById(id);
        aircraftService.delete(aircraft);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}

