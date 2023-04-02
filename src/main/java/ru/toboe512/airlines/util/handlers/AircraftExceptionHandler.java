package ru.toboe512.airlines.util.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.toboe512.airlines.entity.Dto.ErrorResponseDto;
import ru.toboe512.airlines.util.exceptions.AircraftNotFoundException;

@ControllerAdvice
public class AircraftExceptionHandler extends AbstractExceptionHandler {
    @ExceptionHandler(AircraftNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> aircraftExceptionHandler(final AircraftNotFoundException ex) {
        return buildErrorResponse(ex, HttpStatus.NOT_FOUND);
    }

}
