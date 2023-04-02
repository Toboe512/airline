package ru.toboe512.airlines.controller.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.toboe512.airlines.controller.DestinationController;
import ru.toboe512.airlines.entity.Dto.DestinationDto;
import ru.toboe512.airlines.service.impl.DestinationServiceImpl;

import java.util.List;

@RestController
public class DestinationControllerImpl implements DestinationController {
    DestinationServiceImpl destinationService;

    public DestinationControllerImpl(DestinationServiceImpl destinationService) {
        this.destinationService = destinationService;
    }

    @Override
    public ResponseEntity<HttpStatus> create(DestinationDto destinationDto) {
        destinationService.create(destinationDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DestinationDto> getById(Long id) {
        var destinationDto = destinationService.getById(id);
        return new ResponseEntity<>(destinationDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> update(DestinationDto destinationDto) {
        destinationService.update(destinationDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> deleteById(Long id) {
        destinationService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<DestinationDto>> getByCity(String city) {
        var destinationListDto = destinationService.getByCity(city);
        return new ResponseEntity<>(destinationListDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<DestinationDto>> getByCountry(String country) {
        var destinationListDto = destinationService.getByCountry(country);
        return new ResponseEntity<>(destinationListDto, HttpStatus.OK);
    }
}