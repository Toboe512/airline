package ru.toboe512.airlines.controller.impl;

import lombok.RequiredArgsConstructor;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import ru.toboe512.airlines.controller.AuthenticateController;
import ru.toboe512.airlines.entity.Dto.AuthRequestDto;
import ru.toboe512.airlines.service.KeyCloakClientService;

/**
 *Контроллер для работы с токеном авторизации
 *
 */
@RestController
@RequiredArgsConstructor
public class AuthenticateControllerImpl implements AuthenticateController {

    private final KeyCloakClientService keyCloakClientService;

    @Override
    public ResponseEntity<AccessTokenResponse> authenticate(AuthRequestDto request) {
        return ResponseEntity.ok(keyCloakClientService.authenticate(request));
    }

    @Override
    public ResponseEntity<AccessTokenResponse> refresh(@RequestHeader("refresh-token") String refreshToken) {
        return ResponseEntity.ok(keyCloakClientService.refreshToken(refreshToken));
    }
}
