package ru.toboe512.airlines.util.exceptions;

public class PassengerNotFoundException extends AbstractResourceNotFoundException {

    public PassengerNotFoundException(Long id) {
        super(String.valueOf(id));
    }

    @Override
    protected String getResourceAlias() {
        return "Passenger";
    }
}
