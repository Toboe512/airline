package ru.toboe512.airlines.util.exceptions;

public class AircraftNotFoundException extends AbstractResourceNotFoundException {
    public AircraftNotFoundException(Long id) {
        super(String.valueOf(id));
    }

    @Override
    protected String getResourceAlias() {
        return "Aircraft";
    }
}
