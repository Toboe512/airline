package ru.toboe512.airlines.util.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.toboe512.airlines.entity.Dto.ErrorResponseDto;
import ru.toboe512.airlines.util.exceptions.FlightNotFoundException;

@ControllerAdvice
public class FlightExceptionHandler extends AbstractExceptionHandler {

    @ExceptionHandler(FlightNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> flightExceptionHandler(final FlightNotFoundException ex) {
        return buildErrorResponse(ex, HttpStatus.NOT_FOUND);
    }
}
