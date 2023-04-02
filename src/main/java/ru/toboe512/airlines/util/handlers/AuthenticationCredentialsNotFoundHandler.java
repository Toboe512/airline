package ru.toboe512.airlines.util.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.toboe512.airlines.entity.Dto.ErrorResponseDto;

@ControllerAdvice
public class AuthenticationCredentialsNotFoundHandler extends AbstractExceptionHandler {

    @ExceptionHandler(AuthenticationCredentialsNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> authenticationExceptionHandler(final AuthenticationCredentialsNotFoundException ex) {
        return buildErrorResponse(ex, HttpStatus.UNAUTHORIZED);
    }
}
