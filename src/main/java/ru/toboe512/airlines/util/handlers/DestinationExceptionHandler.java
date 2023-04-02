package ru.toboe512.airlines.util.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.toboe512.airlines.entity.Dto.ErrorResponseDto;
import ru.toboe512.airlines.util.exceptions.DestinationNotFoundException;

@ControllerAdvice
public class DestinationExceptionHandler extends AbstractExceptionHandler {

    @ExceptionHandler(DestinationNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> destinationNotFoundException(DestinationNotFoundException destinationNotFoundException) {
        return buildErrorResponse(destinationNotFoundException, HttpStatus.NOT_FOUND);
    }
}