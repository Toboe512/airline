package ru.toboe512.airlines.entity.Dto;

/**
 * Универсальный DTO для ошибок
 */
public class ErrorResponseDto {
    private String message;

    public ErrorResponseDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
