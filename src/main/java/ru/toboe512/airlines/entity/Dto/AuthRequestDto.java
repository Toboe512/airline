package ru.toboe512.airlines.entity.Dto;

import lombok.Value;

import javax.validation.constraints.NotEmpty;

/**
 * Сущность для аутентификации пользователя по логину и паролю
 */
@Value
public class AuthRequestDto {
    @NotEmpty
    String username;

    @NotEmpty
    String password;
}
