package ru.toboe512.airlines.util.exceptions;

public class FlightNotFoundException extends AbstractResourceNotFoundException {
    @Override
    protected String getResourceAlias() {
        return "Flight";
    }
}
