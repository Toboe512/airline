package ru.toboe512.airlines.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum DocumentType.
 * Holds document types.
 *
 */
@Getter
@RequiredArgsConstructor
public enum DocumentType {
    NATIONAL_PASSPORT("National passport"),

    INTERNATIONAL_PASSPORT("International passport");

    private final String value;
}
