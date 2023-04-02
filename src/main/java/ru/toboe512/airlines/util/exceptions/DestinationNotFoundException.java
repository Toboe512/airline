package ru.toboe512.airlines.util.exceptions;

public class DestinationNotFoundException extends AbstractResourceNotFoundException {
    @Override
    protected String getResourceAlias() {
        return "Destination";
    }
}
