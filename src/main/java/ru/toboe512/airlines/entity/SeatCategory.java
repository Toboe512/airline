package ru.toboe512.airlines.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Enumeration of ticket categories - "Economy", "Business", "First".
 *
 */
@Getter
@RequiredArgsConstructor
@ToString
public enum SeatCategory {
    FIRST("First"),
    BUSINESS("Business"),
    ECONOMY("Economy");

    private final String value;
}