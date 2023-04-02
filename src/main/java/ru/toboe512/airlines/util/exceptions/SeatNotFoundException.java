package ru.toboe512.airlines.util.exceptions;

public class SeatNotFoundException extends AbstractResourceNotFoundException {
    @Override
    protected String getResourceAlias() {
        return "Seat";
    }

}
