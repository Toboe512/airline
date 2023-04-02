package ru.toboe512.airlines.util.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.toboe512.airlines.entity.Dto.ErrorResponseDto;
import ru.toboe512.airlines.util.exceptions.RouteNotFoundException;

@ControllerAdvice
public class RouteExceptionHandler extends AbstractExceptionHandler {

    @ExceptionHandler(RouteNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> routeExceptionHandler(final RouteNotFoundException ex) {
        return buildErrorResponse(ex, HttpStatus.NOT_FOUND);
    }
}
