package ru.toboe512.airlines.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * Перечисление полётного статуса - "По плану", "Задержан", "Отменён".
 *
 */

@Getter
@ToString
@AllArgsConstructor
public enum FlightStatus {
    PLANNED("The flight will proceed as planned."),
    DELAYED("Flight delayed, sorry."),
    CANCELLED("Flight canceled.");

    private final String status;
}
